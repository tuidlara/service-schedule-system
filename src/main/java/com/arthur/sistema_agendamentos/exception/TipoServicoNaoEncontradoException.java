package com.arthur.sistema_agendamentos.exception;

public class TipoServicoNaoEncontradoException extends RuntimeException {
    public TipoServicoNaoEncontradoException() {
        super("Serviço não encontrado");
    }
}
