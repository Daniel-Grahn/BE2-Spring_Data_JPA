package se.yrgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import se.yrgo.domain.*;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Vehicle> getVechilesById(Long id);

    @Query("SELECT DISTINCT c " +
             "FROM Customer c "+ 
            "INNER JOIN c.vehicleList v")
    List<Customer> getCustomersWithVehicle();

    @Query(value = "SELECT c.id From Customer as c where c.name = :name", nativeQuery = true)
    Long getCustomerIdByName(String name);
}
