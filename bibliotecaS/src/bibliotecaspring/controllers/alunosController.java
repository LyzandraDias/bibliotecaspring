package bibliotecaspring.controllers;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.daos.AlunoDAO;
import bibliotecaspring.models.Aluno;

@Controller
public class alunosController {

	@RequestMapping("/alunos/form")
	public String form() {
		System.out.println("chamou meu método");
		return "aluno/Form";
	}
	
	@PostMapping("/alunos")
	public String adicionar(Aluno aluno) {
		System.out.println("chamou o método de adicionar");
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserir(aluno);
		return "redirect:alunos";
	}
	
	@GetMapping("/alunos")
	public ModelAndView listar() {
		System.out.println("chamou o metódo listagem");
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.getLista();
		ModelAndView model = new ModelAndView("aluno/listarAlunos");
		model.addObject("alunos", lista);
		return model;
		
	}
	
	@RequestMapping("/alunos/remover")
	public String remover(Aluno aluno) {
		System.out.println("chamou o método remover.");
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.remover(aluno);
		
		return "redirect:../aluno";
			
	}
}
