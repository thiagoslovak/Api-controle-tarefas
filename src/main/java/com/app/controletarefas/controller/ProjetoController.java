package com.app.controletarefas.controller;

import com.app.controletarefas.model.ProjetoModel;
import com.app.controletarefas.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    ProjetoRepository projetoRepository;

    @PostMapping(path = "/novo")
    public ProjetoModel cadastraProjeto(@RequestBody ProjetoModel projeto) {
        return projetoRepository.save(projeto);
    }

    @GetMapping(path = "/visualizar")
    public List<ProjetoModel> visualizarProjetos() {
        return projetoRepository.findAll();
    }

    @PutMapping(path = "/atualizar")
    public ProjetoModel atualziarProjeto(@RequestBody ProjetoModel projeto) {
        return projetoRepository.save(projeto);
    }

    @DeleteMapping(path = "/deletar")
    public void excluirProjeto(@RequestBody ProjetoModel projeto) {
        projetoRepository.delete(projeto);
    }
}
