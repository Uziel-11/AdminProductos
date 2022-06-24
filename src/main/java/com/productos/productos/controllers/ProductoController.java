package com.productos.productos.controllers;


import com.productos.productos.models.ProductoModel;
import com.productos.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public ArrayList<ProductoModel> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @PostMapping
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto){
        return this.productoService.guardarProducto(producto);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") Long id){
        return this.productoService.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<ProductoModel> obtenerProductoPorMarca(@RequestParam("marca") String marca){
        return this.productoService.obtenerPorMarca(marca);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProductoPorId(@PathVariable("id") Long id){
        boolean ok = this.productoService.eliminarProducto(id);
        if (ok){
            return "Se elimino el producto con Id: "+id;
        }else {
            return "No se pudo eliminar el Produto con Id: "+id;
        }
    }



}
