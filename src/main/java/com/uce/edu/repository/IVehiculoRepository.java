package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public List<Vehiculo> consultarTodos();

	public Vehiculo consultarPorNumero(String numero);

}
