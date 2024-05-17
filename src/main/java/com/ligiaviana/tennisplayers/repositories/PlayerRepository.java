package com.ligiaviana.tennisplayers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ligiaviana.tennisplayers.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
