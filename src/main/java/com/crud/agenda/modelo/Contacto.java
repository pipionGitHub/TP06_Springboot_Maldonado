package com.crud.agenda.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String apellido;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 30)
    private String email;

    @Column
    private Long celular;

    @ManyToOne
    @JoinColumn(name = "etiqueta_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_contacto_etiqueta"))
    private Etiqueta etiqueta;

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }
}