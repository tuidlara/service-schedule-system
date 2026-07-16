package com.arthur.sistema_agendamentos.controller;

import com.arthur.sistema_agendamentos.dto.AgendamentoRequestDTO;
import com.arthur.sistema_agendamentos.dto.AgendamentoResponseDTO;
import com.arthur.sistema_agendamentos.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@Tag(name = "Agendamentos", description = "Operações relacionadas aos agendamentos")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @Operation(
            summary = "Criar agendamento",
            description = "Cadastra um novo agendamento para um cliente.")

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Agendamento criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "409", description = "Já existe um agendamento nesse horário")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponseDTO criarAgendamento(@Valid @RequestBody AgendamentoRequestDTO dto) {
        return agendamentoService.criarAgendamento(dto);
    }

    @Operation(
            summary = "Listar todos os agendamentos",
            description = "Retorna todos os agendamentos cadastrados."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public Page<AgendamentoResponseDTO> listarAgendamentosPaginados(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {

        return agendamentoService.listarAgendamentosPaginados(pagina, tamanho);
    }

    @Operation(
            summary = "Buscar agendamento pelo ID",
            description = "Retorna um agendamento específico a partir do seu identificador."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agendamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado")
    })
    @GetMapping("/{id}")
    public AgendamentoResponseDTO buscarPorId(@PathVariable Long id) {
        return agendamentoService.buscarAgendamento(id);
    }

    @Operation(
            summary = "Excluir agendamento",
            description = "Exclui um agendamento."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Agendamento removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado"),
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);

    }

    @Operation(
            summary = "Atualizar agendamento",
            description = "Atualiza um agendamento a partir do seu identificador."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agendamento atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado"),
            @ApiResponse(responseCode = "409", description = "Já existe um agendamento nesse horário")
    })
    @PutMapping("/{id}")
    public AgendamentoResponseDTO atualizarAgendamento(@PathVariable Long id, @Valid @RequestBody AgendamentoRequestDTO novoDto) {
        return agendamentoService.atualizarAgendamento(id, novoDto);

    }

    @Operation(
            summary = "Buscar agendamentos por telefone",
            description = "Retorna todos os agendamentos vinculados ao telefone informado."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de agendamentos retornada com sucesso")
    })

    @GetMapping("/telefone/{telefone}")
    public List<AgendamentoResponseDTO> buscarPorTelefone(@PathVariable String telefone) {
        return agendamentoService.buscarPorTelefone(telefone);
    }

    @Operation(
            summary = "Buscar agendamentos por data",
            description = "Retorna todos os agendamentos da data informada."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de agendamentos retornada com sucesso")
    })
    @GetMapping("/data/{data}")
    public List<AgendamentoResponseDTO> buscarPorData(@PathVariable LocalDate data) {
        return agendamentoService.buscarPorData(data);
    }

    @Operation(
            summary = "Buscar agendamentos por período",
            description = "Retorna os agendamentos que estão entre as datas informadas."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de agendamentos retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Período informado é inválido")
    })
    @GetMapping("/periodo")
    public List<AgendamentoResponseDTO> buscarPorPeriodo(@RequestParam("inicio") LocalDate inicio,
                                                         @RequestParam("fim") LocalDate fim) {
        return agendamentoService.buscarPorPeriodo(inicio, fim);
    }

    @Operation(
            summary = "Buscar agendamentos por tipo de serviço",
            description = "Retorna todos os agendamentos associados ao tipo de serviço informado."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de agendamentos retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tipo de serviço não encontrado")
    })
    @GetMapping("/tipos-servico/{id}")
    public List<AgendamentoResponseDTO> listarPorTipoServico(@PathVariable Long id) {
        return agendamentoService.listarPorTipoServico(id);
    }

}

