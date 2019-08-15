package sn.kubejara.gestion_stock.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.kubejara.gestion_stock.entities.Utilisateur;
import sn.kubejara.gestion_stock.repositories.UtilisateurRepository;


@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	@GetMapping
	public List<Utilisateur> getUsers() {
        return utilisateurRepository.findAll();
    }
	
	@GetMapping(value="/{id}")
	public Utilisateur getUserById(@PathVariable long id) {
		return utilisateurRepository.findById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> add(@RequestBody Utilisateur user) {
		utilisateurRepository.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping (value = "/{id}")
	   public void deleteUser(@PathVariable long id) {

	       utilisateurRepository.deleteById(id);
	   }
	
	@DeleteMapping 
	   public void deleteallUser() {

	       utilisateurRepository.deleteAll();
	   }
	
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	  public void updateUtilisateur(@PathVariable int idUser,@RequestBody Utilisateur user) {

		utilisateurRepository.save(user);
	  }
	

}
