package com.unu.TD.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unu.TD.Service.UsuarioService;
import com.unu.TD.model.Usuario;
import com.unu.TD.repository.UsuarioRepository;

@Service
public class ServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listAll() {        
        return (List<Usuario>)usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario eliminarUsuario(Long id) {
        Optional <Usuario> usuaOptional = usuarioRepository.findById(id);
        if (usuaOptional.isPresent()){
            usuarioRepository.deleteById(id);
            return usuaOptional.get();
        }else { 
            return null;

        }     
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
