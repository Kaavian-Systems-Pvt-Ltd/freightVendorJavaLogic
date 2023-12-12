package com.demo.freightvendor;

import java.util.Date;

public class FilterLocation {
    private String pickUpLocation;
    private String destinationLocation;

    private Date deliveryDate;

    private Integer Rate;

    public String getPickUpLocation () {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

}
