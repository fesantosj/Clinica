package med.saude.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import med.saude.domain.Especialidade;
import med.saude.dao.EspecialidadeDao;
import med.saude.domain.Medico;
import med.saude.service.EspecialidadeService;
import med.saude.service.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private EspecialidadeService especialidadeService;
	//function insert
	
	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {
		Medico medico = new Medico();
		List<Especialidade> list = especialidadeService.buscarTodos();	
		model.addAttribute("medico", medico);
		model.addAttribute("especialidade", list);				
		return "/medico/cadastro";
	}
	
	//function list
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("medicos", medicoService.buscarTodos());
		return "/medico/lista";
	}
			
	//function save
	@PostMapping("/salvar")
	public String salvar(Medico medico) {
		medicoService.salvar(medico);
		return "redirect:/medicos/cadastrar";
	}
	
	/*
	 * functions edit
	 */
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("medico", medicoService.buscarPorId(id));
		return "/medico/cadastro";
	}
	@PostMapping("/editar")
	public String editar(Medico medico) {
		medicoService.editar(medico);
		return "redirect:/medicos/listar";
	}
	//function delete
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		medicoService.excluir(id);
		return listar(model);		 
	}
	
	
	
}
