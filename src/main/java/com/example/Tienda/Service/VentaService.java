package com.example.Tienda.Service;

import com.example.Tienda.Model.Dto.VentaDto;
import com.example.Tienda.Model.Entity.Venta;
import com.example.Tienda.Repository.IVentaRepository;
import com.example.Tienda.Service.Interfaces.IVentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void registrarVenta(VentaDto ventaDto) {
        Venta venta = mapper.convertValue(ventaDto, Venta.class);
        ventaRepository.save(venta);
    }

    @Override
    public VentaDto buscarVentaPorId(Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        VentaDto ventaDto = null;
        if (venta.isPresent()){
            ventaDto = mapper.convertValue(venta, VentaDto.class);
        }
        return ventaDto;
    }

    @Override
    public Set<VentaDto> buscarVentasPorFecha(LocalDate fecha) {
        List<Venta> ventas = ventaRepository.findAll();
        Set<VentaDto> ventasDeEsaFecha = new HashSet<>();
        for(Venta venta : ventas){
            if (venta.getFecha().equals(fecha)){
                ventasDeEsaFecha.add(mapper.convertValue(venta, VentaDto.class));
            }
        }
        return ventasDeEsaFecha;
    }

    @Override
    public Set<VentaDto> listarVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        Set<VentaDto> ventasDto = new HashSet<>();
        for (Venta venta : ventas){
            ventasDto.add(mapper.convertValue(venta, VentaDto.class));
        }
        return ventasDto;
    }
}
