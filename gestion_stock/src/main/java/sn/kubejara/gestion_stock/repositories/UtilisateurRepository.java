package sn.kubejara.gestion_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.kubejara.gestion_stock.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Utilisateur findById(long id);
}
