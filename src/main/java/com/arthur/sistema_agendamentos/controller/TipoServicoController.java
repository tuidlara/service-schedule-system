package com.arthur.sistema_agendamentos.controller;

import com.arthur.sistema_agendamentos.dto.TipoServicoRequestDTO;
import com.arthur.sistema_agendamentos.dto.TipoServicoResponseDTO;
import com.arthur.sistema_agendamentos.service.TipoServicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos-servico")
public class TipoServicoController {

    private final TipoServicoService tipoServicoService;

    public TipoServicoController(TipoServicoService tipoServicoService) {
        this.tipoServicoService = tipoServicoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoServicoResponseDTO criarServico(@Valid @RequestBody TipoServicoRequestDTO dto) {

        return tipoServicoService.criarTipoServico(dto);
    }

}
