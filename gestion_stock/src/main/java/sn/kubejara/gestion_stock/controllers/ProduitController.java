package sn.kubejara.gestion_stock.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sn.kubejara.gestion_stock.entities.Produit;
import sn.kubejara.gestion_stock.exceptions.ObjetIntrouvableException;
import sn.kubejara.gestion_stock.repositories.ProduitRepository;

@RequestMapping("/produits")
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping
	public List<Produit> getProduits(){
		return produitRepository.findAll();
		
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody Produit produit) {
		produitRepository.save(produit);
	}
	
	@DeleteMapping
	public void deleteProduit() {
		produitRepository.deleteAll();
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void modifierProduit(@PathVariable long id,@RequestBody Produit produit) throws ObjetIntrouvableException {
		Optional<Produit> product = produitRepository.findById(id);
		if (!product.isPresent()) {
			throw new ObjetIntrouvableException("L'utilisateur est introuvable"); 
		}
		
		produitRepository.save(produit);
	}
}
