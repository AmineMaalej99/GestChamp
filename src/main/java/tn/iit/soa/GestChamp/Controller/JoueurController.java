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

import tn.iit.soa.GestChamp.Entity.Joueur;
import tn.iit.soa.GestChamp.Service.JoueurService;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

	@Autowired
	private JoueurService joueurService;

	@GetMapping
	public List<Joueur> getAllJoueurs() {
		return joueurService.getAllJoueurs();
	}

	@GetMapping("/{id}")
	public Joueur getJoueurById(@PathVariable Long id) {
		return joueurService.getJoueurById(id);
	}

	@PostMapping("/createJoueur")
	public Joueur createJoueur(@RequestBody Joueur joueur) {
		return joueurService.createJoueur(joueur);
	}

	@PutMapping("/{id}")
	public Joueur updateJoueur(@PathVariable Long id, @RequestBody Joueur joueurDetails) {
		return joueurService.updateJoueur(id, joueurDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteJoueur(@PathVariable Long id) {
		joueurService.deleteJoueur(id);
	}
}
