package com.example.Tienda.Service.Interfaces;

import com.example.Tienda.Model.Dto.ProveedorDto;

import java.util.Set;

public interface IProveedorService {

    void registrarProveedor(ProveedorDto proveedorDto);
    ProveedorDto buscarProveedor(Long id);
    void modificarProveedor(ProveedorDto proveedorDto);
    void eliminarProveedor(Long id);
    Set<ProveedorDto> listarProveedores();
}
