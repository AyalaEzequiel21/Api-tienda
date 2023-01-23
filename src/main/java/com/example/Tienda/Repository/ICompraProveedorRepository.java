package com.example.Tienda.Repository;

import com.example.Tienda.Model.Entity.CompraProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraProveedorRepository extends JpaRepository<CompraProveedor, Long> {
}
