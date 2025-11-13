package com.unu.TD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "usuario")
public class Usuario {

    @Id
    @Column (name="id_usuario")
    private Long id_Usuario;
    @Column (name="nombre")
    private String nombre;
    @Column (name="apellidos")
    private String apellidos;
    @Column (name="edad")
    private int edad;

}
