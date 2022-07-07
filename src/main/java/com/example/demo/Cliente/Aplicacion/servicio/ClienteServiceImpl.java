package com.example.demo.Cliente.Aplicacion.servicio;

import java.util.List;

import com.example.demo.Cliente.Aplicacion.dto.ClienteDto;
import com.example.demo.Cliente.Aplicacion.mapper.ClienteDtoMapperCliente;
import com.example.demo.Cliente.Dominio.entidad.Cliente;
import com.example.demo.Cliente.Dominio.servicio.ClienteDomainServiceInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteServiceInterface {

    private /*final*/ ClienteDomainServiceInterface clienteDomainServiceInterface;
    private /*final*/ ClienteDtoMapperCliente clienteDtoMapperCliente;
    
	@Override
	public ClienteDto findClientsById(String id) {
		// TODO Auto-generated method stub
		return clienteDtoMapperCliente.toClienteDto(clienteDomainServiceInterface.findClienteById(id));
	}
	@Override
	public List<Cliente> listAllClients() {
		// TODO Auto-generated method stub
		return clienteDtoMapperCliente.toClienteDto(clienteDomainServiceInterface.listAllClients());
	}
	@Override
	public List<Cliente> findClientsbyAgeRange(int edad_inicial, int edad_final) {
		// TODO Auto-generated method stub
		return clienteDtoMapperCliente.toClienteDto();
	}
	@Override
	public List<Cliente> findClientsbyIdType(String tipo_documento) {
		// TODO Auto-generated method stub
		return clienteDtoMapperCliente.toClienteDto();
	}
	@Override
	public ClienteDto createClient(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDtoMapperCliente.toClienteDto(clienteDomainServiceInterface.createClient(cliente));
	}
	@Override
	public ClienteDto updateClient(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDtoMapperCliente.toClienteDto(clienteDomainServiceInterface.updateClient(cliente));
	}
	@Override
	public ClienteDto deleteClient(Long numero_id) {
		// TODO Auto-generated method stub
		return clienteDtoMapperCliente.toClienteDto(clienteDomainServiceInterface.deleteClient(numero_id));
	}
    
	

    /*
    @Override
    public ClienteDto findClienteById(String id) {
        return ClienteDtoMapperCliente.toBookDto(ClienteDomainServiceInterface.findClienteById(id));
    }
    */

}
