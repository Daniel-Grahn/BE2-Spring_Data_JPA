package se.yrgo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import se.yrgo.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    @Query("SELECT v From Vehicle as v where v.brand = :brand")
    Optional<List<Vehicle>> getVechilesByBrand(String brand);
}
