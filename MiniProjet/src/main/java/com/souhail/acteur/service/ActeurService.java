package com.souhail.acteur.service;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.souhail.acteur.entities.Film;
import com.souhail.acteur.entities.Acteur;
public interface ActeurService {
	Acteur saveActeur(Acteur a);
	Acteur updateActeur(Acteur a);
	void deleteActeur(Acteur a);
	void deleteActeurById(Long id);
	Acteur getActeur(Long id);
	List<Acteur> getAllActeurs();
	Page<Acteur> getAllActeursParPage(int page, int size);
	List<Acteur> findByNomActeur(String nom);
	List<Acteur> findByNomActeurContains(String nom);
	List<Acteur> findByNomSalaire (String nom, Double salaire);
	List<Acteur> findByFilm (Film film);
	List<Acteur> findByFilmIdFilm(Long id);
	List<Acteur> findByOrderByNomActeurAsc();
	List<Acteur> trierActeursNomsSalaire();
	List<Acteur> findActeurByNomFilm(@Valid String nomFilm);
	
}
