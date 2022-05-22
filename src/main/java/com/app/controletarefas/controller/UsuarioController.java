package com.app.controletarefas.controller;

import com.app.controletarefas.model.UsuarioModel;
import com.app.controletarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping(path = "/novo")
    public UsuarioModel cadastraUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping(path = "/visualizar")
    public List<UsuarioModel> visualizarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PutMapping(path = "/atualizar")
    public UsuarioModel atualziarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping(path = "/deletar")
    public void excluirUsuario(@RequestBody UsuarioModel usuario) {
        usuarioRepository.delete(usuario);
    }
}
