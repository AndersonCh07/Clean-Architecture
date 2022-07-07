package com.example.demo.Cliente.Infraestructura.dao;

import com.example.demo.Cliente.Dominio.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, String> {
}
