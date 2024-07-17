package com.ejemplo.jpa_tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejemplo.jpa_tutorial.models.Producto;
import com.ejemplo.jpa_tutorial.service.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @GetMapping("/search")
    public List<Producto> getProductosByNombre(@RequestParam String nombre) {
        return productoService.findByNombre(nombre);
    }

    @GetMapping("/searchByPrecio")
    public List<Producto> getProductosByPrecioBetween(@RequestParam Double preciomin, @RequestParam Double preciomax) {
        return productoService.findByPrecioBetween(preciomin, preciomax);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
    }
}
