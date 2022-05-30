package com.souhail.acteur.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.souhail.acteur.entities.Film;
import com.souhail.acteur.entities.Acteur;
import com.souhail.acteur.service.FilmService;
import com.souhail.acteur.service.ActeurService;

@Controller
public class ActeurController {
	@Autowired
	ActeurService acteurService;
	@Autowired
	FilmService filmService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Film> films = filmService.findAll();
		modelMap.addAttribute("films", films);
		modelMap.addAttribute("acteur", new Acteur());
		modelMap.addAttribute("mode", "new");
		return "formActeur";
	}

	
	@RequestMapping("/searchNomFilm")
	public String searchPersonne(ModelMap modelMap, @Valid String nomFilm) {
		List<Acteur> acteurs = acteurService.findActeurByNomFilm(nomFilm);

		modelMap.addAttribute("acteurs", acteurs);

		return "/rechercheFilm";
	}
	
	@RequestMapping("/saveActeur")
	public String saveActeur(ModelMap modelMap, @Valid Acteur acteur, BindingResult bindingResult) {
		List<Film> films = filmService.findAll();
		modelMap.addAttribute("films", films);
		System.out.println(acteur);
		if (bindingResult.hasErrors())
			return "formActeur";
		acteurService.saveActeur(acteur);
		return "redirect:/ListeActeurs";
	}

	@RequestMapping("/showCreateFilm")
	public String showCreateFilm(ModelMap modelMap) {
		modelMap.addAttribute("films", new Film());
		modelMap.addAttribute("mode", "new");
		return "formFilm";
	}

	@RequestMapping("/saveFilm")
	public String saveFilm(@ModelAttribute("film") Film film, ModelMap modelMap)
			throws ParseException {
		Film saveFilm = filmService.saveFilm(film);
		return "redirect:/ListeFilm";
	}

	@RequestMapping("/ListeFilm")
	public String listeActeurs(ModelMap modelMap) {
		List<Film> films = filmService.findAll();
		modelMap.addAttribute("films", films);
		return "ListeFilm";
	}

	@RequestMapping("/ListeActeurs")
	public String listeActeurs(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Acteur> acts = acteurService.getAllActeursParPage(page, size);
		modelMap.addAttribute("acteurs", acts);
		modelMap.addAttribute("pages", new int[acts.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeActeurs";
	}

	@RequestMapping("/supprimerActeur")
	public String supprimerActeur(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		acteurService.deleteActeurById(id);
		Page<Acteur> acts = acteurService.getAllActeursParPage(page, size);
		modelMap.addAttribute("acteurs", acts);
		modelMap.addAttribute("pages", new int[acts.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeActeurs";
	}

	@RequestMapping("/supprimerFilm")
	public String supprimerFilm(@RequestParam("id") Long id, ModelMap modelMap) {
		filmService.deleteFilmById(id);
		List<Film> films = filmService.findAll();
		modelMap.addAttribute("films", films);
		return "ListeFilm";
	}

	@RequestMapping("/modifierActeur")
	public String editerActeur(@RequestParam("id") Long id, ModelMap modelMap) {
		Acteur a = acteurService.getActeur(id);
		List<Film> films = filmService.findAll();
		films.remove(a.getFilm());
		modelMap.addAttribute("films", films);
		modelMap.addAttribute("acteur", a);
		modelMap.addAttribute("mode", "edit");
		return "formActeur";
	}

	@RequestMapping("/updateActeur")
	public String updateActeur(@ModelAttribute("acteur") Acteur acteur, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaissance = dateformat.parse(String.valueOf(date));
		acteur.setDateNaissance(dateNaissance);

		acteurService.updateActeur(acteur);
		List<Acteur> acts = acteurService.getAllActeurs();
		modelMap.addAttribute("acteurs", acts);
		return "listeActeurs";
	}

	@RequestMapping("/modifierFilm")
	public String editerFilm(@RequestParam("id") Long id, ModelMap modelMap) {
		Film f = filmService.getFilm(id);
		modelMap.addAttribute("films", f);
		modelMap.addAttribute("mode", "edit");
		return "formFilm";
	}

	@RequestMapping("/updateFilm")
	public String updateFilm(@ModelAttribute("film") Film film, ModelMap modelMap)
			throws ParseException {
		filmService.updateFilm(film);
		List<Film> films = filmService.findAll();
		modelMap.addAttribute("films", films);
		return "ListeFilm";
	}
}