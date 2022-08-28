package com.mindtree.library_management_system.controller;

import com.mindtree.library_management_system.dto.AddressDto;
import com.mindtree.library_management_system.model.Address;
import com.mindtree.library_management_system.service.AddressService;
import com.mindtree.library_management_system.utilities.AddressUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class AddressController {

    @Autowired
    AddressService addressService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/address/{addressId}")
    public AddressDto getAddressById(@PathVariable("addressId") int id){
        log.info("{}",id);
        AddressDto addressDto = AddressUtility.fromAddressToAddressDto(addressService.getAddressById(id).get());
        return addressDto;
    }

    @PostMapping("/address")
    public AddressDto createNewAddress(@RequestBody AddressDto addressDto){
        log.info("{}", addressDto);
        Address address = AddressUtility.fromAddressDtoToAddress(addressDto);
        addressDto = AddressUtility.fromAddressToAddressDto(addressService.addNewAddress(address));
        return addressDto;
    }

    @PutMapping("/address")
    public AddressDto editAddress(@RequestBody AddressDto addressDto){
        log.info("{}", addressDto);
        Address address = AddressUtility.fromAddressDtoToAddress(addressDto);
        addressDto = AddressUtility.fromAddressToAddressDto(addressService.updateAddress(address));
        return addressDto;
    }

    @DeleteMapping("/address")
    public boolean removeAddress(@RequestBody AddressDto addressDto){
        log.info("{}", addressDto);
        Address address = AddressUtility.fromAddressDtoToAddress(addressDto);
        return addressService.deleteAddress(address);
    }

}
