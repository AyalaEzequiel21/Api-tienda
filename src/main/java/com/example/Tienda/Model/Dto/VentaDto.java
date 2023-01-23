package com.example.Tienda.Model.Dto;

import com.example.Tienda.Model.Entity.Cliente;
import com.example.Tienda.Model.Entity.Producto;

import java.time.LocalDate;
import java.util.Set;

public class VentaDto {

    private Long id;
    private LocalDate fecha;
    private ClienteDto cliente;
    private Set<ProductoDto> productos;
    private Set<Integer> cantidad;
    private Double precioTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto clienteDto) {
        this.cliente = clienteDto;
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

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
