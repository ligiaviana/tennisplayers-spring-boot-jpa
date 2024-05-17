package com.ligiaviana.tennisplayers.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ligiaviana.tennisplayers.entities.Player;

@RestController
@RequestMapping(value ="/players")
public class PlayerResource {
	
	@GetMapping
	public ResponseEntity<Player> findAll(){
		Player p = new Player(1L, "Novak Djokovic");
		return ResponseEntity.ok().body(p);
	}

}
