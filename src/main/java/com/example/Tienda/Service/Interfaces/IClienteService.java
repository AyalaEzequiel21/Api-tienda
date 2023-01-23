package com.example.Tienda.Service.Interfaces;

import com.example.Tienda.Model.Dto.ClienteDto;

import java.util.Set;

public interface IClienteService {

    void registrarCliente(ClienteDto clienteDto);
    ClienteDto buscarCliente(Long id);
    void modificarCliente(ClienteDto clienteDto);
    void eliminarCliente(Long id);
    Set<ClienteDto> listarClientes();
}
