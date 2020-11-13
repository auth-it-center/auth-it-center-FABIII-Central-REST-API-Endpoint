package com.fab.controllers.gr;

import java.util.Optional;

import com.fab.models.BailiffResponse;
import com.fab.services.gr.BailiffGRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BailiffGRController {
    
    @Autowired
    private BailiffGRService bailiffGRService;

    @GetMapping("/bailiffs/gr")
    public BailiffResponse getBailiffs(@RequestParam Optional<String> postalCode) {
        return postalCode
            .map(pc -> bailiffGRService.findBailiffByPostalCode("GR","el", pc))
            .orElse(bailiffGRService.getAllBailiffs("GR","el"));
    }
    
}
