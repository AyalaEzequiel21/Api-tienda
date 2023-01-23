package com.example.Tienda.Model.Dto;

import java.time.LocalDate;
import java.util.Set;

public class CompraProveedorDto {

    private Long id;
    private Set<ProductoDto> productos;
    private Set<Integer> cantidad;
    private ProveedorDto proveedor;
    private LocalDate fecha;
    private Double precioTotal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProductoDto> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoDto> productos) {
        this.productos = productos;
    }

    public Set<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(Set<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public ProveedorDto getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDto proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
