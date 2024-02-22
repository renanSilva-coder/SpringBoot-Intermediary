package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/estudantes")
@AllArgsConstructor
public class EstudanteController {
	
	private EstudanteService estudanteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscaEstudantePorId(@PathVariable Long id){
		return estudanteService.buscaEstudantePorId(id);
	}
	
	@GetMapping
	public List<Estudante> buscarTodosEstudantes(){
		return estudanteService.buscarTodosEstudantes();
	}
	
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante){
		return estudanteService.cadastrarEstudante(estudante);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante){
		return estudanteService.atualizarEstudante(estudante);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarEstudante(@PathVariable Long id){
		return estudanteService.deletarEstudante(id);
	}
}
