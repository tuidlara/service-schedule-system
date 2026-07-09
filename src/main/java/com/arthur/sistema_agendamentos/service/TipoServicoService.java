package com.arthur.sistema_agendamentos.service;

import com.arthur.sistema_agendamentos.dto.TipoServicoRequestDTO;
import com.arthur.sistema_agendamentos.dto.TipoServicoResponseDTO;
import com.arthur.sistema_agendamentos.entity.TipoServico;
import com.arthur.sistema_agendamentos.repository.TipoServicoRepository;
import org.springframework.stereotype.Service;

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
}