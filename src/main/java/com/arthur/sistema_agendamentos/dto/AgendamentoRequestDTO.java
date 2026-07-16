package com.arthur.sistema_agendamentos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoRequestDTO {

    @Schema(
            description = "Nome completo do cliente",
            example = "Arthur de Lara Zilli"
    )
    @NotBlank(message = "Nome não pode ser vazio.")
    private String nomeCliente;

    @Schema(
            description = "Telefone do cliente",
            example = "46999999999"
    )
    @NotBlank(message = "Telefone não pode estar vazio.")
    @Pattern(regexp = "^\\d{11}$", message = "Telefone deve conter 11 dígitos (DDD + número)")
    private String telefone;

    @Schema(
            description = "Data do agendamento (AAAA-MM-DD)",
            example = "2026-07-16"
    )
    @NotNull(message = "Data não pode ser nula.")
    private LocalDate data;

    @Schema(
            description = "Horário do agendamento (HH:mm)",
            example = "13:50"
    )
    @NotNull(message = "Horário não pode ser nulo.")
    private LocalTime horario;

    @Schema(
            description = "ID do tipo de serviço",
            example = "1"
    )
    @NotNull(message = "Tipo de serviço é obrigatório.")
    private Long tipoServicoId;

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

    public Long getTipoServicoId() {
        return tipoServicoId;
    }

    public void setTipoServicoId(Long tipoServicoId) {
        this.tipoServicoId = tipoServicoId;
    }
}
