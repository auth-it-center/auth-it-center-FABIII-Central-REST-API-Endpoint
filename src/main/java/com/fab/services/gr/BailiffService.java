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

    @Autowired
    private BailiffRepository bailiffRepository;
    
    // public BailiffEntity findBailiffByPostalCode(String postalCode) {
    //     return memberRepository.findByPostalCode(postalCode);
    // }
    
    public BailiffResponse getAllBailiffs(String country, String lang) {
        List<BailiffEntity> bailiffs = bailiffRepository.findAll();
        return new BailiffResponse(bailiffs, country, lang);
    }

    // public BailiffEntity saveMember(BailiffEntity bailiff) {
    //     return bailiffRepository.save(bailiff);
    // }

    // public BailiffEntity updateMember(BailiffEntity bailiff, Long id) {
    //     BailiffEntity updateBailiff = bailiffRepository.findById(id).orElse(null);
    //     if(updateBailiff != null) {
    //         updateBailiff.setName(bailiff.getName());
    //      }
    //     final BailiffEntity myBailiff = bailiffRepository.save(updateBailiff);
    //     return myBailiff;
    //   }

    //   public Boolean deleteBailiff (Long id) {
    //     BailiffEntity delBailiff  = bailiffRepository.findById(id).orElse(null);
    //     if(delBailiff != null) {
    //         bailiffRepository.delete(delBailiff);
    //         return true;
    //     }
    //     return false;
    //  }
}