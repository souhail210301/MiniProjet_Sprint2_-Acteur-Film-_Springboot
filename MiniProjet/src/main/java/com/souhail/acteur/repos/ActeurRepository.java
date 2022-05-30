package com.souhail.acteur.repos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.souhail.acteur.entities.Film;
import com.souhail.acteur.entities.Acteur;

@RepositoryRestResource(path = "rest")
public interface ActeurRepository extends JpaRepository<Acteur, Long> {

		List<Acteur> findByNomActeur(String nom);
		List<Acteur> findByNomActeurContains(String nom);
		
		@Query("select a from Acteur a where a.nomActeur like %?1 and a.salaireActeur > ?2")
		List<Acteur> findByNomSalaire (String nom, Double salaire);
		
		@Query("select a from Acteur a where a.film = ?1")
		List<Acteur> findByFilm (Film film);
		
		List<Acteur> findByFilmIdFilm(Long id);
		
		List<Acteur> findByOrderByNomActeurAsc();

		@Query("select a from Acteur a order by a.nomActeur ASC, a.salaireActeur DESC")
		List<Acteur> trierActeursNomsSalaire ();
		
		@Query("select a from Acteur a, Film f where a.film.idFilm = f.idFilm and f.nomFilm like %:nomFilm%")
		List<Acteur> findActeurByNomFilm(@Param("nomFilm") String nomFilm);
		
		
		
		
		
}
