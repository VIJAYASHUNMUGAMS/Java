package com.sb.firstspringbootproj.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.firstspringbootproj.entity.Traveller;


@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Long> {

}
