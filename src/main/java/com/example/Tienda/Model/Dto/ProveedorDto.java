package com.example.Tienda.Model.Dto;

import com.example.Tienda.Model.Entity.Producto;

import java.util.Set;

public class ProveedorDto {

    private Long id;
    private String nombre;
    private String cuit;
    private Integer telefono;
    private String direccion;
    private Set<ProductoDto> productos;
    private Set<CompraProveedorDto> compras;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CompraProveedorDto> getCompras() {
        return compras;
    }

    public void setCompras(Set<CompraProveedorDto> compras) {
        this.compras = compras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<ProductoDto> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoDto
            > productos) {
        this.productos = productos;
    }
}
