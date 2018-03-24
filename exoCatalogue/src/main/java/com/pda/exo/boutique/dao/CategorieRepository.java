package com.pda.exo.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pda.exo.boutique.entities.Categorie;

@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
