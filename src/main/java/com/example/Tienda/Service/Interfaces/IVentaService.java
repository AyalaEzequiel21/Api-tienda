package com.example.Tienda.Service.Interfaces;

import com.example.Tienda.Model.Dto.VentaDto;

import java.time.LocalDate;
import java.util.Set;

public interface IVentaService {

    void registrarVenta(VentaDto ventaDto);
    VentaDto buscarVentaPorId(Long id);
    Set<VentaDto> buscarVentasPorFecha(LocalDate fecha);
    Set<VentaDto> listarVentas();
}
