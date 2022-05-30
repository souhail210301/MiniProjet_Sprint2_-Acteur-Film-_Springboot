package com.souhail.acteur;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.souhail.acteur.entities.Film;
import com.souhail.acteur.entities.Acteur;
import com.souhail.acteur.repos.ActeurRepository;
import com.souhail.acteur.service.ActeurService;

@SpringBootTest
class ActeurApplicationTests {

	@Autowired
	private ActeurRepository acteurRepository;
	@Autowired
	private ActeurService acteurService ;
	@Test
	public void testCreateActeur() {
	Acteur act = new Acteur("Robert de Niro",500000.00,new Date());
	acteurRepository.save(act);
	}
	
	
	@Test
	public void testFindActeur()
	{
	Acteur a = acteurRepository.findById(1L).get();

	System.out.println(a);
	}
	@Test
	public void testUpdateActeur()
	{
	Acteur a = acteurRepository.findById(1L).get();
	a.setSalaireActeur(1000.0);
	acteurRepository.save(a);
	}
	@Test
	public void testDeleteActeur()
	{
	acteurRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousActeurs()
	{
	List<Acteur> acts = acteurRepository.findAll();
	for (Acteur a : acts)
	{
	System.out.println(a);
	}
}
	@Test
	public void testFindByNomActeur()
	{
	List<Acteur> acts = acteurRepository.findByNomActeur("Rober de Niro");

	for (Acteur a : acts)
	{
	System.out.println(a);
	}
	}
	@Test
	public void testFindByNomActeurContains()
	{
	List<Acteur> acts=acteurRepository.findByNomActeurContains("Robert");

	for (Acteur a : acts)
	{
	System.out.println(a);
	} }
	@Test
	public void testfindByNomSalaire()
	{
	List<Acteur> acts = acteurRepository.findByNomSalaire("Robert de Niro", 3000.0);
	for (Acteur a : acts)
	{
	System.out.println(a);
	}
	}
	
	@Test
	public void testfindByFilm()
	{
	Film film = new Film();
	film.setIdFilm(1L);
	List<Acteur> acts = acteurRepository.findByFilm(film);
	for (Acteur a : acts)
	{
	System.out.println(a);
	}
	}
	
	@Test
	public void findByFilmIdFilm()
	{
	List<Acteur> acts = acteurRepository.findByFilmIdFilm(1L);
	for (Acteur a : acts)
	{
	System.out.println(a);
	}
	}
	
	@Test
	public void testfindByOrderByNomActeurAsc()
	{
	List<Acteur> acts = acteurRepository.findByOrderByNomActeurAsc();
	for (Acteur a : acts)
	{
	System.out.println(a);
	}
	}
	
	@Test
	public void testTrierActeursNomsSalaire()
	{
	List<Acteur> acts = acteurRepository.trierActeursNomsSalaire();
	for (Acteur a : acts)
	{
	System.out.println(a);
	}

	}
	
	
	
	
	
	
	
	}
