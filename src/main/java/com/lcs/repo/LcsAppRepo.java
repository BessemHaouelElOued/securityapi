package com.lcs.repo;

import org.springframework.data.repository.CrudRepository;

import com.lcs.entities.Lcsapp;

public interface LcsAppRepo extends CrudRepository<Lcsapp, Integer> {

}
