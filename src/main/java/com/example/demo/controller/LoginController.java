package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Persona;
import com.example.demo.model.Trabajador;

@Controller
public class LoginController {

    // 1. Ruta para la pantalla principal o login
    @GetMapping({"/", "/formulario"})
    public String mostrarInicio() {
        return "formulario";
    }

    // 2. Ruta para el panel del trabajador (acceso directo)
    @GetMapping("/trabajador")
    public String mostrarPanelTrabajador(Model model) {
        model.addAttribute("trabajadorNombre", "Carlos Mendoza");
        return "trabajador";
    }

    // 3. Procesamiento del inicio de sesión (Maneja TRABAJADOR y CLIENTE)
    @PostMapping("/Ingresar")
    public String ingresar(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String userRole,
                           Model model) {

        model.addAttribute("usernameGuardado", username);
        model.addAttribute("userRoleGuardado", userRole);

        // EVALUACIÓN PARA ROL TRABAJADOR
        if ("trabajador".equalsIgnoreCase(userRole)) {
            Trabajador emp = new Trabajador();
            
            if (emp.getUsuario().equalsIgnoreCase(username) && emp.getPassword().equals(password)) {
                model.addAttribute("trabajadorNombre", username);
                model.addAttribute("mensaje", "¡Bienvenido Staff! Cargo: " + emp.getCargo());
                
                // REDIRIGE A LA NUEVA INTERFAZ TRABAJADOR
                return "trabajador"; 
            } else {
                model.addAttribute("error", "Usuario o contraseña de TRABAJADOR incorrectos.");
                return "formulario";
            }
        } 
        // EVALUACIÓN PARA ROL CLIENTE
        else {
            Persona cliente = new Persona();
            
            if (cliente.getUsuario().equalsIgnoreCase(username) && cliente.getPassword().equals(password)) {
                model.addAttribute("mensaje", "¡Bienvenido Atleta! Acceso correcto.");
                
                // REDIRIGE A LA INTERFAZ CLIENTE (INGRESO.html)
                return "INGRESO"; 
            } else {
                model.addAttribute("error", "Usuario o contraseña de CLIENTE incorrectos.");
                return "formulario";
            }
        }
    }
}