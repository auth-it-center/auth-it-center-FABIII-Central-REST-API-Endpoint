package com.fab.services.gr;

import java.util.List;

import com.fab.models.gr.BailiffEntity;
// import com.fab.models.gr.BailiffEntity;
import com.fab.models.gr.BailiffResponse;
import com.fab.repositories.gr.BailiffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bailiffService")
public class BailiffService {

    public static final String GRCountry = "GR";

    @Autowired
    private BailiffRepository bailiffRepository;
    
    public BailiffResponse findBailiffByPostalCode(String country, String lang, String postalCode) {
        List<BailiffEntity> bailiffs = bailiffRepository.findByPostalCode(postalCode);
        return new BailiffResponse(bailiffs, country, lang);
    }

    public BailiffResponse getAllBailiffs(String country, String lang) {
        List<BailiffEntity> bailiffs = bailiffRepository.findAll();
        return new BailiffResponse(bailiffs, country, lang);
    }

}
