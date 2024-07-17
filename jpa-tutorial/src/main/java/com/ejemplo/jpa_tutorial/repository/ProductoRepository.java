package com.ejemplo.jpa_tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.jpa_tutorial.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByPrecioBetween(Double preciomin, Double preciomax);
}
