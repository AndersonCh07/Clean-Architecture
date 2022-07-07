package com.example.demo.Cliente.Dominio.servicio;

import com.example.demo.Cliente.Dominio.entidad.Cliente;
import com.pragma.demo.dominio.entidad.Book;

public interface ClienteDomainServiceInterface {

	Cliente findClienteById(String id);

	Cliente listAllClients();

	Cliente createClient(Cliente cliente);

	Cliente updateClient(Cliente cliente);

	Cliente deleteClient(Long numero_id);

}
