package com.ligiaviana.tennisplayers.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ligiaviana.tennisplayers.entities.Player;
import com.ligiaviana.tennisplayers.entities.Racket;
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
		
		Racket r1 = new Racket(null, "Head PT113B", "Cordas: Babolat VS Touch 17 e a ALU Power 16L", p1);
		Racket r2 = new Racket(null, "Babolat AeroPro Drive", "Cordas: Babolat RPM blast 1.35", p2);
		Racket r3 = new Racket(null, "Wilson Pro Staff RF97", "Cordas: Wilson Natural Gut e Luxilon Alu Power Rough", p3);
		
		p1.setRacket(r1);
		p2.setRacket(r2);
		p3.setRacket(r3);
		
		playerRepository.saveAll(Arrays.asList(p1, p2, p3));
	} 

}
