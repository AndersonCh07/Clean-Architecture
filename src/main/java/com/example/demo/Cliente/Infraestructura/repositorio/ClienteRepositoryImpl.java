package com.example.demo.Cliente.Infraestructura.repositorio;

import com.example.demo.Cliente.Dominio.entidad.Cliente;
import com.example.demo.Cliente.Dominio.repositorio.ClienteRepository;
import com.example.demo.Cliente.Infraestructura.dao.ClienteDao;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

	@Autowired
    private ClienteDao clienteDao;

    @Override
    public Cliente getById(String id) {
        return clienteDao.getById(id);
    }

}
