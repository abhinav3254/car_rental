package com.abhinav.car_rental.repository;

import com.abhinav.car_rental.model.VehicleCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCompanyRepository extends JpaRepository<VehicleCompany,Integer> {
}
