package com.productos.productos.controllers;
import com.productos.productos.models.UsuarioModel;
import com.productos.productos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    UsuarioModel usuarioModel;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuario();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @PostMapping(path = "/login")
    public String login(@RequestParam String username, @RequestParam String password){
        String aux ="";
        boolean status = false;
        ArrayList<UsuarioModel> resul =  usuarioService.login(username);
        if (resul.get(0).getPassword().equals(password)){

            aux = "Cotraseña correcta";
            status = true;
        }else {
            aux = "Contraseña Incorrecta";

        }

        return aux+"\nStatus:" + status;
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se elimino el Usuario con Id " + id;
        }else {
            return "No pudo eliminar el Usuario con Id " + id;
        }
    }
}
