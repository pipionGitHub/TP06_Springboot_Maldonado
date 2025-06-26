package com.crud.agenda.servicio;

import java.util.List;
import com.crud.agenda.modelo.Contacto;

public interface ContactoServicioInterface {
    
    public List<Contacto> listar();
    public Contacto guardarContacto(Contacto contacto);
    public Contacto obtenerContactoId(int id);
    public Contacto modificarContacto(Contacto contacto);

    public void eliminarContacto(int id);
} 
    

