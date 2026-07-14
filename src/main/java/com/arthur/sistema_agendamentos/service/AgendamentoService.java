package com.arthur.sistema_agendamentos.service;

import com.arthur.sistema_agendamentos.dto.AgendamentoRequestDTO;
import com.arthur.sistema_agendamentos.dto.AgendamentoResponseDTO;
import com.arthur.sistema_agendamentos.entity.Agendamento;
import com.arthur.sistema_agendamentos.entity.TipoServico;
import com.arthur.sistema_agendamentos.exception.HorarioIndisponivelException;
import com.arthur.sistema_agendamentos.repository.AgendamentoRepository;
import com.arthur.sistema_agendamentos.repository.TipoServicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    private final TipoServicoRepository tipoServicoRepository;

    public AgendamentoService(AgendamentoRepository repository, TipoServicoRepository tipoServicoRepository) {
        this.repository = repository;
        this.tipoServicoRepository = tipoServicoRepository;
    }

    private AgendamentoResponseDTO converterParaDTO(Agendamento agendamento) {
        AgendamentoResponseDTO dto = new AgendamentoResponseDTO();
        dto.setId(agendamento.getId());
        dto.setNomeCliente(agendamento.getNomeCliente());
        dto.setTelefone(agendamento.getTelefone());
        dto.setData(agendamento.getData());
        dto.setHorario(agendamento.getHorario());
        dto.setTipoServicoId(agendamento.getTipoServico().getId());
        dto.setNomeTipoServico(agendamento.getTipoServico().getNome());

        return dto;
    }

    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO dto) {
        validarData(dto.getData());
        validarHorario(dto.getHorario());

        if (repository.existsByDataAndHorario(
                dto.getData(),
                dto.getHorario())) {

            throw new HorarioIndisponivelException();
        }

        TipoServico tipoServico = tipoServicoRepository.findById(dto.getTipoServicoId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de serviço não encontrado"));

        Agendamento agendamento = new Agendamento(
                dto.getNomeCliente(),
                dto.getTelefone(),
                dto.getData(),
                dto.getHorario(),
                tipoServico
        );

        Agendamento salvo = repository.save(agendamento);
        return converterParaDTO(salvo);
    }


    public Page<AgendamentoResponseDTO> listarAgendamentosPaginados(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by("data", "horario").ascending());
        Page<Agendamento> agendamentos = repository.findAll(pageable);
        return agendamentos.map(this::converterParaDTO);
    }


    public AgendamentoResponseDTO buscarAgendamento(Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        return converterParaDTO(agendamento);
    }

    public void deletarAgendamento(Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        repository.delete(agendamento);
    }

    public AgendamentoResponseDTO atualizarAgendamento(Long id, AgendamentoRequestDTO novoDto) {
        validarData(novoDto.getData());
        validarHorario(novoDto.getHorario());

        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));


        TipoServico tipoServico = tipoServicoRepository.findById(novoDto.getTipoServicoId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de serviço não encontrado"));

        if (repository.existsByDataAndHorarioAndIdNot(
                novoDto.getData(),
                novoDto.getHorario(),
                id)) {

            throw new HorarioIndisponivelException();
        }

        agendamento.setNomeCliente(novoDto.getNomeCliente());
        agendamento.setTelefone(novoDto.getTelefone());
        agendamento.setData(novoDto.getData());
        agendamento.setHorario(novoDto.getHorario());
        agendamento.setTipoServico(tipoServico);

        Agendamento atualizado = repository.save(agendamento);
        return converterParaDTO(atualizado);
    }

    private void validarData(LocalDate data) {
        LocalDate hoje = LocalDate.now();
        if (data.isBefore(hoje)) {

            throw new IllegalArgumentException("Essa data não está mais disponível");
        }

    }

    private void validarHorario(LocalTime horario) {
        LocalTime abertura = LocalTime.of(8, 0);
        LocalTime fechamento = LocalTime.of(18, 0);

        if (horario.isBefore(abertura) || horario.isAfter(fechamento)) {
            throw new IllegalArgumentException("Horário de funcionamento entre 8h e 18h");
        }
    }

    public List<AgendamentoResponseDTO> buscarPorTelefone(String telefone) {
        List<Agendamento> agendamentos = repository.findByTelefone(telefone);
        List<AgendamentoResponseDTO> dtos = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            dtos.add(converterParaDTO(agendamento));

        }
        return dtos;
    }

    public List<AgendamentoResponseDTO> buscarPorData(LocalDate data) {
        List<Agendamento> agendamentos = repository.findByData(data);
        List<AgendamentoResponseDTO> dtos = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            dtos.add(converterParaDTO(agendamento));

        }
        return dtos;
    }

    public List<AgendamentoResponseDTO> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        if(fim.isBefore(inicio)){
            throw new IllegalArgumentException("O período informado é inválido");
        }
        List<Agendamento> agendamentos = repository.findByDataBetween(inicio, fim);
        List<AgendamentoResponseDTO> dtos = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            dtos.add(converterParaDTO(agendamento));

        }
        return dtos;

    }

    public List<AgendamentoResponseDTO> buscarPorTipoServico(Long id){
        tipoServicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de serviço não encontrado"));
        List<Agendamento> agendamentos = repository.findByTipoServico_Id(id);
        List<AgendamentoResponseDTO> dtos = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            dtos.add(converterParaDTO(agendamento));

        }
        return dtos;

    }
}


