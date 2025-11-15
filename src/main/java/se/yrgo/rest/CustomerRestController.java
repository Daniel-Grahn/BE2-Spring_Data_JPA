package se.yrgo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import se.yrgo.domain.*;
import se.yrgo.dto.VehicleBrandDTO;
import se.yrgo.dto.VehicleDTO;
import se.yrgo.repository.*;

@RestController
public class CustomerRestController {
    private CustomerRepository cr;
    private VehicleRepository vr;

    public CustomerRestController(CustomerRepository cr, VehicleRepository vr) {
        this.cr = cr;
        this.vr = vr;
    }

    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        cr.save(customer);
        return ResponseEntity.ok("Sucees created Customer");
    }

    @PostMapping("/vehicle")
    public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) {
        vr.save(vehicle);
        return ResponseEntity.ok("Sucees created Vehicle");
    }

    @PostMapping("/attach")
    public ResponseEntity<String> attachVehicle(@RequestParam Long customerId, @RequestParam Long vehicleId) {
        Optional<Customer> customerOpt = cr.findById(customerId);
        Optional<Vehicle> vehicleOpt = vr.findById(vehicleId);

        if (customerOpt.isEmpty() || vehicleOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Customer or vehicle does not exist");
        }

        Customer customer = customerOpt.get();
        Vehicle vehicle = vehicleOpt.get();

        if (vehicle.getOwner() != null) {
            return ResponseEntity.badRequest().body("Vehicle already has an owner");
        }

        vehicle.setOwner(customer);
        customer.getVehicalList().add(vehicle);

        cr.save(customer);
        vr.save(vehicle);

        return ResponseEntity.ok("success");
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        Optional<List<Customer>> customers = cr.getCustomersWithVehicle();

        return customers.get();
    }

    // e?
    // @GetMapping("vehicles")
    // public List<Vehicle> getAllVehicle(){

    // }

    // f
    @GetMapping("carsbrand")
    public List<VehicleBrandDTO> getCarsBrand(@RequestParam Long customerId) {
        Optional<Customer> findCustomer = cr.findById(customerId);
        List<VehicleBrandDTO> customVehicles = new ArrayList<VehicleBrandDTO>();
        if (findCustomer.isPresent()) {
            Customer customer = findCustomer.get();
            for (Vehicle vehicle : customer.getVehicalList()) {
                VehicleBrandDTO vDTO = new VehicleBrandDTO(customerId, vehicle.getRegistrationNumber(),
                        vehicle.getBrand());
                customVehicles.add(vDTO);
            }
        }
        return customVehicles;
    }

    //g
    @GetMapping("CustomerId")
    public Long getCustomerId(@RequestParam String name) {
        Long id = cr.getCustomerIdByName(name);
        return id;
    }

    // Remove this later
    // @GetMapping("/customers")
    // public List<Customer> getCustomers() {
    // List<Customer> customers = cr.findAll();
    // return customers;
    // }

}
