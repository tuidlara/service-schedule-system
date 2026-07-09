package com.arthur.sistema_agendamentos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class TipoServicoRequestDTO {

    @NotBlank(message = "Nome não pode ser vazio.")
    private String nome;

    @Positive(message = "A duração do serviço deve ser maior que zero.")
    private int duracaoMinutos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}
