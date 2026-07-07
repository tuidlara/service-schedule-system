package com.arthur.sistema_agendamentos.service;

import com.arthur.sistema_agendamentos.dto.AgendamentoRequestDTO;
import com.arthur.sistema_agendamentos.dto.AgendamentoResponseDTO;
import com.arthur.sistema_agendamentos.entity.Agendamento;
import com.arthur.sistema_agendamentos.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    private AgendamentoResponseDTO converterParaDTO(Agendamento agendamento) {
        AgendamentoResponseDTO dto = new AgendamentoResponseDTO();
        dto.setId(agendamento.getId());
        dto.setNomeCliente(agendamento.getNomeCliente());
        dto.setTelefone(agendamento.getTelefone());
        dto.setData(agendamento.getData());
        dto.setHorario(agendamento.getHorario());
        return dto;
    }

    public AgendamentoResponseDTO criarAgendamento(Agendamento agendamento) {
        Agendamento salvo = repository.save(agendamento);
        return converterParaDTO(salvo);
    }

    public List <AgendamentoResponseDTO> listarAgendamentos(){
       List<Agendamento> agendamentos = repository.findAll();
        List<AgendamentoResponseDTO> dtos = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            dtos.add(converterParaDTO(agendamento));
        }

        return dtos;
    }

    public AgendamentoResponseDTO buscarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        return converterParaDTO(agendamento);
    }

    public void deletarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        repository.delete(agendamento);
    }

    public AgendamentoResponseDTO atualizarAgendamento(Long id, AgendamentoRequestDTO novoDto){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        agendamento.setNomeCliente(novoDto.getNomeCliente());
        agendamento.setTelefone(novoDto.getTelefone());
        agendamento.setData(novoDto.getData());
        agendamento.setHorario(novoDto.getHorario());

        Agendamento atualizado = repository.save(agendamento);
        return converterParaDTO(atualizado);

    }
}
