package com.app.controletarefas.repository;

import com.app.controletarefas.model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {

    Optional<TarefasModel> findByStatus(String status);
    List<TarefasModel> findByOrderByFrequenciaDesc();
    List<TarefasModel> findByDataAndStatus(LocalDate data, String status);
}
