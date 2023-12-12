package com.demo.freightvendor;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "FREIGHTVENDORDETAILS")
public class FreightVendorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FREIGHTVENDORID;
    private String PICKUPLOCATION;
    private String DESTINATIONLOCATION;
    private Integer PRICE;
    private Integer DELIVERYINDAYS;
    private String FREIGHTVENDORNAME;
    private Integer CONTACT;
}