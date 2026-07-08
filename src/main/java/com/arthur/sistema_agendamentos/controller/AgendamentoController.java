package com.arthur.sistema_agendamentos.controller;

import com.arthur.sistema_agendamentos.dto.AgendamentoRequestDTO;
import com.arthur.sistema_agendamentos.dto.AgendamentoResponseDTO;
import com.arthur.sistema_agendamentos.entity.Agendamento;
import com.arthur.sistema_agendamentos.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponseDTO criarAgendamento(@Valid @RequestBody AgendamentoRequestDTO dto) {
        Agendamento agendamento = new Agendamento(dto.getNomeCliente(), dto.getTelefone(), dto.getData(), dto.getHorario());
        return agendamentoService.criarAgendamento(agendamento);
    }

    @GetMapping
    public Page<AgendamentoResponseDTO> listarAgendamentosPaginados(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {

        return agendamentoService.listarAgendamentosPaginados(pagina, tamanho);
    }

    @GetMapping("/{id}")
    public AgendamentoResponseDTO buscarPorId(@PathVariable Long id) {
        return agendamentoService.buscarAgendamento(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);

    }

    @PutMapping("/{id}")
    public AgendamentoResponseDTO atualizarAgendamento(@PathVariable Long id, @Valid @RequestBody AgendamentoRequestDTO novoDto) {
        return agendamentoService.atualizarAgendamento(id, novoDto);

    }

    @GetMapping("/telefone/{telefone}")
    public List<AgendamentoResponseDTO> buscarPorTelefone(@PathVariable String telefone) {
        return agendamentoService.buscarPorTelefone(telefone);
    }

}

