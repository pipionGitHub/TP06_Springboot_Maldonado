package com.crud.agenda.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crud.agenda.servicio.ContactoServicio;
import com.crud.agenda.modelo.Contacto;
import com.crud.agenda.servicio.EtiquetaServicio;
import com.crud.agenda.modelo.Etiqueta;


@Controller
public class ContactosControlador {

    @Autowired
    private ContactoServicio servicio;

    @Autowired
    private EtiquetaServicio servicioEtiqueta;

    @GetMapping({"/contacto", "/"})
    public String listarContactos(Model modelo) {
        List<Contacto> contactos = servicio.listar();
        modelo.addAttribute("contactos", contactos);
        List<Etiqueta> listaEtiquetas = servicioEtiqueta.listar();
        modelo.addAttribute("listaEtiquetas", listaEtiquetas);
        System.out.println(contactos.size());
        return "index"; // retorna al archivo index.html
    }

    @GetMapping("/nuevo")
    public String FormularioDeRegistrarContacto(Model modelo) {
        Contacto contacto = new Contacto();
        List<Etiqueta> listaEtiquetas = servicioEtiqueta.listar();
        modelo.addAttribute("contacto", contacto);
        modelo.addAttribute("listaEtiquetas", listaEtiquetas);
        return "crear"; // abre la pagina crear.html
    }

    @PostMapping("/contacto")
    public String guardarContacto(@ModelAttribute("contacto") Contacto contacto) {
        servicio.guardarContacto(contacto);
        return "redirect:/contacto"; // llama a la pagina ppal.
    }

    @GetMapping("/modificar/{id}")
    public String formularioEditarContacto(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("contacto", servicio.obtenerContactoId(id));
        List<Etiqueta> listaEtiquetas = servicioEtiqueta.listar();
        modelo.addAttribute("listaEtiquetas", listaEtiquetas);
        return "editar"; // o "crear" si usás el mismo formulario
    }

    @PostMapping("/modificar/{id}")
    public String modificarContacto(@PathVariable Integer id, @ModelAttribute("contacto") Contacto contacto, Model modelo) {
        //TODO: process POST request
        Contacto contacto1 = servicio.obtenerContactoId(id);
        contacto1.setId(contacto.getId());
        contacto1.setApellido(contacto.getApellido());
        contacto1.setNombre(contacto.getNombre());
        contacto1.setEmail(contacto.getEmail());
        contacto1.setCelular(contacto.getCelular());
        servicio.modificarContacto(contacto1);
        return "redirect:/contacto";
    }

    @GetMapping("/contacto/{id}")
    public String eliminarContacto(@PathVariable Integer id) {
        servicio.eliminarContacto(id);
        return "redirect:/contacto";
    }
    


}