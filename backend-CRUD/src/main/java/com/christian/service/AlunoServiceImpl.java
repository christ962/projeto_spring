package com.christian.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.christian.model.Aluno;
import com.christian.repository.AlunoRepository;
@Service("alunoService")
public class AlunoServiceImpl implements AlunoService {
	
	private AlunoRepository alunoRepository;

	@Override
	public Optional<Aluno> getAlunoById(Integer id) {
		
		return alunoRepository.findById(id);
	}

	@Override
	public List<Aluno> getAllAlunos() {
		
		return alunoRepository.findAll();
	}

	@Override
	public void deleteAlunos() {
		
		alunoRepository.deleteAll();
	}

	@Override
	public void deleteAlunoById(Integer id) {
		
		alunoRepository.deleteById(id);
	}

	@Override
	public void updateAlunoById(Integer id, Aluno aluno) {
		Optional<Aluno> getAluno = getAlunoById(id);
		getAluno.get().setNome(aluno.getNome());
		getAluno.get().setEmail(aluno.getEmail());
		
		alunoRepository.save(aluno);
	}

	@Override
	public void upadateAluno(Aluno aluno) {
		
		alunoRepository.save(aluno);
	}

	@Override
	public void insertAluno(Aluno aluno) {
		alunoRepository.save(aluno);
	}

}
