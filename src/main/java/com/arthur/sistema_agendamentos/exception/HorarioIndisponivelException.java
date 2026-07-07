package com.arthur.sistema_agendamentos.exception;

//exceção específica
public class HorarioIndisponivelException extends RuntimeException {
    public HorarioIndisponivelException() {
        super("Já existe um agendamento nesse horário");
    }
}
