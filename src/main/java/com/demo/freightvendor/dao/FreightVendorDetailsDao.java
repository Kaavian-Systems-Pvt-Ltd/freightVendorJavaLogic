package com.demo.freightvendor.dao;

import com.demo.freightvendor.FreightVendorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FreightVendorDetailsDao  extends JpaRepository<FreightVendorDetails, Integer> {
    List<FreightVendorDetails> findByPICKUPLOCATIONAndDESTINATIONLOCATION(
            String pickUpLocation, String destinationLocation);
    void deleteById(Integer freightVendorId);

}
