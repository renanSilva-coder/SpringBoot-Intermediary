package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/estudantes")
@AllArgsConstructor
public class EstudanteController {
	
	private EstudanteService estudanteService;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Buscar estudante por ID", notes = "Método usado para buscar um estudante por ID")
	@ApiResponses(
			{
				@ApiResponse(code = 401, message = "Acesso não autorizado."),
				@ApiResponse(code = 403, message = "Proibido."),
				@ApiResponse(code = 404, message = "Não encontrado."),
			})
	public ResponseEntity<Estudante> buscaEstudantePorId(@PathVariable Long id){
		return estudanteService.buscaEstudantePorId(id);
	}
	
	@GetMapping
	public Page<Estudante> buscarTodosEstudantes(
			@RequestParam(defaultValue = "0") Integer pagina,
			@RequestParam(defaultValue = "5") Integer itensPorPagina){
		return estudanteService.buscarTodosEstudantes(PageRequest.of(pagina, itensPorPagina));
	}
	
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante){
		return estudanteService.cadastrarEstudante(estudante);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante){
		return estudanteService.atualizarEstudante(id, estudante);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarEstudante(@PathVariable Long id){
		return estudanteService.deletarEstudante(id);
	}
	
	@GetMapping("/naoAvaliaram")
	public List<Estudante> buscaEstudanteNaoAvaliaram(){
		return estudanteService.buscaEstudanteNaoAvaliaram();
	}
}
