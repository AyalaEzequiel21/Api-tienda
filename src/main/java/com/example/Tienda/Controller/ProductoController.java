package com.example.Tienda.Controller;

import com.example.Tienda.Model.Dto.ProductoDto;
import com.example.Tienda.Service.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @PostMapping
    public ResponseEntity<?> registarProducto(@RequestBody ProductoDto productoDto){
        productoService.registrarProducto(productoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ProductoDto buscarProducto(@PathVariable Long id){
        return productoService.buscarProductoPorId(id);
    }

    @GetMapping("/s{stock}")
    public Set<ProductoDto> buscarProductoPorStock(@PathVariable int stock){
        return productoService.buscarProductoPorStock(stock);
    }

    @PutMapping
    public ResponseEntity<?> modificarProducto(@RequestBody ProductoDto productoDto){
        productoService.modificarProducto(productoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<ProductoDto> listarProductos(){
        return productoService.listarProductos();
    }
}
