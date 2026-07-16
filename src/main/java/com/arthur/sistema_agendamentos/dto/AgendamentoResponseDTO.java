package com.arthur.sistema_agendamentos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoResponseDTO {

    @Schema(description = "Identificador do agendamento", example = "1")
    private Long id;

    @Schema(description = "Nome do cliente", example = "Arthur de Lara Zilli")
    private String nomeCliente;

    @Schema(description = "Telefone do cliente", example = "46999999999")
    private String telefone;

    @Schema(description = "Data do agendamento (AAAA-MM-DD)", example = "2026-07-16")
    private LocalDate data;

    @Schema(description = "Horário do agendamento (HH:mm)", example = "13:50")
    private LocalTime horario;

    @Schema(description = "ID do tipo de serviço", example = "1")
    private Long tipoServicoId;

    @Schema(description = "Nome do tipo de serviço", example = "Corte Masculino")
    private String nomeTipoServico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getNomeTipoServico() {
        return nomeTipoServico;
    }

    public void setNomeTipoServico(String nomeTipoServico) {
        this.nomeTipoServico = nomeTipoServico;
    }

    public Long getTipoServicoId() {
        return tipoServicoId;
    }

    public void setTipoServicoId(Long tipoServicoId) {
        this.tipoServicoId = tipoServicoId;
    }
}

