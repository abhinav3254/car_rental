package com.abhinav.car_rental.repository;

import com.abhinav.car_rental.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType,Integer> {
}
