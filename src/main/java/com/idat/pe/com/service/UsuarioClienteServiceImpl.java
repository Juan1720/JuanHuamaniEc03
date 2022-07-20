package com.idat.pe.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.com.dto.ClienteDTOResponse;
import com.idat.pe.com.dto.UsuarioClienteDTORequest;
import com.idat.pe.com.dto.UsuarioClienteDTOResponse;
import com.idat.pe.com.model.UsuarioCliente;
import com.idat.pe.com.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService{

	@Autowired
	private UsuarioClienteRepository repo;
	
	@Override
	public void guardarUsuario(UsuarioClienteDTORequest usuario) {
		UsuarioCliente u  = new UsuarioCliente();
		u.setUsuario(usuario.getUsuario());
		u.setPassword(usuario.getPassword());
		u.setRol(usuario.getRol());
		repo.save(u);
		
	}

	@Override
	public void actualizarUsuario(UsuarioClienteDTORequest usuario) {
		
		UsuarioCliente u  = new UsuarioCliente();
		u.setIdUsuario(usuario.getIdUsuario());
		u.setUsuario(usuario.getUsuario());
		u.setPassword(usuario.getPassword());
		u.setRol(usuario.getRol());
		repo.saveAndFlush(u);
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<UsuarioClienteDTOResponse> listarUsuario() {
		
		List<UsuarioClienteDTOResponse> listar  = new ArrayList<>();
		UsuarioClienteDTOResponse dto = null;
		List<UsuarioCliente> u = repo.findAll();
		
		for(UsuarioCliente usuario: u) {
			
			dto = new UsuarioClienteDTOResponse();
			dto.setUsuario(usuario.getUsuario());
			dto.setPassword(usuario.getPassword());
			dto.setRol(usuario.getRol());
			dto.setIdUsuario(usuario.getIdUsuario());
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public UsuarioClienteDTOResponse obtnerUsuarioId(Integer id) {
		
		UsuarioCliente usuario = repo.findById(id).orElse(null);
		UsuarioClienteDTOResponse dto = new UsuarioClienteDTOResponse();
		dto.setUsuario(usuario.getUsuario());
		dto.setPassword(usuario.getPassword());
		dto.setRol(usuario.getRol());
		dto.setIdUsuario(usuario.getIdUsuario());
		return dto;

		
	}
	
	

}
