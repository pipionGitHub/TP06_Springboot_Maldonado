package com.crud.agenda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crud.agenda.modelo.Contacto;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {


}
