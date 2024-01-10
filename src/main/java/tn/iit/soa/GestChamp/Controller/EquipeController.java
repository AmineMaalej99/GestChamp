package tn.iit.soa.GestChamp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.soa.GestChamp.Entity.Equipe;
import tn.iit.soa.GestChamp.Service.EquipeService;

// importez d'autres classes nécessaires

@RestController
@RequestMapping("/equipes")
public class EquipeController {

	@Autowired
	private EquipeService equipeService;

	@GetMapping
	public List<Equipe> getAllEquipes() {
		return equipeService.getAllEquipes();
	}

	@GetMapping("/{id}")
	public Equipe getEquipeById(@PathVariable Long id) {
		return equipeService.getEquipeById(id);
	}

	@PostMapping("/createEquipe")
	public Equipe createEquipe(@RequestBody Equipe equipe) {
		return equipeService.createEquipe(equipe);
	}

	@PutMapping("/{id}")
	public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe equipeDetails) {
		return equipeService.updateEquipe(id, equipeDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteEquipe(@PathVariable Long id) {
		equipeService.deleteEquipe(id);
	}

	@GetMapping("/byVille/{ville}")
	public List<Equipe> getEquipesByVille(@PathVariable String ville) {
		return equipeService.getEquipesByVille(ville);
	}

}
