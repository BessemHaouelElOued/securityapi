package com.lcs.repo;

import org.springframework.data.repository.CrudRepository;

import com.lcs.entities.LcsUser;

public interface LcsUserRepo extends CrudRepository<LcsUser, Integer> {

	LcsUser findByUsername(String username);

}
