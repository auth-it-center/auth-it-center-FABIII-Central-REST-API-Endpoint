package com.fab.controllers.pt;

import com.fab.entities.RequestFormat;
import com.fab.models.Bailiff;
import com.fab.models.BailiffResponse;
import com.fab.services.pt.BailiffPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BailiffPTController {

    @Autowired
    private BailiffPTService bailiffPTService;

    // e.g. http:localhost:4000/api/v1/bailiffs/lv?postalCode=...


    @GetMapping("/bailiffs/pt/getall")
    public ResponseEntity getBailiffs() {

        return ResponseEntity.status(HttpStatus.OK).
                body(
                        new BailiffResponse(bailiffPTService.getAllBailiffs(), "PT", "pt")
                        // TODO use static variables
                );
    }


    @PostMapping("/bailiffs/pt")
    public ResponseEntity getFilteredBailiffs(@RequestBody RequestFormat requestBody) {

        String postalCode = requestBody.getPostalCode();

        return ResponseEntity.status(HttpStatus.OK).
                body(
                        new BailiffResponse(bailiffPTService.getFilteredBailiffs(postalCode), "PT", "pt")
                        // TODO use static variables
                );


    }

}