package com.crud.agenda.servicio;

import java.util.List;

import com.crud.agenda.modelo.Etiqueta;

public interface EtiquetaServicioInterface {
    
    public List<Etiqueta> listar();
    public Etiqueta guardarEtiqueta(Etiqueta etiqueta);
    public void eliminarEtiqueta(int id);

} 
    

