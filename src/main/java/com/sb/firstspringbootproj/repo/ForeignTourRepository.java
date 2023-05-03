package com.sb.firstspringbootproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.firstspringbootproj.entity.ForeignTour;


@Repository
public interface ForeignTourRepository extends JpaRepository<ForeignTour, Long> {

}
