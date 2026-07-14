package com.arthur.sistema_agendamentos.exception;

public class HorarioFuncionamentoException extends RuntimeException {
    public HorarioFuncionamentoException() {
        super("Horário de funcionamento entre 8h e 18h");
    }
}
