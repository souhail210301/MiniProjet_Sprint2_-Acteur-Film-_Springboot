package com.souhail.acteur.service;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.souhail.acteur.entities.Film;
import com.souhail.acteur.repos.FilmRepository;


@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List <Film> findAll() {
        return filmRepository.findAll();
    }

	@Override
	public Film saveFilm(Film f) {
		return filmRepository.save(f);
	}

	@Override
	public Film updateFilm(Film f) {
		return filmRepository.save(f);
	}

	@Override
	public void deleteFilm(Film f) {
		filmRepository.delete(f);
	}

	@Override
	public void deleteFilmById(Long idFilm) {
		filmRepository.deleteById(idFilm);
	}

	@Override
	public Film getFilm(Long idFilm) {
		return filmRepository.findById(idFilm).get();
	}

	

   
}