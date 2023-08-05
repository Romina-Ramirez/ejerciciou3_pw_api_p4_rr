package com.uce.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public List<VehiculoTO> consultarTodos() {
		List<Vehiculo> lista = this.vehiculoRepository.consultarTodos();
		List<VehiculoTO> listaTO = new ArrayList<>();
		for (Vehiculo v : lista) {
			VehiculoTO vto = this.convertir(v);
			listaTO.add(vto);
		}
		return listaTO;
	}

	@Override
	public VehiculoTO consultarPorNumero(String numero) {
		return this.convertir(this.vehiculoRepository.consultarPorNumero(numero));
	}

	private VehiculoTO convertir(Vehiculo v) {
		VehiculoTO vto = new VehiculoTO();
		vto.setId(v.getId());
		vto.setPlaca(v.getPlaca());
		vto.setColor(v.getColor());
		vto.setMarca(v.getMarca());
		vto.setModelo(v.getModelo());
		return vto;
	}

}
