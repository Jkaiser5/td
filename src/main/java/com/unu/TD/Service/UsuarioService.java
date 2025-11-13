package com.unu.TD.Service;

import java.util.List;
import java.util.Optional;

import com.unu.TD.model.Usuario;

public interface UsuarioService {

    List<Usuario>listAll();
    Optional<Usuario>findById(long id);
    Usuario insertUsuario(Usuario usuario);
    Usuario eliminarUsuario(Long id);
    Usuario modificar (Usuario usuario);

}
