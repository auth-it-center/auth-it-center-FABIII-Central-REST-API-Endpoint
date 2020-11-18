package com.fab.controllers.lv;

import com.fab.entities.RequestFormat;
import com.fab.models.Bailiff;
import com.fab.services.lv.BailiffLVService;
import com.fab.models.BailiffResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BailiffLVController {

    @Autowired
    private BailiffLVService bailiffLVService;

    // e.g. http:localhost:4000/api/v1/bailiffs/lv?postalCode=...


    @GetMapping("/bailiffs/lv/getall")
    public ResponseEntity getBailiffs() {

        return ResponseEntity.status(HttpStatus.OK).
                body(
                        new BailiffResponse(bailiffLVService.getAllBailiffs(), "LV", "lv")
                        // TODO use static variables
                );
    }


    @PostMapping("/bailiffs/lv")
    public ResponseEntity getFilteredBailiffs(@RequestBody RequestFormat requestBody) {

        String postalCode = requestBody.getPostalCode();

        return ResponseEntity.status(HttpStatus.OK).
                body(
                        new BailiffResponse(bailiffLVService.getFilteredBailiffs(postalCode), "LV", "lv")
                        // TODO use static variables
                );


    }

}