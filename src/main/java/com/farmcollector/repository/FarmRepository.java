package com.farmcollector.repository;

import org.springframework.data.repository.Repository;

import com.farmcollector.model.Farm;

@SuppressWarnings("rawtypes")
public interface FarmRepository extends Repository {

    Farm findByName(String farmName);

    void save(Farm farm);

}
