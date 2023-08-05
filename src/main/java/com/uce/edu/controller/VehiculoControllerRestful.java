package com.uce.edu.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.service.IVehiculoService;
import com.uce.edu.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoControllerRestful {

	@Autowired
	private IVehiculoService vehiculoService;

	@GetMapping
	public ResponseEntity<List<VehiculoTO>> consultarTodos() {
		List<VehiculoTO> lista = this.vehiculoService.consultarTodos();
		for (VehiculoTO v : lista) {
			Link myLink = linkTo(methodOn(VehiculoControllerRestful.class).consultarPorNumero(v.getPlaca()))
					.withSelfRel();
			v.add(myLink);
		}
		return new ResponseEntity<>(lista, null, 200);
	}

	@GetMapping(path = "/{numero}")
	public ResponseEntity<VehiculoTO> consultarPorNumero(@PathVariable String numero) {
		return new ResponseEntity<>(this.vehiculoService.consultarPorNumero(numero), null, 200);
	}

}
