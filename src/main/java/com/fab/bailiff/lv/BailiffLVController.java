package com.fab.bailiff.lv;


import com.fab.models.gr.BailiffResponse;
import com.fab.services.gr.BailiffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BailiffLVController {

    @Autowired
    private BailiffLVService bailiffLVService;

    @Autowired
    private BailiffService bailiffService;


    // e.g. http:localhost:4000/api/v1/bailiffs/lv/en?postalcode=

    @GetMapping("/bailiffs/{country}/{lang}")
    public ResponseEntity getBailiffs(@PathVariable("country") String country, @PathVariable("lang") String lang,
                                       @RequestParam(name = "postalcode") Optional<String> postalCode) {


        switch (country) {

            case BailiffLVService.LVCountry:
                // return lv bailiffs
                return ResponseEntity.status(HttpStatus.OK).
                        body(bailiffLVService.updateBailiffs());
                break;
            case BailiffService.GRCountry:
                // return gr bailiffs
                return ResponseEntity.status(HttpStatus.OK).
                        body(
                                postalCode.map(pc ->
                                        bailiffService.
                                                findBailiffByPostalCode("GR", "el", pc)).
                                                orElse(bailiffService.getAllBailiffs("GR", "el"))
                        );
                break;

        }

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Please specify 'country' and 'language' path variables.");

    }

}
