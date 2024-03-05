package com.project.caryatch.domain.advertisement.service;

import com.project.caryatch.domain.advertisement.Advertisement;
import com.project.caryatch.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;


    public List<Advertisement> getAllAdvertisement(){
        List<Advertisement> advertisements=advertisementRepository.findAll();

        return advertisements;
    }

}
