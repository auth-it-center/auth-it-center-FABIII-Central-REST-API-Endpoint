package com.fab.controllers.gr;

import java.util.Optional;

import com.fab.models.gr.BailiffResponse;
import com.fab.services.gr.BailiffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BailiffController {
    
    @Autowired
    private BailiffService bailiffService;

    @GetMapping("/bailiffs")
    public BailiffResponse getBailiffs(@RequestParam Optional<String> postalCode) {
        return postalCode
            .map(pc -> bailiffService.findBailiffByPostalCode("GR","el", pc))
            .orElse(bailiffService.getAllBailiffs("GR","el"));  
    }
    
}
