package com.example.Tienda.Service;

import com.example.Tienda.Model.Dto.CompraProveedorDto;
import com.example.Tienda.Model.Entity.CompraProveedor;
import com.example.Tienda.Repository.ICompraProveedorRepository;
import com.example.Tienda.Service.Interfaces.ICompraProveedorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CompraProveedorService implements ICompraProveedorService {

    @Autowired
    private ICompraProveedorRepository compraProveedorRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void registarCompraProveedor(CompraProveedorDto compraDto) {
        CompraProveedor compra = mapper.convertValue(compraDto, CompraProveedor.class);
        compraProveedorRepository.save(compra);
    }

    @Override
    public Set<CompraProveedorDto> buscarCompraProveedorPorProveedor(Long idProveedor) {
        List<CompraProveedor> compras = compraProveedorRepository.findAll();
        Set<CompraProveedorDto> comprasDeEseProveedor = new HashSet<>();
        for (CompraProveedor compra : compras){
            if (compra.getProveedor().getId().equals(idProveedor)){
                comprasDeEseProveedor.add(mapper.convertValue(compra, CompraProveedorDto.class));
            }
        }
        return comprasDeEseProveedor;
    }

    @Override
    public Set<CompraProveedorDto> buscarComprasProveedorPorFecha(LocalDate fecha) {
        List<CompraProveedor> compras = compraProveedorRepository.findAll();
        Set<CompraProveedorDto> comprasDeEsaFecha = new HashSet<>();
        for (CompraProveedor compra : compras){
            if (compra.getFecha().equals(fecha)){
                comprasDeEsaFecha.add(mapper.convertValue(compra, CompraProveedorDto.class));
            }
        }
        return comprasDeEsaFecha;
    }

    @Override
    public Set<CompraProveedorDto> listarComprasProveedor() {
        List<CompraProveedor> compras = compraProveedorRepository.findAll();
        Set<CompraProveedorDto> comprasProveedorDto = new HashSet<>();
        for (CompraProveedor compra : compras){
            comprasProveedorDto.add(mapper.convertValue(compra, CompraProveedorDto.class));
        }
        return comprasProveedorDto;
    }
}
