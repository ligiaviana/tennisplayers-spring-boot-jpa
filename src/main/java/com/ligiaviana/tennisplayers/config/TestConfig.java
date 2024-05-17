package com.ligiaviana.tennisplayers.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ligiaviana.tennisplayers.entities.Player;
import com.ligiaviana.tennisplayers.repositories.PlayerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Player p1 = new Player(null, "Novak Djokovic");
		Player p2 = new Player(null, "Rafael Nadal");
		Player p3 = new Player(null, "Roger Federer");
		
		playerRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	} 

}
