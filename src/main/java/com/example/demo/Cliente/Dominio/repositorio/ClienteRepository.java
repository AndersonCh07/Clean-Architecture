package com.example.demo.Cliente.Dominio.repositorio;

import com.example.demo.Cliente.Dominio.entidad.Cliente;

public interface ClienteRepository {

	Cliente getById(String id);

}
