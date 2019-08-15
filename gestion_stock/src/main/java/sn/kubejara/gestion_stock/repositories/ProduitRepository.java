package sn.kubejara.gestion_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.kubejara.gestion_stock.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
}
