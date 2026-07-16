package com.arthur.sistema_agendamentos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class TipoServicoRequestDTO {

    @Schema(
            description = "Nome do tipo de serviço",
            example = "Consulta Médica"
    )
    @NotBlank(message = "Nome não pode ser vazio.")
    private String nome;

    @Schema(
            description = "Duração do tipo de serviço em minutos",
            example = "45"
    )
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
