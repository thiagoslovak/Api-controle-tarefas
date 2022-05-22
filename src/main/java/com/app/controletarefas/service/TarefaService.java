package com.app.controletarefas.service;

import com.app.controletarefas.model.TarefasModel;
import com.app.controletarefas.model.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private final String PENDENTE = "PENDENTE";

    public List<TarefasModel> organizarTarefasDuracaoNaoUltrapasseLimiteDiario(List<TarefasModel> tarefas, List<UsuarioModel> usuarios) {
        List<TarefasModel> tarefasMenorTempoDiario = new ArrayList<>();
        int somaTempoTarefas = 0;
        int contadorUsuario = 0;
        int contadorTarefa = 0;
        int contadorTarefaTempo = 0;

        for(TarefasModel tarefa : tarefas) {
            if (tarefas.get(contadorTarefaTempo).getStatus().equals(PENDENTE)) {
                somaTempoTarefas += tarefas.get(contadorTarefaTempo).getTempo();
            }
            contadorTarefaTempo++;
        }

        for (UsuarioModel usuario : usuarios) {
            for (TarefasModel tarefa : tarefas) {
                if (tarefas.get(contadorTarefa).getStatus().equals(PENDENTE)) {

                    if (somaTempoTarefas <= usuarios.get(contadorUsuario).getTempoDiario()) {
                            tarefasMenorTempoDiario.add(tarefas.get(contadorTarefa));
                    }
                }
                contadorTarefa++;
            }
            contadorUsuario++;
        }

        return tarefasMenorTempoDiario;
    }

    public List<TarefasModel> verificarSeContemProjeto(List<TarefasModel> tarefas) {
        List<TarefasModel> tarefasCotemProjeto = new ArrayList<>();
        int contadorTarefa = 0;

        for(TarefasModel tarefa : tarefas) {
            if (!tarefas.get(contadorTarefa).getProjeto().equals(null)) {
                tarefasCotemProjeto.add(tarefas.get(contadorTarefa));
            }
            contadorTarefa++;
        }

        return tarefasCotemProjeto;
    }
}
