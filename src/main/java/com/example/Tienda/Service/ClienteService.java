package com.example.Tienda.Service;

import com.example.Tienda.Model.Dto.ClienteDto;
import com.example.Tienda.Model.Entity.Cliente;
import com.example.Tienda.Repository.IClienteRepository;
import com.example.Tienda.Service.Interfaces.IClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRespository;

    @Autowired
    ObjectMapper mapper;

    private void guardar(ClienteDto clienteDto){
        Cliente cliente = mapper.convertValue(clienteDto, Cliente.class);
        clienteRespository.save(cliente);
    }

    @Override
    public void registrarCliente(ClienteDto clienteDto) {
        List<Cliente> clientes = clienteRespository.findAll();
        boolean comparation = false;
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(clienteDto.getDni())) {
                comparation = true;
                cliente.setActivo(true);
                clienteRespository.save(cliente);
                break;
            }
        }
        if (!comparation){
            guardar(clienteDto);
        }
    }

    @Override
    public ClienteDto buscarCliente(Long id) {
       List<Cliente> clientes = clienteRespository.findAll();
       ClienteDto clienteDto = null;
       for(Cliente cliente : clientes){
           if (cliente.getId().equals(id) & cliente.getActivo()){
               clienteDto = mapper.convertValue(cliente, ClienteDto.class);
                break;
           }
       }
       return clienteDto;
    }

    @Override
    public void modificarCliente(ClienteDto clienteDto) {
    guardar(clienteDto);
    }

    @Override
    public void eliminarCliente(Long id) {
        List<Cliente> clientes = clienteRespository.findAll();
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)){
                cliente.setActivo(false);
                clienteRespository.save(cliente);
                break;
            }
        }
    }

    @Override
    public Set<ClienteDto> listarClientes() {
        List<Cliente> clientes = clienteRespository.findAll();
        Set<ClienteDto> clientesDto = new HashSet<>();

        for(Cliente cliente : clientes){
            clientesDto.add(mapper.convertValue(cliente, ClienteDto.class));
        }
        return clientesDto;
    }
}
