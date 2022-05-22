package com.app.controletarefas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tarefa")
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 20, nullable = false)
    private Integer frequencia;

    @Column(length = 20, nullable = false)
    private Integer tempo;

    @Column(length = 11, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private ProjetoModel projeto;

    @Column(length = 8, nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate data;
}
