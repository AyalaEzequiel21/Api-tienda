package com.example.Tienda.Controller;

import com.example.Tienda.Model.Dto.VentaDto;
import com.example.Tienda.Service.Interfaces.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    IVentaService ventaService;

    @PostMapping
    public ResponseEntity<?> registrarVenta(@RequestBody VentaDto ventaDto){
        ventaService.registrarVenta(ventaDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{fecha}")
    public Set<VentaDto> buscarVentasPorFecha(@PathVariable LocalDate fecha){
        return ventaService.buscarVentasPorFecha(fecha);
    }

    @GetMapping
    public Set<VentaDto> listarVentas(){
        return ventaService.listarVentas();
    }
}
