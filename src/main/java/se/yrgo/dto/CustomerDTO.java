package se.yrgo.dto;

import java.util.*;

import se.yrgo.domain.Vehicle;

public record CustomerDTO(
        Long id,
        String name,
        String phoneNumber,
        List<Vehicle> vehicleList) {
}
