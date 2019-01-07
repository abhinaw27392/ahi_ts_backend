package com.ahi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ahi.entity.AhiClients;

public interface ClientsRepository extends CrudRepository<AhiClients, Integer>{

}
