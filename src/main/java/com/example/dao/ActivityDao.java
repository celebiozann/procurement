package com.example.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.entity.Activity;

public interface ActivityDao extends CrudRepository<Activity, Long> {
	
}
