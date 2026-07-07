package com.arthur.sistema_agendamentos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arthur.sistema_agendamentos.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}