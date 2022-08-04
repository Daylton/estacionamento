package com.daylton.estacionamento.service;

import com.daylton.estacionamento.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = gedUUID();
        Parking parking = new Parking(id, "FGH-5678", "SC", "MONTANA", "BRANCO");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String gedUUID() {

        return UUID.randomUUID().toString().replace("-","");

    }

}
