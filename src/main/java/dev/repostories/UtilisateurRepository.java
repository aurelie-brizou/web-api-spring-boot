package dev.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entities.Utilisateur;

// l'interface extends JpaRepository qui prend l'entité et le type de l'id
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
