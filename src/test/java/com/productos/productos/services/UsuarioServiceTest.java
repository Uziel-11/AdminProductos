package com.productos.productos.services;

import com.productos.productos.models.UsuarioModel;
import com.productos.productos.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsuarioServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioService usuarioService;
    private UsuarioModel model;

    @Test
    void guardarUsuario() {

    }

    @Test
    void obtenerPorId() {
    }

    @Test
    void login() {
    }

    @Test
    void eliminarUsuario() {
        when(usuarioRepository.findByUser("2343")).thenReturn((ArrayList<UsuarioModel>) Arrays.asList(model));
        assertNotNull(usuarioService.login("2424"));
    }
}