package com.arthur.sistema_agendamentos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String telefone;
    private LocalDate data;
    private LocalTime horario;

    public Agendamento(String nomeCliente, String telefone, LocalDate data, LocalTime horario) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.data = data;
        this.horario = horario;
    }

    public Agendamento() {

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone(){
        return  telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }
    public LocalTime getHorario(){
        return horario;
    }

    public void setHorario(LocalTime horario){
        this.horario = horario;
    }

}
