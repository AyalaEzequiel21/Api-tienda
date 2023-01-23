package com.example.Tienda.Service.Interfaces;

import com.example.Tienda.Model.Dto.CompraProveedorDto;

import java.time.LocalDate;
import java.util.Set;

public interface ICompraProveedorService {

    void registarCompraProveedor(CompraProveedorDto compraDto);
    Set<CompraProveedorDto> buscarCompraProveedorPorProveedor(Long idProveedor);
    Set<CompraProveedorDto> buscarComprasProveedorPorFecha(LocalDate fecha);
    Set<CompraProveedorDto> listarComprasProveedor();
}
