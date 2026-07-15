package com.arthur.sistema_agendamentos.controller;

import com.arthur.sistema_agendamentos.dto.TipoServicoRequestDTO;
import com.arthur.sistema_agendamentos.dto.TipoServicoResponseDTO;
import com.arthur.sistema_agendamentos.service.TipoServicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<TipoServicoResponseDTO> listarServicos() {
        return tipoServicoService.listarServicos();
    }

    @GetMapping("/{id}")
    public TipoServicoResponseDTO buscarServicoPorId(@PathVariable Long id){
        return tipoServicoService.buscarServicoPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarServico(@PathVariable Long id){
        tipoServicoService.deletarServico(id);
    }

    @PutMapping("/{id}")
    public TipoServicoResponseDTO atualizarServico(@PathVariable Long id, @Valid @RequestBody TipoServicoRequestDTO novoDto){
        return tipoServicoService.atualizarServico(id, novoDto);
    }

    @GetMapping("/buscar")
    public List <TipoServicoResponseDTO> buscarPorNome(@RequestParam("nome") String nome){
        return tipoServicoService.buscarPorNome(nome);
    }
}
