package com.arthur.sistema_agendamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arthur.sistema_agendamentos.entity.Agendamento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByDataAndHorario(LocalDate data, LocalTime horario);

    boolean existsByDataAndHorarioAndIdNot(LocalDate data, LocalTime horario, Long id);

    List<Agendamento> findByTelefone(String telefone);

    List<Agendamento> findByData(LocalDate data);

    List<Agendamento> findByDataBetween(LocalDate inicio, LocalDate fim);

}