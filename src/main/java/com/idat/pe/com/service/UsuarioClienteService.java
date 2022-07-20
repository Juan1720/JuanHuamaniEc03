package com.idat.pe.com.service;

import java.util.List;

import com.idat.pe.com.dto.UsuarioClienteDTORequest;
import com.idat.pe.com.dto.UsuarioClienteDTOResponse;



public interface UsuarioClienteService {
	
	void guardarUsuario(UsuarioClienteDTORequest usuario);
	void actualizarUsuario(UsuarioClienteDTORequest usuario);
	void eliminarUsuario(Integer id);
	List<UsuarioClienteDTOResponse> listarUsuario();
	UsuarioClienteDTOResponse obtnerUsuarioId(Integer id);

}
