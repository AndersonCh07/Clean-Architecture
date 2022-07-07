package com.pragma.demo.infraestructura.configuracion;

import com.example.demo.Cliente.Aplicacion.mapper.ClienteDtoMapperCliente;
import com.example.demo.Cliente.Aplicacion.servicio.ClienteServiceImpl;
import com.example.demo.Cliente.Dominio.repositorio.ClienteRepository;
import com.example.demo.Cliente.Dominio.servicio.ClienteDomainServiceImpl;
import com.example.demo.Cliente.Dominio.servicio.ClienteDomainServiceInterface;
import com.pragma.demo.aplicacion.mapper.BookDtoMapperBook;
import com.pragma.demo.aplicacion.servicio.BookServiceImpl;
import com.pragma.demo.dominio.repositorio.BookRepository;
import com.pragma.demo.dominio.servicio.BookDomainServiceImpl;
import com.pragma.demo.dominio.servicio.BookDomainServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClienteServiceImpl clienteService(ClienteDomainServiceInterface clienteDomainServiceInterface, ClienteDtoMapperCliente clienteDtoMapperCliente){
        return new ClienteServiceImpl(clienteDomainServiceInterface, clienteDtoMapperCliente);
    }

    @Bean
    public ClienteDomainServiceImpl clienteDomainServiceImpl(ClienteRepository clienteRepository){
        return new ClienteDomainServiceImpl(clienteRepository);
    }

}
