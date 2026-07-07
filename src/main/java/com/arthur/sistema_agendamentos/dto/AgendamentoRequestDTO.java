package com.arthur.sistema_agendamentos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoRequestDTO {

    @NotBlank(message = "Nome não pode ser vazio.")
    private String nomeCliente;

    @NotBlank(message = "Telefone não pode estar em vazio.")
    private String telefone;

    @NotNull(message = "Data não pode ser nula.")
    private LocalDate data;

    @NotNull(message = "Horário não pode ser nulo.")
    private LocalTime horario;

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
}
