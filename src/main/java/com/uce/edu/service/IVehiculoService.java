package com.uce.edu.service;

import java.util.List;

import com.uce.edu.service.to.VehiculoTO;

public interface IVehiculoService {

	public List<VehiculoTO> consultarTodos();

	public VehiculoTO consultarPorNumero(String numero);

}
