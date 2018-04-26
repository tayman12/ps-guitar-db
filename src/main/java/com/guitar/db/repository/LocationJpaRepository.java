package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    List<Location> findByStateStartingWith(String stateName);

    List<Location> findByStateNotLike(String stateName);

    List<Location> findByStateOrCountry(String stateName, String countryName);

    List<Location> findByStateAndCountry(String stateName, String countryName);

    List<Location> findByStateNot(String stateName);

}
