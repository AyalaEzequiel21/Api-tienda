package com.example.Tienda.Model.Dto;

import com.example.Tienda.Model.Entity.Venta;

import java.util.Set;

public class ClienteDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Integer telefono;
    private String direccion;
    private Set<Venta> comprasRealizadas;

    public Set<Venta> getVentas() {
        return comprasRealizadas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.comprasRealizadas = ventas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
}
