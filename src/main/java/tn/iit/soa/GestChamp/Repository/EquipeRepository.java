package tn.iit.soa.GestChamp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.soa.GestChamp.Entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	List<Equipe> findByVille(String ville); 
}
