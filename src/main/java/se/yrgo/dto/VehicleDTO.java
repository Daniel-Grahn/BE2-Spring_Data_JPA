package se.yrgo.dto;


public record VehicleDTO(
        Long id,
        String registrationNumber,
        String brand,
        String model,
        String productionYear) {
}