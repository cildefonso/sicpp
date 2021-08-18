package com.api.sicpp.controllers.categoria;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.sicpp.util.Constantes;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

	
	@RequestMapping(method=RequestMethod.GET)
    public String hello() {
        return Constantes.INFO_HEALTH;
    }
}
