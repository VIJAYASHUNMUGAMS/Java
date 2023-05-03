package com.sb.firstspringbootproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.firstspringbootproj.entity.LocalTour;

@Repository
public interface LocalTourRepository extends JpaRepository<LocalTour, Long> {

}
