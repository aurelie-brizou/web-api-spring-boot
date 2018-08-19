package dev.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.entities.Utilisateur;
import dev.repostories.UtilisateurRepository;

// @RestController permet d'exposer un service web de type REST
@RestController
// @RequestMapping servira à angular pour récupérer les données
@RequestMapping("/api/utilisateurs")
@CrossOrigin
public class UtilisateurApiController {
	
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurApiController(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	// lister les users
	@GetMapping
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurRepository.findAll();	
	}
	
	// trouver un utilisateur par id
	@GetMapping("/{id}")
	public Utilisateur getUtilisateurById(@PathVariable Long id) {
		Optional<Utilisateur> utilisateurOptional =  utilisateurRepository.findById(id);
		return utilisateurOptional.get();
	}
	
	// suppression d'un utilisateur
	@DeleteMapping("/{id}")
	public void deleteUtilisateur(@PathVariable Long id) {
		utilisateurRepository.deleteById(id);
	}
	
	// création d'un user
	@PostMapping
	public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur newUtilisateur = utilisateurRepository.save(utilisateur);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newUtilisateur.getId()).toUri();
		return ResponseEntity.created(location).body(newUtilisateur);
	}
	
	// modification d'un utilisateur
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		Optional<Utilisateur> UtilisateurOptional = utilisateurRepository.findById(id);
		if (!UtilisateurOptional.isPresent())
			return ResponseEntity.notFound().build();
		utilisateur.setId(id);
		utilisateurRepository.save(utilisateur);
		return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
	}

}
