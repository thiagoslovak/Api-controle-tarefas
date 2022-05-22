package com.app.controletarefas.controller;

import com.app.controletarefas.model.ProjetoModel;
import com.app.controletarefas.model.TarefasModel;
import com.app.controletarefas.model.UsuarioModel;
import com.app.controletarefas.repository.ProjetoRepository;
import com.app.controletarefas.repository.TarefasRepository;
import com.app.controletarefas.repository.UsuarioRepository;
import com.app.controletarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final String PENDENTE = "PENDENTE";

    @Autowired
    TarefasRepository tarefasRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TarefaService tarefaService;

    @Autowired
    ProjetoRepository projetoRepository;

    @PostMapping(path = "/novo")
    public TarefasModel cadastraTarefa(@RequestBody TarefasModel tarefa) {
        Optional<ProjetoModel> projeto = projetoRepository.findById(tarefa.getProjeto().getId());
        tarefa.setProjeto(projeto.get());

        return tarefasRepository.save(tarefa);
    }

    @GetMapping(path = "/visualizar/status")
    public ResponseEntity visualizarTarefasPorStatus(String status) {
        return tarefasRepository.findByStatus(status)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/visualizar/limiteDiario")
    public List<TarefasModel> visualizarTarefasNaoUltrapasseLimiteDiario(String nome) {
        List<TarefasModel> responseTarefas = tarefasRepository.findByOrderByFrequenciaDesc();
        List<UsuarioModel> responseUsuarios = usuarioRepository.findByNome(nome);
        return tarefaService.organizarTarefasDuracaoNaoUltrapasseLimiteDiario(responseTarefas, responseUsuarios);
    }

    @GetMapping(path = "/visualizar/tarefasPendentes")
    public List<TarefasModel> visualizarTarefasPendentesDeterminadoPeriodo(String data) {
        return tarefasRepository.findByDataAndStatus(LocalDate.parse(data),PENDENTE);
    }

    @GetMapping(path = "/visualizar/vinculadasProjeto")
    public List<TarefasModel> visualizarTarefasVinculadaProjeto() {
        List<TarefasModel> reseponseTarefas = tarefasRepository.findAll();
        return tarefaService.verificarSeContemProjeto(reseponseTarefas);
    }

    @GetMapping(path = "/visualizar")
    public List<TarefasModel> visualizarTarefas() {
        return tarefasRepository.findAll();
    }

    @PutMapping(path = "/atualizar")
    public TarefasModel atualziarTarefa(@RequestBody TarefasModel tarefa) {
        return tarefasRepository.save(tarefa);
    }

    @DeleteMapping(path = "/deletar")
    public void excluirTarefa(@RequestBody TarefasModel tarefa) {
        tarefasRepository.delete(tarefa);
    }
}
