package com.crud.agenda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crud.agenda.modelo.Etiqueta;

@Repository
public interface EtiquetaRepositorio extends JpaRepository<Etiqueta, Integer> {


}

