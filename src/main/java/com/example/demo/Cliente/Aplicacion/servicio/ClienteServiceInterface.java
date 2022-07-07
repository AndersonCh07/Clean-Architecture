package com.example.demo.Cliente.Aplicacion.servicio;

import java.util.List;

import com.example.demo.Cliente.Aplicacion.dto.ClienteDto;
import com.example.demo.Cliente.Dominio.entidad.Cliente;

public interface ClienteServiceInterface {

	ClienteDto findClientsById(String id);

	List<Cliente> listAllClients();

	List<Cliente> findClientsbyAgeRange(int edad_inicial, int edad_final);

	List<Cliente> findClientsbyIdType(String tipo_documento);

	ClienteDto createClient(Cliente cliente);

	ClienteDto updateClient(Cliente cliente);

	ClienteDto deleteClient(Long numero_id);

}
