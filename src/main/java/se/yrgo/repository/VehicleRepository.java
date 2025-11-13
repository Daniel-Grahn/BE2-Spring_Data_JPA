package se.yrgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import se.yrgo.domain.Customer;
import se.yrgo.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    @Query("SELECT DISTINCT v.owner FROM Vehicle v")
    List<Customer> getCustomersWithVehicle();
}
