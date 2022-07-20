package com.idat.pe.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.com.model.UsuarioCliente;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer> {
	
	UsuarioCliente findByUsuario(String usuario);

}
