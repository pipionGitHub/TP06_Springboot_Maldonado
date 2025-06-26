package com.crud.agenda.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.agenda.servicio.EtiquetaServicio;
import com.crud.agenda.modelo.Etiqueta;


@Controller
public class EtiquetasControlador{
    
    @Autowired
    private EtiquetaServicio servicio;

    @GetMapping("/etiqueta")
    public String listarEtiqueta(Model modelo) {
        List<Etiqueta> etiquetas = servicio.listar();
        modelo.addAttribute("etiquetas", etiquetas);
        return"index"; // retorna al archivo index.html
    }

    @GetMapping("/etiqueta/nueva")
    public String FormularioDeRegistrarEtiqueta(Model modelo) {
        Etiqueta etiqueta= new Etiqueta();
        modelo.addAttribute("etiqueta", etiqueta);
        return"crearEtiqueta"; // abre la pagina crear.html
    }

    @PostMapping("/etiqueta")
    public String guardarEtiqueta(@ModelAttribute("etiqueta") Etiqueta etiqueta) {
        servicio.guardarEtiqueta(etiqueta);
        return "redirect:/contacto"; // llama a la pagina ppal.
    }

    @GetMapping("/etiqueta/{id}")
    public String eliminarEtiqueta(@PathVariable Integer id) {
        servicio.eliminarEtiqueta(id);
        return "redirect:/contacto";
    }
}
