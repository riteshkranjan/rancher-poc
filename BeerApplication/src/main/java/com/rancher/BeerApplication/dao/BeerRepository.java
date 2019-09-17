package com.rancher.BeerApplication.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rancher.BeerApplication.entity.Beer;

public interface BeerRepository extends MongoRepository<Beer, String> {

}
