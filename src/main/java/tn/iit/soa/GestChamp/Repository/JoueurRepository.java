package tn.iit.soa.GestChamp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.soa.GestChamp.Entity.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}
