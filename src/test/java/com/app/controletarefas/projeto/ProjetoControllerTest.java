package com.app.controletarefas.projeto;

import com.app.controletarefas.model.ProjetoModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjetoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper oBjectMapper;

    @Before
    public ProjetoModel responseProjeto() {
        ProjetoModel projeto = new ProjetoModel();
        projeto.setNome("Projeto");
        projeto.setDescricao("Descrição");

        return projeto;
    }

    @Test
    void tarefaTestCadastraProjeto() throws Exception {
        mockMvc.perform(post("/projetos/novo")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseProjeto())))
                         .andExpect(status().isOk());
    }

    @Test
    void tarefaTestVisualizarProjetos() throws Exception {
        mockMvc.perform(get("/projetos/visualizar"))
                .andExpect(status().isOk());
    }

    @Test
    void tarefaTestAtualziarProjeto() throws Exception {
        mockMvc.perform(put("/projetos/atualizar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseProjeto())))
                        .andExpect(status().isOk());
    }

    @Test
    void tarefaTestExcluirProjeto() throws Exception {
        mockMvc.perform(delete("/projetos/deletar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseProjeto())))
                        .andExpect(status().isOk());
    }
}
