package com.fab.controllers.nl;

import com.fab.entities.RequestFormat;
import com.fab.models.Bailiff;
import com.fab.services.nl.BailiffNLService;
import com.fab.models.BailiffResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BailiffNLController {

    @Autowired
    private BailiffNLService bailiffNLService;

    // e.g. http:localhost:4000/api/v1/bailiffs/nl?postalCode=...


    @GetMapping("/bailiffs/nl/getall")
    public ResponseEntity getBailiffs() {

        return ResponseEntity.status(HttpStatus.OK).
                body(
                        new BailiffResponse(bailiffNLService.getAllBailiffs(), "NL", "nl")
                        // TODO use static variables
                );
    }


    @PostMapping("/bailiffs/nl")
    public ResponseEntity getFilteredBailiffs(@RequestBody RequestFormat requestBody) {

        String postalCode = requestBody.getPostalCode();

        return ResponseEntity.status(HttpStatus.OK).
                body(
                        new BailiffResponse(bailiffNLService.getFilteredBailiffs(postalCode), "NL", "nl")
                        // TODO use static variables
                );


    }

}