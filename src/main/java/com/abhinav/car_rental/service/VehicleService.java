package com.abhinav.car_rental.service;


import com.abhinav.car_rental.dto.ResponseDTO;
import com.abhinav.car_rental.dto.VehicleCompanyDTO;
import com.abhinav.car_rental.dto.VehicleDTO;
import com.abhinav.car_rental.dto.VehicleTypeDTO;
import com.abhinav.car_rental.exception.CustomException;
import com.abhinav.car_rental.model.Vehicle;
import com.abhinav.car_rental.model.VehicleCompany;
import com.abhinav.car_rental.model.VehicleType;
import com.abhinav.car_rental.repository.VehicleCompanyRepository;
import com.abhinav.car_rental.repository.VehicleRepository;
import com.abhinav.car_rental.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class VehicleService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private VehicleCompanyRepository vehicleCompanyRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public Page<VehicleType> getAllVehicleType(int size, int page) {
        Pageable pageable = PageRequest.of(size,page);
        return vehicleTypeRepository.findAll(pageable);
    }

    public Page<VehicleCompany> getAllCompany(int size, int page) {
        Pageable pageable = PageRequest.of(size,page);
        return vehicleCompanyRepository.findAll(pageable);
    }

    public ResponseDTO addVehicleType(VehicleTypeDTO vehicleType) {
        VehicleType vehicle = mapToVehicleType(vehicleType);
        vehicleTypeRepository.save(vehicle);
        return new ResponseDTO("Vehicle Added");
    }

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public VehicleType mapToVehicleType(VehicleTypeDTO dto) {
        VehicleType entity = new VehicleType();
        entity.setName(dto.getName());
        entity.setPeopleCapacity(dto.getPeopleCapacity());
        entity.setLuggageCapacity(dto.getLuggageCapacity());
        entity.setDescription(dto.getDescription());
        entity.setFuelType(dto.getFuelType());
        entity.setTransmissionType(dto.getTransmissionType());
        entity.setAverageMileage(dto.getAverageMileage());
        entity.setYearOfManufacture(Integer.parseInt(dto.getYearOfManufacture().substring(0,4)));
        try {
            if (dto.getRegistrationDate() != null) {
                entity.setRegistrationDate(dateFormat.parse(dto.getRegistrationDate()));
            }
            if (dto.getLastServiceDate() != null) {
                entity.setLastServiceDate(dateFormat.parse(dto.getLastServiceDate()));
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }
        entity.setCreatedDate(new Date());
        entity.setCreatedBy("SYSTEM");
        return entity;
    }

    public ResponseDTO addVehicleCompany(VehicleCompanyDTO vehicleCompanyDTO) {
        VehicleCompany vehicleCompany = mapToVehicleCompany(vehicleCompanyDTO);
        vehicleCompanyRepository.save(vehicleCompany);
        return new ResponseDTO("Vehicle Company Added");
    }

    private VehicleCompany mapToVehicleCompany(VehicleCompanyDTO vehicleCompanyDTO) {
        VehicleCompany vehicleCompany = new VehicleCompany();
        vehicleCompany.setName(vehicleCompanyDTO.getName());
        vehicleCompany.setAddress(vehicleCompanyDTO.getAddress());
        vehicleCompany.setContactPhone(vehicleCompanyDTO.getContactPhone());
        vehicleCompany.setWebsite(vehicleCompanyDTO.getWebsite());
        try {
            byte[] image = vehicleCompanyDTO.getLogo().getBytes();
            vehicleCompany.setLogo(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vehicleCompany;
    }

    public Page<Vehicle> getAllVehicle(int size, int page) {
        Pageable pageable = PageRequest.of(size,page);
        return vehicleRepository.findAll(pageable);
    }

    public ResponseDTO addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapToVehicle(vehicleDTO);
        vehicleRepository.save(vehicle);
        return new ResponseDTO("Vehicle Added");
    }

    private Vehicle mapToVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDTO.getName());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setAvailable(vehicleDTO.getAvailable());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        vehicle.setYearOfManufacture(vehicleDTO.getYearOfManufacture());
        vehicle.setMileage(vehicleDTO.getMileage());
        vehicle.setLateFine(vehicleDTO.getLateFine());

        try {
            if (vehicleDTO.getLastServiceDate() != null) {
                vehicle.setLastServiceDate(dateFormat.parse(vehicleDTO.getLastServiceDate()));
            }
            if (vehicleDTO.getInsuranceExpiryDate() != null) {
                vehicle.setInsuranceExpiryDate(dateFormat.parse(vehicleDTO.getInsuranceExpiryDate()));
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }

        // Map type and company
        if (vehicleDTO.getType() != null) {
            VehicleType type = vehicleTypeRepository.findById(vehicleDTO.getType())
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle type not found"));
            vehicle.setType(type);
        }
        if (vehicleDTO.getCompany() != null) {
            VehicleCompany company = vehicleCompanyRepository.findById(vehicleDTO.getCompany())
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle company not found"));
            vehicle.setCompany(company);
        }

        // Map vehicle image
        try {
            if (vehicleDTO.getVehicleImage() != null) {
                byte[] image = vehicleDTO.getVehicleImage().getBytes();
                vehicle.setVehicleImage(image);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to process vehicle image", e);
        }

        return vehicle;
    }


    public ResponseDTO updateVehicle(Integer id, VehicleDTO vehicleDTO) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));

        Vehicle updatedVehicle = mapToVehicle(existingVehicle, vehicleDTO);
        vehicleRepository.save(updatedVehicle);
        return new ResponseDTO("Vehicle updated");
    }

    public ResponseDTO updateVehicleType(Integer id, VehicleTypeDTO vehicleTypeDTO) {
        VehicleType existingType = vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle type not found"));

        VehicleType updatedType = mapToVehicleType(existingType, vehicleTypeDTO);
        vehicleTypeRepository.save(updatedType);
        return new ResponseDTO("Vehicle type updated");
    }

    public ResponseDTO updateVehicleCompany(Integer id, VehicleCompanyDTO vehicleCompanyDTO) {
        VehicleCompany existingCompany = vehicleCompanyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle company not found"));

        VehicleCompany updatedCompany = mapToVehicleCompany(existingCompany, vehicleCompanyDTO);
        vehicleCompanyRepository.save(updatedCompany);
        return new ResponseDTO("Vehicle company updated");
    }


    private Vehicle mapToVehicle(Vehicle existingVehicle, VehicleDTO vehicleDTO) {
        existingVehicle.setName(vehicleDTO.getName());
        existingVehicle.setPrice(vehicleDTO.getPrice());
        existingVehicle.setAvailable(vehicleDTO.getAvailable());
        existingVehicle.setColor(vehicleDTO.getColor());
        existingVehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        existingVehicle.setYearOfManufacture(vehicleDTO.getYearOfManufacture());
        existingVehicle.setMileage(vehicleDTO.getMileage());
        existingVehicle.setLateFine(vehicleDTO.getLateFine());

        try {
            if (vehicleDTO.getLastServiceDate() != null) {
                existingVehicle.setLastServiceDate(dateFormat.parse(vehicleDTO.getLastServiceDate()));
            }
            if (vehicleDTO.getInsuranceExpiryDate() != null) {
                existingVehicle.setInsuranceExpiryDate(dateFormat.parse(vehicleDTO.getInsuranceExpiryDate()));
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }

        // Map type and company
        if (vehicleDTO.getType() != null) {
            VehicleType type = vehicleTypeRepository.findById(vehicleDTO.getType())
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle type not found"));
            existingVehicle.setType(type);
        }
        if (vehicleDTO.getCompany() != null) {
            VehicleCompany company = vehicleCompanyRepository.findById(vehicleDTO.getCompany())
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle company not found"));
            existingVehicle.setCompany(company);
        }

        // Map vehicle image
        try {
            if (vehicleDTO.getVehicleImage() != null) {
                byte[] image = vehicleDTO.getVehicleImage().getBytes();
                existingVehicle.setVehicleImage(image);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to process vehicle image", e);
        }

        return existingVehicle;
    }

    private VehicleType mapToVehicleType(VehicleType existingType, VehicleTypeDTO vehicleTypeDTO) {
        existingType.setName(vehicleTypeDTO.getName());
        existingType.setPeopleCapacity(vehicleTypeDTO.getPeopleCapacity());
        existingType.setLuggageCapacity(vehicleTypeDTO.getLuggageCapacity());
        existingType.setDescription(vehicleTypeDTO.getDescription());
        existingType.setFuelType(vehicleTypeDTO.getFuelType());
        existingType.setTransmissionType(vehicleTypeDTO.getTransmissionType());
        existingType.setAverageMileage(vehicleTypeDTO.getAverageMileage());
        existingType.setYearOfManufacture(Integer.parseInt(vehicleTypeDTO.getYearOfManufacture().substring(0,4)));
        try {
            if (vehicleTypeDTO.getRegistrationDate() != null) {
                existingType.setRegistrationDate(dateFormat.parse(vehicleTypeDTO.getRegistrationDate()));
            }
            if (vehicleTypeDTO.getLastServiceDate() != null) {
                existingType.setLastServiceDate(dateFormat.parse(vehicleTypeDTO.getLastServiceDate()));
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }
        return existingType;
    }

    private VehicleCompany mapToVehicleCompany(VehicleCompany existingCompany, VehicleCompanyDTO vehicleCompanyDTO) {
        existingCompany.setName(vehicleCompanyDTO.getName());
        existingCompany.setAddress(vehicleCompanyDTO.getAddress());
        existingCompany.setContactPhone(vehicleCompanyDTO.getContactPhone());
        existingCompany.setWebsite(vehicleCompanyDTO.getWebsite());
        try {
            byte[] image = vehicleCompanyDTO.getLogo().getBytes();
            existingCompany.setLogo(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return existingCompany;
    }

}
