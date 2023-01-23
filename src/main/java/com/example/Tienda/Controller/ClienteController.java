package com.example.Tienda.Controller;

import com.example.Tienda.Model.Dto.ClienteDto;
import com.example.Tienda.Service.Interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody ClienteDto clienteDto){
        clienteService.registrarCliente(clienteDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable Long id){
        return clienteService.buscarCliente(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarCliente(@RequestBody ClienteDto clienteDto){
        clienteService.modificarCliente(clienteDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<ClienteDto> listarClientes(){
        return clienteService.listarClientes();
    }
}
