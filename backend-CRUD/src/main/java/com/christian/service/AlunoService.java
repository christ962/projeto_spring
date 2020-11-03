package com.christian.service;

import java.util.List;
import java.util.Optional;

import com.christian.model.Aluno;

public interface AlunoService {
	
	Optional<Aluno> getAlunoById(Integer id);
	List<Aluno> getAllAlunos();
	void deleteAlunos();
	void deleteAlunoById(Integer id);
	void updateAlunoById(Integer id, Aluno aluno);
	void upadateAluno(Aluno aluno);
	void insertAluno(Aluno aluno);

}
