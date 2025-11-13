package se.yrgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se.yrgo.domain.Vehicle;

public interface CustomerRepository extends JpaRepository<Vehicle, Long>{
    public List<Vehicle> getVechilesById(Long id);
}
