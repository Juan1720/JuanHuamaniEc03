package com.idat.pe.com.service;

import java.util.List;

import com.idat.pe.com.dto.HospitalDTORequest;
import com.idat.pe.com.dto.HospitalDTOResponse;

public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest hospital);
	void actualizarHospital(HospitalDTORequest hospital);
	void eliminarHopsital(Integer id);
	List<HospitalDTOResponse> listarHospitales();
	HospitalDTOResponse obtnerHospitalId(Integer id);
	
}
