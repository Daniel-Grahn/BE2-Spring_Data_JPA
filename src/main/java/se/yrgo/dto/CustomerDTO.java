package se.yrgo.dto;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import se.yrgo.domain.Vehicle;

public record CustomerDTO(
        Long id,
        String name,
        String phoneNumber,
        List<Vehicle> vehicalList) {

}
