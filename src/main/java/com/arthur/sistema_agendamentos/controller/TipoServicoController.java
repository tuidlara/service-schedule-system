package com.arthur.sistema_agendamentos.controller;

import com.arthur.sistema_agendamentos.dto.TipoServicoRequestDTO;
import com.arthur.sistema_agendamentos.dto.TipoServicoResponseDTO;
import com.arthur.sistema_agendamentos.service.TipoServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-servico")
@Tag(name = "Tipos de Serviço", description = "Operações relacionadas aos tipos de serviço")
public class TipoServicoController {

    private final TipoServicoService tipoServicoService;

    public TipoServicoController(TipoServicoService tipoServicoService) {
        this.tipoServicoService = tipoServicoService;
    }

    @Operation(
            summary = "Criar um tipo de serviço",
            description = "Cadastra um novo tipo de serviço que poderá ser utilizado em agendamentos.")

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Tipo de serviço criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "409", description = "Já existe um tipo de serviço com esse nome")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoServicoResponseDTO criarServico(@Valid @RequestBody TipoServicoRequestDTO dto) {
        return tipoServicoService.criarTipoServico(dto);
    }

    @Operation(
            summary = "Listar todos os tipos de serviço",
            description = "Retorna todos os tipos de serviço cadastrados."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public List<TipoServicoResponseDTO> listarServicos() {
        return tipoServicoService.listarServicos();
    }

    @Operation(
            summary = "Buscar um tipo de serviço por ID",
            description = "Retorna um tipo de serviço específico a partir do seu identificador."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo de serviço encontrado"),
            @ApiResponse(responseCode = "404", description = "Tipo de serviço não encontrado")
    })
    @GetMapping("/{id}")
    public TipoServicoResponseDTO buscarServicoPorId(@PathVariable Long id) {
        return tipoServicoService.buscarServicoPorId(id);
    }

    @Operation(
            summary = "Excluir um tipo de serviço",
            description = "Exclui um tipo de serviço, desde que ele não esteja sendo utilizado em agendamentos."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Tipo de serviço removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tipo de serviço não encontrado"),
            @ApiResponse(responseCode = "409", description = "Tipo de serviço está sendo utilizado em agendamentos")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarServico(@PathVariable Long id) {
        tipoServicoService.deletarServico(id);
    }

    @Operation(
            summary = "Atualizar um tipo de serviço",
            description = "Atualiza o nome e a duração de um tipo de serviço."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo de serviço atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Tipo de serviço não encontrado"),
            @ApiResponse(responseCode = "409", description = "Já existe um tipo de serviço com esse nome")
    })
    @PutMapping("/{id}")
    public TipoServicoResponseDTO atualizarServico(@PathVariable Long id, @Valid @RequestBody TipoServicoRequestDTO novoDto) {
        return tipoServicoService.atualizarServico(id, novoDto);
    }

    @Operation(
            summary = "Buscar tipos de serviço pelo nome",
            description = "Retorna todos os tipos de serviço cujo nome contenha o texto informado."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    @GetMapping("/buscar")
    public List<TipoServicoResponseDTO> buscarPorNome(@RequestParam("nome") String nome) {
        return tipoServicoService.buscarPorNome(nome);
    }

}
