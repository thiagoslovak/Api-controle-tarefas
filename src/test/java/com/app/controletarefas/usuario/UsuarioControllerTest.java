package com.app.controletarefas.usuario;

import com.app.controletarefas.model.UsuarioModel;
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
public class UsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper oBjectMapper;

    @Before
    public UsuarioModel responseUsuario() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome("Thiago");
        usuario.setTempoDiario(2);

        return usuario;
    }

    @Test
    void usuarioTestCadastraUsuario() throws Exception {
        mockMvc.perform(post("/usuarios/novo")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseUsuario())))
                .andExpect(status().isOk());
    }

    @Test
    void usuarioTestVisualizarUsuarios() throws Exception {
        mockMvc.perform(get("/usuarios/visualizar"))
                .andExpect(status().isOk());
    }

    @Test
    void usuarioTestAtualziarUsuario() throws Exception {
        mockMvc.perform(put("/usuarios/atualizar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseUsuario())))
                .andExpect(status().isOk());
    }

    @Test
    void usuarioTestExcluirUsuario() throws Exception {
        mockMvc.perform(delete("/usuarios/deletar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseUsuario())))
                .andExpect(status().isOk());
    }
}
