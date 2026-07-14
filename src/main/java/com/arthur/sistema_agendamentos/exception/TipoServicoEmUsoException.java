package com.arthur.sistema_agendamentos.exception;

public class TipoServicoEmUsoException extends RuntimeException {
    public TipoServicoEmUsoException() {
        super("Você não pode deletar um serviço que está em uso");
    }
}
