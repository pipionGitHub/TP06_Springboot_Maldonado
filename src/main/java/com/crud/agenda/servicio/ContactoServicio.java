package com.crud.agenda.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.agenda.modelo.Contacto;
import com.crud.agenda.repositorio.ContactoRepositorio;

@Service
public class ContactoServicio implements ContactoServicioInterface {
    @Autowired
    private ContactoRepositorio repositorio;

    @Override
    public List<Contacto> listar() {
        return repositorio.findAll();
    }

    @Override
    public Contacto guardarContacto(Contacto contacto) {
        return repositorio.save(contacto);
    }
    
    @Override
    public Contacto obtenerContactoId(int id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Contacto modificarContacto(Contacto contacto) {
        return repositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(int id) {
        repositorio.deleteById(id);
    }

}