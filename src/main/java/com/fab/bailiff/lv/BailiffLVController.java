package com.fab.bailiff.lv;


import com.fab.models.gr.BailiffResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BailiffLVController {

    @Autowired
    private BailiffLVService bailiffLVService;

    //@RequestMapping("/bailiffs/{country}/{lang}/update")
    @RequestMapping(value="/bailiffs/lv/en/update", method=RequestMethod.GET)
    public void updateBailiffs() {
        // update lv bailifs
        bailiffLVService.updateBailiffs();
    }


}
