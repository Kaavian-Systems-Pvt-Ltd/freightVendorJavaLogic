package com.demo.freightvendor.controller;

import com.demo.freightvendor.FilterLocation;
import com.demo.freightvendor.FreightVendorDetails;
import com.demo.freightvendor.service.GetDbDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api")
public class dbcontroller {

    @Autowired
    GetDbDataService getDbDataService;

    @GetMapping("helloWorld")
    public String main () {
        System.out.println("hellooo");
        return "hello";
    }

    @GetMapping("getDBData")
    public List<FreightVendorDetails> getDbData () {
        return getDbDataService.getDbData();
    }


    @PostMapping("createData")
    public String createData (@RequestBody FreightVendorDetails freightVendorDetails) {
        System.out.println(freightVendorDetails);
        return getDbDataService.createDbData(freightVendorDetails);
    }

//    @PostMapping("updateData/{freightVendorId}")
//    public String updateData (@PathVariable Integer freightVendorId, @RequestBody FreightVendorDetails freightVendorDetails) {
//        System.out.println(freightVendorId);
//        System.out.println(freightVendorDetails);
//        return getDbDataService.updateDbData(freightVendorId, freightVendorDetails);
//    }

    @PostMapping("updateFreightVendorData")
    public String updateData(@RequestParam Integer freightVendorId, @RequestBody FreightVendorDetails freightVendorDetails ) {

        return getDbDataService.updateDbData(freightVendorId, freightVendorDetails);
    }
    @DeleteMapping("deleteFreightVendorData")
    public String deleteData(@RequestParam ("freightVendorId") Integer freightVendorId ){
        return getDbDataService.deleteDbData(freightVendorId);
    }


    @PostMapping("findMatchingEntries")
    public Object findMatchingEntries (@RequestBody FilterLocation filterLocation) {
        System.out.println(filterLocation);
        System.out.println("Pickup Location: " + filterLocation.getPickUpLocation());
        System.out.println("Destination: " + filterLocation.getDestinationLocation());
        return getDbDataService.findMatchingEntries(filterLocation);
    }

//    @PostMapping("lol")
//    public ResponseEntity<String> bhoopeshUpdateMethod (@RequestBody Object data) {
//
//        System.out.println(data);
//
//        return ResponseEntity.ok(getDbDataService.bhoopeshUpdateMethod(data));
//    }
}