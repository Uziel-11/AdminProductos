package com.productos.productos.services;


import com.productos.productos.models.ProductoModel;
import com.productos.productos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModel> obtenerProductos(){
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }

    public Optional<ProductoModel> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public ArrayList<ProductoModel> ontenerPorTipo(String tipo){
        return productoRepository.findByTipo(tipo);
    }

    public ArrayList<ProductoModel> obtenerPorMarca(String marca){
        return productoRepository.findByMarca(marca);
    }

    public boolean eliminarProducto(Long id){
        try {
            productoRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
