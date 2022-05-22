package com.app.controletarefas.repository;

import com.app.controletarefas.model.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
}
