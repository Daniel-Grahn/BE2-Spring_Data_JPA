package se.yrgo.rest;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import se.yrgo.domain.*;
import se.yrgo.dto.*;
import se.yrgo.repository.*;

@RestController
public class CustomerRestController {
    private CustomerRepository cr;
    private VehicleRepository vr;

    public CustomerRestController(CustomerRepository cr, VehicleRepository vr) {
        this.cr = cr;
        this.vr = vr;
    }

    // a
    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        cr.save(customer);
        return ResponseEntity.ok("Sucees created Customer");
    }

    // b
    @PostMapping("/vehicle")
    public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) {
        vr.save(vehicle);
        return ResponseEntity.ok("Sucees created Vehicle");
    }

    // c
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

    // d
    @GetMapping("/customers")
    public List<CustomerDTO> getCustomers() { // is it fine with Customer???
        List<Customer> customers = cr.getCustomersWithVehicle();
        List<CustomerDTO> customersDTO = customers.stream().map((c) -> {
            return new CustomerDTO(
                    c.getId(),
                    c.getName(),
                    c.getPhoneNumber(),
                    c.getVehicalList());
        }).toList();
        return customersDTO;
    }

    // e
    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicle() {
        List<Vehicle> vehicles = vr.findAll();
        List<VehicleDTO> vehicleDTOs = vehicles.stream()
                .map(v -> {
                    return new VehicleDTO(v.getId(), v.getRegistrationNumber(), v.getBrand(), v.getModel(),
                            v.getProductionYear());
                })
                .toList();

        return vehicleDTOs;
    }

    // f
    @GetMapping("/carsbrand")
    public List<VehicleDTO> getCarsBrand(@RequestParam String brand) {
        Optional<List<Vehicle>> vehiclesOpt = vr.getVechilesByBrand(brand);

        if (!vehiclesOpt.isPresent()) {
            return new ArrayList<VehicleDTO>();
        }

        List<VehicleDTO> vehiclesDTO = vehiclesOpt.get()
                .stream()
                .map(vehicle -> new VehicleDTO(
                        vehicle.getId(),
                        vehicle.getRegistrationNumber(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getProductionYear()))
                .toList();

        return vehiclesDTO;

    }

    // g
    @GetMapping("/CustomerId")
    public Long getCustomerId(@RequestParam String name) {
        Long id = cr.getCustomerIdByName(name);
        return id;
    }
}
