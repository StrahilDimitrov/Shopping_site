package com.example.shopping.service;

import com.example.shopping.model.dto.AddressFormDto;
import com.example.shopping.model.entity.AddressEntity;
import com.example.shopping.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public void addAddress(AddressFormDto addressDto){
        AddressEntity address = modelMapper.map(addressDto, AddressEntity.class);
        this.addressRepository.save(address);
    }
}
