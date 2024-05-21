package com.ligiaviana.tennisplayers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ligiaviana.tennisplayers.entities.Player;
import com.ligiaviana.tennisplayers.repositories.PlayerRepository;
import com.ligiaviana.tennisplayers.services.exceptions.DatabaseException;
import com.ligiaviana.tennisplayers.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlayerService {
	
	@Autowired 
	private PlayerRepository repository;
	
	public List<Player> findAll() {
		return repository.findAll();
	}
	
	public Player findById(Long id) {
		Optional<Player> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Player insert(Player obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Player update(Long id, Player obj) {
		try {
			Player entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Player entity, Player obj) {
		entity.setName(obj.getName());
	}
}
