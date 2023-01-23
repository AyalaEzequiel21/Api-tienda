package com.example.Tienda.Controller;

import com.example.Tienda.Model.Dto.CompraProveedorDto;
import com.example.Tienda.Service.Interfaces.ICompraProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/comprasProveedores")
public class CompraProveedorController {

    @Autowired
    ICompraProveedorService compraProveedorService;

    @PostMapping
    public ResponseEntity<?> registrarCompra(@RequestBody CompraProveedorDto compraProveedorDto){
        compraProveedorService.registarCompraProveedor(compraProveedorDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{idProveedor}")
    public Set<CompraProveedorDto> buscarComprasPorProveedor(@PathVariable Long idProveedor){
        return compraProveedorService.buscarCompraProveedorPorProveedor(idProveedor);
    }

    @GetMapping
    public Set<CompraProveedorDto> listarComprasProveedor(){
        return compraProveedorService.listarComprasProveedor();
    }
}
