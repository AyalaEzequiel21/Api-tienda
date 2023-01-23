package com.example.Tienda.Service;

import com.example.Tienda.Model.Dto.ProveedorDto;
import com.example.Tienda.Model.Entity.Proveedor;
import com.example.Tienda.Repository.IProveedorRepository;
import com.example.Tienda.Service.Interfaces.IProveedorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarProveedor(ProveedorDto proveedorDto){
        Proveedor proveedor = mapper.convertValue(proveedorDto, Proveedor.class);
        proveedorRepository.save(proveedor);
    }

    @Override
    public void registrarProveedor(ProveedorDto proveedorDto) {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        boolean comparation = false;
        for (Proveedor proveedor : proveedores){
            if (proveedor.getCuit().equals(proveedorDto.getCuit())){
                comparation = true;
                proveedor.setActivo(true);
                proveedorRepository.save(proveedor);
                break;
            }
        }
        if (!comparation){
            guardarProveedor(proveedorDto);
        }
    }

    @Override
    public ProveedorDto buscarProveedor(Long id) {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        ProveedorDto proveedorDto = null;
        for (Proveedor proveedor : proveedores){
            if (proveedor.getId().equals(id) & proveedor.getActivo()){
                proveedorDto = mapper.convertValue(proveedor, ProveedorDto.class);
                break;
            }
        }
        return proveedorDto;
    }

    @Override
    public void modificarProveedor(ProveedorDto proveedorDto) {
        guardarProveedor(proveedorDto);
    }

    @Override
    public void eliminarProveedor(Long id) {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        for (Proveedor proveedor : proveedores){
            if (proveedor.getId().equals(id)){
                proveedor.setActivo(false);
                proveedorRepository.save(proveedor);
                break;
            }
        }
    }

    @Override
    public Set<ProveedorDto> listarProveedores() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        Set<ProveedorDto> proveedoresDto = new HashSet<>();
        for (Proveedor proveedor : proveedores){
            proveedoresDto.add(mapper.convertValue(proveedor, ProveedorDto.class));
        }
        return proveedoresDto;
    }
}
