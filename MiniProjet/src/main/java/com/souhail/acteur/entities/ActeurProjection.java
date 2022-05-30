package com.souhail.acteur.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomAct", types = { Acteur.class })
	public interface ActeurProjection {
		public String getNomActeur();
}
