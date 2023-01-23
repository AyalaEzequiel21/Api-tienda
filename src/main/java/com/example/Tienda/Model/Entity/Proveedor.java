package com.example.Tienda.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Boolean activo;
    private String nombre;
    private String cuit;
    private Integer telefono;
    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    @JsonIgnore
    private Set<Producto> productos;

    @OneToMany(mappedBy = "proveedor")
    @JsonIgnore
    private Set<CompraProveedor> comprasRealizadasProveedor;

    public Proveedor() {
    }

    public Proveedor(String nombre, String cuit, Integer telefono, String direccion) {
        this.activo = true;
        this.nombre = nombre;
        this.cuit = cuit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.productos = new HashSet<>();
        this.comprasRealizadasProveedor = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Set<CompraProveedor> getComprasRealizadasProveedor() {
        return comprasRealizadasProveedor;
    }

    public void setComprasRealizadasProveedor(Set<CompraProveedor> comprasRealizadasProveedor) {
        this.comprasRealizadasProveedor = comprasRealizadasProveedor;
    }
}
