package com.christian.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.christian.model.Aluno;
import com.christian.service.AlunoService;

@RestController
public class AlunoController {
 
	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(value = "rest/getAll", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<Aluno> getAlunos(){
		return alunoService.getAllAlunos(); 
	}
	
	@RequestMapping(value = "rest/get/{id}", method = RequestMethod.GET)
	public Optional<Aluno> getAluno(@PathVariable("id") Integer id){
		 return alunoService.getAlunoById(id);
	}
	
	@RequestMapping(value = "rest/deletAll", method = RequestMethod.DELETE)
	public void deleteAlunos() {
		alunoService.deleteAlunos();
	}
	
	@RequestMapping(value = "rest/delet/{id}", method = RequestMethod.DELETE)
	public void deleteAluno(@PathVariable("id") Integer id) {
		alunoService.deleteAlunoById(id);
	}
	
	@RequestMapping(value = "rest/update/{id}", method = RequestMethod.POST)
	public void updateAluno(@RequestBody Aluno aluno ,@PathVariable ("id") Integer id) {
		alunoService.updateAlunoById(id, aluno);
	}
	
	@RequestMapping(value = "rest/insert", method = RequestMethod.PUT)
	public void updateAluno(@RequestBody Aluno aluno) {
	alunoService.insertAluno(aluno);
	}
	
	
}
