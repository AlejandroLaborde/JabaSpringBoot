package com.ar.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ar.form.models.User;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;


@Controller
public class FormControler {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo","Formulario");
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario(@Valid User usuario, BindingResult result, Model model) {
		System.out.println(result);
		if( result.hasErrors() ) {
			System.out.println("Entro aca?");
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(), err.getField() + " es requerido");
			});
			model.addAttribute("errores", errores);
			return "form";
		}
		model.addAttribute("titulo","Resultado formulario");
		model.addAttribute("usuario", usuario);
	
		return "resultado";
	}
	
}
