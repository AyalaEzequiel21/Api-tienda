package com.example.Tienda.Controller;

import com.example.Tienda.Model.Dto.ProveedorDto;
import com.example.Tienda.Service.Interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    IProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<?> registrarProveedor(@RequestBody ProveedorDto proveedorDto){
        proveedorService.registrarProveedor(proveedorDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ProveedorDto buscarProveedor(@PathVariable Long id){
        return proveedorService.buscarProveedor(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarProveedor(@RequestBody ProveedorDto proveedorDto){
        proveedorService.modificarProveedor(proveedorDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> eliminarProveedor(@PathVariable Long id){
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<ProveedorDto> listarProveedores(){
        return proveedorService.listarProveedores();
    }
}

