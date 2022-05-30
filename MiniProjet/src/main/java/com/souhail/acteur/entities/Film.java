package com.souhail.acteur.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Film {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;
	private String nomFilm;
	private String descriptionFilm;
	@JsonIgnore
@OneToMany(mappedBy = "film")
	private List<Acteur> acteurs;
	public Film() {}
public Film(String nomFilm, String descriptionFilm, List<Acteur> acteurs)
{

	super();
	this.nomFilm = nomFilm;
	this.descriptionFilm = descriptionFilm;
	this.acteurs = acteurs;
}
public Long getIdFilm() {
	return idFilm;
}
public void setIdFilm(Long idFilm) {
	this.idFilm = idFilm;
}
public String getNomFilm() {
	return nomFilm;
}
public void setNomFilm(String nomFilm) {
	this.nomFilm = nomFilm;
}
public String getDescriptionFilm() {
	return descriptionFilm;
}
public void setDescriptionFilm(String descriptionFilm) {
	this.descriptionFilm = descriptionFilm;
}
public List<Acteur> getActeurs() {
	return acteurs;
}
public void setActeurs(List<Acteur> acteurs) {
	this.acteurs = acteurs;
}
}
