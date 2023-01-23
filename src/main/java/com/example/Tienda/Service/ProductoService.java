package com.example.Tienda.Service;

import com.example.Tienda.Model.Dto.ProductoDto;
import com.example.Tienda.Model.Entity.Producto;
import com.example.Tienda.Repository.IProductoRepository;
import com.example.Tienda.Service.Interfaces.IProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoReposity;

    @Autowired
    ObjectMapper mapper;

    private void guardarProducto(ProductoDto productoDto){
        Producto producto = mapper.convertValue(productoDto, Producto.class);
        productoReposity.save(producto);
    }
    @Override
    public void registrarProducto(ProductoDto productoDto) {
        List<Producto> productos = productoReposity.findAll();
        boolean comparation = false;
        for(Producto producto : productos){
            if (producto.getCodigoProducto().equals(productoDto.getCodigoProducto())){
                comparation = true;
                producto.setActivo(true);
                productoReposity.save(producto);
                break;
            }
        }
        if (!comparation){
            guardarProducto(productoDto);
        }
    }

    @Override
    public ProductoDto buscarProductoPorId(Long id) {
        List<Producto> productos = productoReposity.findAll();
        ProductoDto productoDto = null;
        for (Producto producto : productos){
            if (producto.getId().equals(id) & producto.getActivo()){
                productoDto = mapper.convertValue(producto, ProductoDto.class);
                break;
            }
        }
        return productoDto;
    }

    @Override
    public Set<ProductoDto> buscarProductoPorStock(int stock) {
        List<Producto> productos = productoReposity.findAll();
        Set<ProductoDto> productosDto = new HashSet<>();
        for (Producto producto : productos){
            if (producto.getStock() < stock){
                productosDto.add(mapper.convertValue(producto, ProductoDto.class));
            }
        }
        return productosDto;
    }

    @Override
    public void modificarProducto(ProductoDto productodto) {
        guardarProducto(productodto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoReposity.deleteById(id);
    }

    @Override
    public Set<ProductoDto> listarProductos() {
        List<Producto> productos = productoReposity.findAll();
        Set<ProductoDto> productosDto = new HashSet<>();
        for (Producto producto : productos){
            productosDto.add(mapper.convertValue(producto, ProductoDto.class));
        }
        return productosDto;
    }
}
