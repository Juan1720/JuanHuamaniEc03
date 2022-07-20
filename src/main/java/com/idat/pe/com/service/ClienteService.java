package com.idat.pe.com.service;

import java.util.List;

import com.idat.pe.com.dto.ClienteDTORequest;
import com.idat.pe.com.dto.ClienteDTOResponse;


public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarclientes();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
