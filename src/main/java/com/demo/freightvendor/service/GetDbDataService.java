package com.demo.freightvendor.service;

import com.demo.freightvendor.FilterLocation;
import com.demo.freightvendor.FreightVendorDetails;
import com.demo.freightvendor.dao.FreightVendorDetailsDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetDbDataService {

    @Autowired
    FreightVendorDetailsDao freightVendorDetailsDao ;

    public List<FreightVendorDetails> getDbData() {
        return freightVendorDetailsDao.findAll();
    }


    public String createDbData(FreightVendorDetails freightVendorDetails) {
        freightVendorDetailsDao.save(freightVendorDetails);
        return ("Freight Vendor Details Added Successfully");
    }

    public String updateDbData(Integer freightVendorId, FreightVendorDetails freightVendorDetails) {
        Optional<FreightVendorDetails> existingDetails = freightVendorDetailsDao.findById(freightVendorId);

        if (existingDetails.isPresent()) {
            FreightVendorDetails currentDetails = existingDetails.get();

            // Update the fields that you want to modify
            currentDetails.setPICKUPLOCATION(freightVendorDetails.getPICKUPLOCATION());
            currentDetails.setDESTINATIONLOCATION(freightVendorDetails.getDESTINATIONLOCATION());
            currentDetails.setPRICE(freightVendorDetails.getPRICE());
            currentDetails.setDELIVERYINDAYS(freightVendorDetails.getDELIVERYINDAYS());
            currentDetails.setFREIGHTVENDORNAME(freightVendorDetails.getFREIGHTVENDORNAME());
            currentDetails.setCONTACT(freightVendorDetails.getCONTACT());

            freightVendorDetailsDao.save(currentDetails);
            return "Freight Vendor Details Updated Successfully";
        } else {
            throw new EntityNotFoundException("Freight Vendor Details not found with id: " + freightVendorId);
        }
    }

    public String deleteDbData(Integer freightVendorId) {
        freightVendorDetailsDao.deleteById(freightVendorId);
        return "Freight Vendor Details Deleted Successfully";
    }

    public Object findMatchingEntries(FilterLocation filterLocation) {
        String pickUpLocation = filterLocation.getPickUpLocation();
        String destination = filterLocation.getDestinationLocation();

        List<FreightVendorDetails> results = freightVendorDetailsDao.findByPICKUPLOCATIONAndDESTINATIONLOCATION(pickUpLocation, destination);

        if (results.isEmpty()) {
            return ("Freight Vendors not found for the given location"); // or handle the case where no results are found
        } else if (results.size() == 1) {
            return results.get(0); // Return the single result
        } else {
            // If there are multiple results, find the one with the least delivery in days
            FreightVendorDetails minDeliveryDaysResult = results.get(0);

            for (FreightVendorDetails result : results) {
                if (result.getDELIVERYINDAYS() < minDeliveryDaysResult.getDELIVERYINDAYS()) {
                    minDeliveryDaysResult = result;
                } else if (result.getDELIVERYINDAYS().equals(minDeliveryDaysResult.getDELIVERYINDAYS())) {
                    // If delivery days are the same, compare by price
                    if (result.getPRICE() < minDeliveryDaysResult.getPRICE()) {
                        minDeliveryDaysResult = result;
                    }
                }
            }

            System.out.println("Selected result: " + minDeliveryDaysResult);
            return minDeliveryDaysResult;
        }
    }
}
