package com.productos.productos.repositories;


import com.productos.productos.models.ProductoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {

    ArrayList<ProductoModel> findByTipo(String tipo);

    ArrayList<ProductoModel> findByMarca(String marca);
}
