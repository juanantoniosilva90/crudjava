package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.modelo.Persona;
@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas=service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model){
		model.addAttribute("persona", new Persona());
		return "form";
	}
	@PostMapping("/save")
	public String save(@Valid Persona p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	
	

}
