package com.idat.pe.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.com.dto.ClienteDTORequest;
import com.idat.pe.com.dto.ClienteDTOResponse;
import com.idat.pe.com.model.Cliente;
import com.idat.pe.com.repository.ClienteRepository;
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setNombre(cliente.getNombre());
		c.setCelular(cliente.getNombre());
		repo.save(c);


		
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setCelular(cliente.getNombre());
		repo.saveAndFlush(c);

		
	}

	@Override
	public void eliminarCliente(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<ClienteDTOResponse> listarclientes() {
		
		List<ClienteDTOResponse> listar = new ArrayList<>();
		ClienteDTOResponse dto = null;
		List<Cliente> c = repo.findAll();
		
		for(Cliente cliente: c) {
			dto = new ClienteDTOResponse();
			dto.setNombre(cliente.getNombre());
			dto.setCelular(cliente.getCelular());
			dto.setIdCliente(cliente.getIdCliente());
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		
		Cliente cliente = repo.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		dto.setNombre(cliente.getNombre());
		dto.setCelular(cliente.getCelular());
		dto.setIdCliente(cliente.getIdCliente());
		return dto;
	}
	
	

}
