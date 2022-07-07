package com.example.demo.Cliente.Aplicacion.mapper;

import com.example.demo.Cliente.Aplicacion.dto.ClienteDto;
import com.example.demo.Cliente.Dominio.entidad.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapperCliente {

    ClienteDto toClienteDto(Cliente cliente);

    Cliente toCliente(ClienteDto cliente);

}
