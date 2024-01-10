package tn.iit.soa.GestChamp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.soa.GestChamp.Entity.Equipe;
import tn.iit.soa.GestChamp.Repository.EquipeRepository;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository;

	public List<Equipe> getAllEquipes() {
		return equipeRepository.findAll();
	}

	public Equipe getEquipeById(Long id) {
		return equipeRepository.findById(id).orElse(null);
	}

	public Equipe createEquipe(Equipe equipe) {
		Equipe savedEquipe = equipeRepository.save(equipe);
		System.out.println("Equipe créée avec succès. ID: " + savedEquipe.getId());
		return savedEquipe;
	}

	public Equipe updateEquipe(Long id, Equipe equipeDetails) {
		Equipe equipe = equipeRepository.findById(id).orElse(null);

		if (equipe != null) {
			equipe.setNom(equipeDetails.getNom());
			equipe.setVille(equipeDetails.getVille());
			equipe.setCouleurs(equipeDetails.getCouleurs());

			return equipeRepository.save(equipe);
		}

		return null; // Gérer autrement (par exemple, lancer une exception)
	}

	public void deleteEquipe(Long id) {
		equipeRepository.deleteById(id);
	}

	public List<Equipe> getEquipesByVille(String ville) {
		return equipeRepository.findByVille(ville);
	}
}
