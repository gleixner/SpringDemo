package com.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.MovieEntity;

@Repository
public class MovieDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Long saveMovie(MovieEntity movie) {
		if(movie.getId() == null) {
			em.persist(movie);
		} else {
			em.merge(movie);
		}
		return movie.getId();
	}
	
	@Transactional
	public MovieEntity getMovie(Long id) {
		return em.find(MovieEntity.class, id);
	}

}
