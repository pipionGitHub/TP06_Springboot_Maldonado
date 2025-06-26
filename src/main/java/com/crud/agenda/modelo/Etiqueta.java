package com.crud.agenda.modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_etiqueta", length = 30)
    private String nombreEtiqueta;

    @OneToMany(mappedBy = "etiqueta", cascade = CascadeType.ALL)
    private List<Contacto> contactos;

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }
}
