package com.cpe.springboot.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cpe.springboot.game.model.Room;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String roomName;
	private Integer bet;
	private Integer creatorId;
	private Integer player1;
	private Integer player2;
	/*
	 * 1: created
	 * 2: in progress
	 * 3: finished
	 */
	@Column(name="state")
	private Integer state = 0;
	
	public Room() {	}

	public Room(String name, int bet, int creatorId) {
		this.setRoomName(name);
		this.setBet(bet);
		this.setCreatorId(creatorId);
		this.setState(0);
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getBet() {
		return bet;
	}

	public void setBet(Integer bet) {
		this.bet = bet;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getPlayer1() {
		return player1;
	}

	public void setPlayer1(Integer player1) {
		this.player1 = player1;
	}

	public Integer getPlayer2() {
		return player2;
	}

	public void setPlayer2(Integer player2) {
		this.player2 = player2;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
