package com.project.caryatch.domain.advertisement.controller;

import com.project.caryatch.domain.advertisement.Advertisement;
import com.project.caryatch.domain.advertisement.service.AdvertisementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@Tag(name = "Rest APIs for Advertisement Operations")
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService){
        this.advertisementService=advertisementService;
    }

    @Operation(summary = "Get All Advertisement Rest-API")
    @GetMapping("/gettAllAvertisement")
    public ResponseEntity<List<Advertisement>> gettAllAvertisement() {
      return ResponseEntity.ok(this.advertisementService.getAllAdvertisement());
    }
}
