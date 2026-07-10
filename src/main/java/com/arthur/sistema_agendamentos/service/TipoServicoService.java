package com.arthur.sistema_agendamentos.service;

import com.arthur.sistema_agendamentos.dto.TipoServicoRequestDTO;
import com.arthur.sistema_agendamentos.dto.TipoServicoResponseDTO;
import com.arthur.sistema_agendamentos.entity.TipoServico;
import com.arthur.sistema_agendamentos.repository.TipoServicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoServicoService {

    private final TipoServicoRepository tipoServicoRepository;

    public TipoServicoService(TipoServicoRepository tipoServicoRepository) {
        this.tipoServicoRepository = tipoServicoRepository;

    }

    private TipoServicoResponseDTO converterParaDTO(TipoServico tipoServico) {
        TipoServicoResponseDTO dto = new TipoServicoResponseDTO();
        dto.setId(tipoServico.getId());
        dto.setNome(tipoServico.getNome());
        dto.setDuracaoMinutos(tipoServico.getDuracaoMinutos());

        return dto;
    }

    public TipoServicoResponseDTO criarTipoServico(TipoServicoRequestDTO dto) {
        TipoServico tipoServico = new TipoServico(
                dto.getNome(),
                dto.getDuracaoMinutos());

        TipoServico salvo = tipoServicoRepository.save(tipoServico);
        return converterParaDTO(salvo);
    }

    public List<TipoServicoResponseDTO> listarServicos() {
        List<TipoServico> listarServicos = tipoServicoRepository.findAll();
        List<TipoServicoResponseDTO> dtos = new ArrayList<>();

        for (TipoServico t : listarServicos) {
            dtos.add(converterParaDTO(t));
        }
        return dtos;
    }

    public TipoServicoResponseDTO buscarServicoPorId(Long id){
        TipoServico tipoServico = tipoServicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));
        return converterParaDTO(tipoServico);
    }

    public void deletarServico(Long id){
        TipoServico servico = tipoServicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));
        tipoServicoRepository.delete(servico);
    }

    public TipoServicoResponseDTO atualizarServico(Long id, TipoServicoRequestDTO novoDto){
       TipoServico tipoServico = tipoServicoRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));

       tipoServico.setNome(novoDto.getNome());
       tipoServico.setDuracaoMinutos(novoDto.getDuracaoMinutos());

       TipoServico atualizado = tipoServicoRepository.save(tipoServico);
       return converterParaDTO(atualizado);
    }

}