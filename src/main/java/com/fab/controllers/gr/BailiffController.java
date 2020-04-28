package com.fab.controllers.gr;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import javax.validation.Valid;

import com.fab.models.gr.BailiffResponse;
import com.fab.services.gr.BailiffService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BailiffController {
    
    @Autowired
    private BailiffService bailiffService;

    @GetMapping("/bailiffs")
    public BailiffResponse all() {
     return bailiffService.getAllBailiffs("GR","el");
    }

    // @PostMapping("/bailiffs")
    // public ResponseEntity<BailiffEntity> createMember (@Valid @RequestBody BailiffEntity bailiff) {
    //     return ResponseEntity.ok(bailiffService.saveMember(bailiff));
    // }

//     @PutMapping("/bailiffs/{id}")
//     public ResponseEntity<BailiffEntity> updateBailiff(@Valid @RequestBody BailiffEntity bailiff, @PathVariable(value= "id") Long id) {
//         return ResponseEntity.ok(bailiffService.updateMember(bailiff, id));
//     }

//     @DeleteMapping("/bailiffs/{id}")
//     public ResponseEntity<?> deleteBailiff(@PathVariable Long id) {
//         Map<String,String> response = new HashMap<String,String>();
//         if(bailiffService.deleteBailiff(id)) {
//         response.put("status", "success");
//         response.put("message", "bailiff deleted successfully");
//         return ResponseEntity.ok(response);
//         } else {
//         response.put("status", "error");
//         response.put("message", "Somthing went wrong when deleting the bailiff");
//         return ResponseEntity.status(500).body(response);
//         }
//   }
}