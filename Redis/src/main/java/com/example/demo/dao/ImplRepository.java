package com.example.demo.dao;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Entity;

@Service
public class ImplRepository  implements Data{
    
	private static final String KEY="Entity";
	private RedisTemplate<String,Entity> redisTemplate;
	private HashOperations hashOperations;
	
	public ImplRepository(RedisTemplate<String,Entity> redisTemplate) {
		this.redisTemplate=redisTemplate;
	}
	
	@PostConstruct
	public void init() {
		hashOperations=redisTemplate.opsForHash();
	}
	
	@Override
	public Map<String, Entity> findAll() {
		// TODO Auto-generated method stub
		return hashOperations.entries(KEY);
	}

	@Override
	public Entity findById(String id) {
		// TODO Auto-generated method stub
		return (Entity) hashOperations.get(KEY, id);
	} 

	@Override
	public void save(Entity entity1) {
		hashOperations.put(KEY, UUID.randomUUID().toString() , entity1);
		
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(KEY, id);
		
	}

}
