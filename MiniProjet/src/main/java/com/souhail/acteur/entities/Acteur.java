package com.souhail.acteur.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.souhail.acteur.entities.Film;

@Entity
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idActeur;
	@NotNull
	@Size(min = 4, max = 15)
	private String nomActeur;
	
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	@Min(value = 10)
	@Max(value = 10000)
	private Double salaireActeur;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateNaissance;

	@ManyToOne
	private Film film;
	public Acteur() {
		super();
	}

	public Acteur( String nomActeur, Double salaireActeur, Date dateNaissance) {
		super();
		
		this.nomActeur = nomActeur;
		this.salaireActeur = salaireActeur;
		this.dateNaissance = dateNaissance;
	}



	public Long getIdActeur() {
		return idActeur;
	}

	public void setIdActeur(Long idActeur) {
		this.idActeur = idActeur;
	}

	public String getNomActeur() {
		return nomActeur;
	}

	public void setNomActeur(String nomActeur) {
		this.nomActeur = nomActeur;
	}

	public Double getSalaireActeur() {
		return salaireActeur;
	}

	public void setSalaireActeur(Double salaireActeur) {
		this.salaireActeur = salaireActeur;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	@Override
	public String toString() {
		return "Acteur [idActeur=" + idActeur + ", nomActeur=" + nomActeur + ", salaireActeur=" + salaireActeur
				+ ", dateNaissance=" + dateNaissance + ", film=" + film + "]";
	}
	
}
	
