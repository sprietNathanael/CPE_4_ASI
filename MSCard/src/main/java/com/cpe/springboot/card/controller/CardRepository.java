package com.cpe.springboot.card.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cpe.springboot.card.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

	@Query("SELECT c FROM Card c WHERE c.iduser = :id")
	List<Card> cardsuser(@Param("id") Integer id);
	
	/*public List<Card> findByColor(String color);*/

}
