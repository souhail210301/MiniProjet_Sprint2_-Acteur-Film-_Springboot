package com.souhail.acteur.service;

import java.util.List;

import javax.validation.Valid;

import com.souhail.acteur.entities.Film;


public interface FilmService {

    List <Film> findAll();
    Film saveFilm(Film f);
    Film updateFilm(Film f);
    void deleteFilm(Film f);
     void deleteFilmById(Long id);
     Film getFilm (Long idFilm);
	

}