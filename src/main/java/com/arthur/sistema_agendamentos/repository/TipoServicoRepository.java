package com.arthur.sistema_agendamentos.repository;

import com.arthur.sistema_agendamentos.entity.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Long id);

    List<TipoServico> findByNomeContainingIgnoreCase (String nome);

}
