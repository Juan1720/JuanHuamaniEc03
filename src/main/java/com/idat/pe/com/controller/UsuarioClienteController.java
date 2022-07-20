package com.idat.pe.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.pe.com.dto.UsuarioClienteDTORequest;
import com.idat.pe.com.dto.UsuarioClienteDTOResponse;
import com.idat.pe.com.service.UsuarioClienteService;

@Controller
@RequestMapping("/usuario/v1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<UsuarioClienteDTOResponse>> listar(){
		return new ResponseEntity<List<UsuarioClienteDTOResponse>>(service.listarUsuario(), HttpStatus.OK) ;
		
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteDTORequest usuario) {
		service.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UsuarioClienteDTOResponse usuario = service.obtnerUsuarioId(id);
		if(usuario != null) {
			service.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody UsuarioClienteDTORequest usuario){
		
		UsuarioClienteDTOResponse u = service.obtnerUsuarioId(usuario.getIdUsuario());
		if(u != null) {
			service.actualizarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioClienteDTOResponse> obtenerId(@PathVariable Integer id){
		
		UsuarioClienteDTOResponse u = service.obtnerUsuarioId(id);
		if(u != null) {
			return new ResponseEntity<UsuarioClienteDTOResponse>(service.obtnerUsuarioId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<UsuarioClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}

}
