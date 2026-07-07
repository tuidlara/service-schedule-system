package com.arthur.sistema_agendamentos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arthur.sistema_agendamentos.entity.Agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByDataAndHorario(LocalDate data, LocalTime horario);
    boolean existsByDataAndHorarioAndIdNot(LocalDate data, LocalTime horario, Long id);
}