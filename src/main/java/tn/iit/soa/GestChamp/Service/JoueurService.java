package tn.iit.soa.GestChamp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.soa.GestChamp.Entity.Joueur;
import tn.iit.soa.GestChamp.Repository.JoueurRepository;

@Service
public class JoueurService {

	@Autowired
	private JoueurRepository joueurRepository;

	public List<Joueur> getAllJoueurs() {
		return joueurRepository.findAll();
	}

	public Joueur getJoueurById(Long id) {
		return joueurRepository.findById(id).orElse(null);
	}

	public Joueur createJoueur(Joueur joueur) {
		Joueur savedJoueur = joueurRepository.save(joueur);
		System.out.println("Joueur créé avec succès. ID: " + savedJoueur.getId());
		return savedJoueur;
	}

	public Joueur updateJoueur(Long id, Joueur joueurDetails) {
		Joueur joueur = joueurRepository.findById(id).orElse(null);

		if (joueur != null) {
			joueur.setNom(joueurDetails.getNom());
			joueur.setPrenom(joueurDetails.getPrenom());
			joueur.setDateNaissance(joueurDetails.getDateNaissance());
			joueur.setPoste(joueurDetails.getPoste());
			joueur.setNationalite(joueurDetails.getNationalite());

			return joueurRepository.save(joueur);
		}

		return null; 
	}

	public void deleteJoueur(Long id) {
		joueurRepository.deleteById(id);
	}
}
