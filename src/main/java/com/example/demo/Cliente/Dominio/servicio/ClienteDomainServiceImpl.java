package com.example.demo.Cliente.Dominio.servicio;

import com.example.demo.Cliente.Dominio.entidad.Cliente;
import com.example.demo.Cliente.Dominio.repositorio.ClienteRepository;
import com.pragma.demo.dominio.entidad.Book;
import com.pragma.demo.dominio.repositorio.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteDomainServiceImpl implements ClienteDomainServiceInterface{

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente findClienteById(String id) {
        return clienteRepository.getById(id);
    }

}
