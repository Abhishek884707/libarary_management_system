package com.mindtree.library_management_system.utilities;

import com.mindtree.library_management_system.dto.AddressDto;
import com.mindtree.library_management_system.model.Address;
import com.mindtree.library_management_system.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;


public class AddressUtility {

    @Autowired
    AddressService addressService;

    public static Address fromAddressDtoToAddress(AddressDto addressDto){

        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCountry(addressDto.getCountry());
        address.setAddressType(addressDto.getAddressType());
        address.setZipcode(addressDto.getZipcode());
        address.setStreetAddress(addressDto.getStreetAddress());
        address.setStudent(addressDto.getStudent());
        return address;
    }

    public static AddressDto fromAddressToAddressDto(Address address){

        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setCountry(address.getCountry());
        addressDto.setAddressType(address.getAddressType());
        addressDto.setZipcode(address.getZipcode());
        addressDto.setStreetAddress(address.getStreetAddress());
        addressDto.setStudent(address.getStudent());
        return addressDto;
    }

}
