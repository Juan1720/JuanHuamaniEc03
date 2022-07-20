package com.idat.pe.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.com.dto.HospitalDTORequest;
import com.idat.pe.com.dto.HospitalDTOResponse;
import com.idat.pe.com.model.Hospital;
import com.idat.pe.com.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository repo;
	
	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		
		Hospital o = new Hospital();
		o.setNombre(hospital.getDistrito());
		o.setDescripcion(hospital.getDescripcion());
		o.setDistrito(hospital.getDistrito());
		repo.save(o);
		
	}

	@Override
	public void actualizarHospital(HospitalDTORequest hospital) {
		
		Hospital o = new Hospital();
		o.setIdHopsital(hospital.getIdHospital());
		o.setNombre(hospital.getDistrito());
		o.setDescripcion(hospital.getDescripcion());
		o.setDistrito(hospital.getDistrito());
		repo.saveAndFlush(o);
	}

	@Override
	public void eliminarHopsital(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<HospitalDTOResponse> listarHospitales() {
		
		List<HospitalDTOResponse> listar  = new ArrayList<>();
		HospitalDTOResponse dto = null;
		List<Hospital> o = repo.findAll();
		
		for(Hospital hospital: o) {
			
			dto = new HospitalDTOResponse();
			dto.setNombre(hospital.getNombre());
			dto.setDescripcion(hospital.getDescripcion());
			dto.setDistrito(hospital.getDistrito());
			dto.setIdHospital(hospital.getIdHopsital());
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtnerHospitalId(Integer id) {
		
		
		Hospital hospital = repo.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		dto.setDescripcion(hospital.getDescripcion());
		dto.setNombre(hospital.getNombre());
		dto.setDistrito(hospital.getDistrito());
		dto.setIdHospital(hospital.getIdHopsital());
		return dto;
	}
	
	

}
