package com.unu.TD.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unu.TD.Service.UsuarioService;
import com.unu.TD.model.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping ("api/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario>buscarUsuarioPorId(@PathVariable Long id){
        return usuarioService.findById(id)
        .map(usuario -> ResponseEntity.ok(usuario))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario>crearUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.insertUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        }    
    
    @PostMapping("/modificar/{id}")
    public ResponseEntity<Usuario>modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetalle){
        return usuarioService.findById(id)
        .map(usuarioExistente -> {
            usuarioExistente.setNombre(usuarioDetalle.getNombre());
            usuarioExistente.setApellidos(usuarioDetalle.getApellidos());
            usuarioExistente.setEdad(usuarioDetalle.getEdad());
            Usuario usuarioActualizado = usuarioService.modificar(usuarioExistente);
            return ResponseEntity.ok(usuarioActualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        return usuarioService.findById(id)
        .map(usuario -> {
            usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
        })
        .orElse(ResponseEntity.notFound().build());
    }
    

}
