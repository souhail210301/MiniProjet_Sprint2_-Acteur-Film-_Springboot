package com.souhail.acteur.repos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souhail.acteur.entities.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{



}