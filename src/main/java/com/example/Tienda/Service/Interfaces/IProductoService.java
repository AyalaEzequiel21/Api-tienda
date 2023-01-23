package com.example.Tienda.Service.Interfaces;

import com.example.Tienda.Model.Dto.ProductoDto;
import java.util.Set;

public interface IProductoService {

    void registrarProducto(ProductoDto productoDto);
    ProductoDto buscarProductoPorId(Long id);
    Set<ProductoDto> buscarProductoPorStock(int stock);
    void modificarProducto(ProductoDto productoDto);
    void eliminarProducto(Long id);
    Set<ProductoDto> listarProductos();
}
