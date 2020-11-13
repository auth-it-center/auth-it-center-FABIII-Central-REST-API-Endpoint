package com.fab.services.gr;

import java.util.ArrayList;
import java.util.List;

import com.fab.entities.gr.BailiffGREntity;
import com.fab.models.Bailiff;
import com.fab.models.BailiffResponse;
import com.fab.repositories.gr.BailiffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bailiffGRService")
public class BailiffGRService {

    public static final String GRCountry = "GR";

    @Autowired
    private BailiffRepository bailiffRepository;
    
    public BailiffResponse findBailiffByPostalCode(String country, String lang, String postalCode) {
        List<BailiffGREntity> bailiffEntities = bailiffRepository.findByPostalCode(postalCode);

        List<Bailiff> bailiffs = new ArrayList<>();
        bailiffEntities.forEach(b -> bailiffs.add((Bailiff)b));

        return new BailiffResponse(bailiffs, country, lang);
    }

    public BailiffResponse getAllBailiffs(String country, String lang) {
        List<BailiffGREntity> bailiffEntities = bailiffRepository.findAll();

        List<Bailiff> bailiffs = new ArrayList<>();
        bailiffEntities.forEach(b -> bailiffs.add((Bailiff)b));

        return new BailiffResponse(bailiffs, country, lang);
    }

}
