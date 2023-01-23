package com.example.Tienda.Service;

import com.example.Tienda.Model.Dto.ClienteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testCreacCliente(){
        ClienteDto cliente = new ClienteDto();
        cliente.setNombre("Ezequiel");
        cliente.setApellido("Lopes");
        cliente.setDireccion("calle 123");
        cliente.setTelefono(112356);
        cliente.setDni("33567890");

        ClienteDto clienteEze = clienteService.buscarCliente(1L);

    }

}