package com.cpe.springboot.card.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpe.springboot.card.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {
	
	/*public List<Card> findByColor(String color);*/

}
