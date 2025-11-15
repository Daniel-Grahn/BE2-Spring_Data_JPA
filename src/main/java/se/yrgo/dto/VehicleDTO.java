package se.yrgo.dto;

import se.yrgo.domain.Customer;

public record VehicleDTO(
        Long id,
        String registrationNumber,
        String brand,
        String model,
        String productionYear,
        Customer owner) {
}

// public class VehicleDTO {
// private Long id;
// private String registrationNumber;
// private String brand;
// private String model;
// private String productionYear;
// private Customer owner;

// public VehicleDTO() {
// }

// public Long getId() {
// return id;
// }

// public void setId(Long id) {
// this.id = id;
// }

// public String getRegistrationNumber() {
// return registrationNumber;
// }

// public void setRegistrationNumber(String registrationNumber) {
// this.registrationNumber = registrationNumber;
// }

// public String getBrand() {
// return brand;
// }

// public void setBrand(String brand) {
// this.brand = brand;
// }

// public String getModel() {
// return model;
// }

// public void setModel(String model) {
// this.model = model;
// }

// public String getProductionYear() {
// return productionYear;
// }

// public void setProductionYear(String productionYear) {
// this.productionYear = productionYear;
// }

// @Override
// public String toString() {
// return "Vehicle [id=" + id + ", registrationNumber=" + registrationNumber +
// ", brand=" + brand + ", model="
// + model + ", productionYear=" + productionYear + "]";
// }

// public Customer getOwner() {
// return owner;
// }

// public void setOwner(Customer owner) {
// this.owner = owner;
// }

// }
