package com.crud.agenda.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.agenda.modelo.Etiqueta;
import com.crud.agenda.repositorio.EtiquetaRepositorio;

@Service
public class EtiquetaServicio implements EtiquetaServicioInterface {
    @Autowired
    private EtiquetaRepositorio repositorio;

    @Override
    public List<Etiqueta> listar() {
        return repositorio.findAll();
    }

    @Override
    public Etiqueta guardarEtiqueta(Etiqueta etiqueta) {
        return repositorio.save(etiqueta);
    }

    @Override
    public void eliminarEtiqueta(int id) {
        repositorio.deleteById(id);
    }
}
