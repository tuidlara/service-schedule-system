package com.arthur.sistema_agendamentos.exception;

public class AgendamentoNaoEncontradoException extends RuntimeException{
    public AgendamentoNaoEncontradoException() {
        super("Agendamento não encontrado");
    }
}
