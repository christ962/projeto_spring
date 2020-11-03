package com.christian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.christian.model.Aluno;
import com.christian.service.AlunoService;

@Controller
public class AlunoDbController {
  
	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(value = "/insert",method = RequestMethod.GET)
	public ModelAndView insert() {
		return new  ModelAndView("insert","aluno", new Aluno());
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String  submitInsert(@Validated @ModelAttribute("aluno ") Aluno aluno,BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		alunoService.insertAluno(aluno);
		return "redirect:";
	}
	@RequestMapping(value = "/detele",method = RequestMethod.DELETE)
	public ModelAndView delete (Integer id ) {
		return  new ModelAndView("delete","aluno", alunoService.getAlunoById(id).get());
	}
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdate(@Validated @ModelAttribute("aluno") Aluno aluno,BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			return "error";
		}
		alunoService.upadateAluno(aluno);
		return "redirect:";
	}
	
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public ModelAndView read() {
		ModelAndView mav = new ModelAndView("read");
		mav.addObject("aluno",alunoService.getAllAlunos());
	    return	mav;
	}
	@RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("aluno", alunoService.getAllAlunos());
    	return mav;
    }
	
}
