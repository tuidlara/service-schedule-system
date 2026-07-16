package com.arthur.sistema_agendamentos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class TipoServicoResponseDTO {

    @Schema(
            description = "Identificador do tipo de serviço",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Nome do tipo de serviço",
            example = "Consulta Médica"
    )
    private String nome;

    @Schema(
            description = "Duração do tipo de serviço em minutos",
            example = "45"
    )
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }
}

