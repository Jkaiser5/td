package com.unu.TD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.TD.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long>{

}
