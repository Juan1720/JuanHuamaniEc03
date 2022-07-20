package com.idat.pe.com.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hospital")
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	
	@ManyToMany( cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "hospital_cliente",
			joinColumns = @JoinColumn(
					name = "id_hospital",
					nullable = false,
					unique = true,
					foreignKey = 
					@ForeignKey(foreignKeyDefinition = "foreign key (id_hospital) references Hospital(id_hospital)")),
			inverseJoinColumns = @JoinColumn(
					name = "id_cliente",
					nullable = false,
					unique = true,
					foreignKey = 
					@ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references cliente(id_cliente)"))
			)
	private List<Cliente> clientes = new ArrayList<>();
	
	public Integer getIdHopsital() {
		return idHospital;
	}
	public void setIdHopsital(Integer idHopsital) {
		this.idHospital = idHopsital;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	

}
