package com.example.demo.Cliente.Infraestructura.controlador;

import com.example.demo.Cliente.Aplicacion.dto.ClienteDto;
import com.example.demo.Cliente.Aplicacion.servicio.ClienteServiceInterface;
import com.example.demo.Cliente.Dominio.Exception.ErrorMessage;
import com.example.demo.Cliente.Dominio.entidad.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("Cliente")
public class Controller {

    @Autowired
    ClienteServiceInterface clienteServiceInterface;
    
    @GetMapping("/listar") 
    public ResponseEntity<List<Cliente>> listClients(){
    	List<Cliente> cliente = clienteServiceInterface.listAllClients();
    	if(cliente.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}
        return ResponseEntity.ok(cliente);
    }
    
    @GetMapping("/consultar/id/{numero_documento}")
    public ResponseEntity<Cliente> consultbyId(@PathVariable Long numero_documento){
    	Cliente cliente = clienteServiceInterface.findbyId(numero_documento);
    	if(cliente == null) {
    		return ResponseEntity.notFound().build();
    	}
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }
    
    @GetMapping("/consultar/tipo_id/{tipo_documento}")
    public ResponseEntity<List<Cliente>> listbyIdType(@PathVariable String tipo_documento){
    	List<Cliente> cliente = clienteServiceInterface.findbyIdType(tipo_documento);
    	if(cliente.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}
		return ResponseEntity.ok(cliente);   	
    }
    
    @GetMapping("/consultar/rango_edad/{edad_inicial}/{edad_final}")
    public ResponseEntity<List<Cliente>> listbyAgeRange(@PathVariable int edad_inicial, int edad_final){
    	List<Cliente> cliente = clienteServiceInterface.findbyAgeRange(edad_inicial,edad_final);
    	if(cliente.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}
		return ResponseEntity.ok(cliente);	
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Cliente> createClient(@Valid @RequestBody Cliente cliente, BindingResult result){
    	
    	if(result.hasErrors()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    	}
    	
    	Cliente clientCreated = clienteServiceInterface.createClient(cliente);
    	
		return ResponseEntity.status(HttpStatus.CREATED).body(clientCreated);   	
    }
    
    @PutMapping("/editar/{numero_id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long numero_id, @RequestBody ClienteDto cliente){
    	cliente.setNumero_identificacion(numero_id);
    	Cliente clientDB = clienteServiceInterface.updateClient(cliente);
    	if(clientDB == null) {
    		return ResponseEntity.notFound().build();
    	}
		return ResponseEntity.ok(cliente);	
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Cliente> deleteClient(@PathVariable Long numero_id){
    	Cliente clientDelete = clienteServiceInterface.deleteClient(numero_id);
    	if(clientDelete == null) {
    		return ResponseEntity.notFound().build();
    	}
		return ResponseEntity.ok(clientDelete);   	
    }
    
    private String formatMessage(BindingResult result) {
    	List<Map<String, String>> errors = result.getFieldErrors().stream()
    			.map(err ->{
    				Map<String, String> error = new HashMap<>();
    				error.put(err.getField(), err.getDefaultMessage());
    				return error;
    			}).collect(Collectors.toList());
    	ErrorMessage errorMessage = ErrorMessage.builder()
    			.code("01")
    			.messages(errors).build();
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonString = "";
    	try {
    		jsonString = mapper.writeValueAsString(errorMessage);
    	}catch (JsonProcessingException e){
    		e.printStackTrace();
    	}
    	return jsonString;
    }
    
}
