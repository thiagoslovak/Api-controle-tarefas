package com.app.controletarefas.tarefa;

import com.app.controletarefas.model.ProjetoModel;
import com.app.controletarefas.model.TarefasModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TarefaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper oBjectMapper;

    @Before
    public TarefasModel responseTarefa() {
        TarefasModel tarefas = new TarefasModel();
        tarefas.setTitulo("Título teste");
        tarefas.setFrequencia(4);
        tarefas.setTempo(2);
        tarefas.setStatus("PENDENTE");
        tarefas.setData(LocalDate.now());
        tarefas.setProjeto(new ProjetoModel());

        return tarefas;
    }

    @Test
    void tarefaTestCadastraTarefa() throws Exception {
        mockMvc.perform(post("/tarefas/novo")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseTarefa())))
                .andExpect(status().isOk());
    }

    @Test
    void tarefaTestVisualizarTarefasPorStatus() throws Exception {
        mockMvc.perform(get("/tarefas/visualizar?status=PENDENTE"))
                .andExpect(status().isOk());
    }

    @Test
    void tarefaTestVisualizarTarefasNaoUltrapasseLimiteDiario() throws Exception {
        mockMvc.perform(get("/tarefas/visualizar/limiteDiario"))
                .andExpect(status().isOk());
    }

    @Test
    void tarefaTestvisualizarTarefasVinculadaProjeto() throws Exception {
        mockMvc.perform(get("/tarefas/visualizar/vinculadasProjeto?projeto_id=1"))
                .andExpect(status().isOk());
    }

    @Test
    void tarefaTestVisualizarTarefas() throws Exception {
        mockMvc.perform(get("/tarefas/visualizar"))
                .andExpect(status().isOk());
    }

    @Test
    void tarefaTestAtualziarTarefa() throws Exception {
        mockMvc.perform(put("/tarefas/atualizar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseTarefa())))
                        .andExpect(status().isOk());
    }

    @Test
    void tarefaTestExcluirTarefa() throws Exception {
        mockMvc.perform(delete("/tarefas/deletar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseTarefa())))
                        .andExpect(status().isOk());
    }
}
