package com.example.sysDevLtd.restController;
import com.example.sysDevLtd.entity.model.userA.Essay;
import com.example.sysDevLtd.entity.model.userA.EssayUpdated;
import com.example.sysDevLtd.service.EssayService;
import com.example.sysDevLtd.service.EssayUpdatedService;
import com.example.sysDevLtd.service.user.AuthenticationService;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin/")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    AuthenticationService service;

    @Autowired
    EssayService essayService;
    @Autowired
    EssayUpdatedService updatedService;

    @GetMapping("getAll")
    @ResponseBody
    public String getAllAssignDetails() {

        return "hello From Admin";
    }


    @PostMapping("essaySave")
    public ResponseEntity<MessageResponse> saveEssay(@RequestBody Essay essay) {
        MessageResponse response = essayService.saveEssay(essay);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllEssay")
    @ResponseBody
    public ResponseEntity<List<Essay>> getAllCheckList() {
        List<Essay> essayList = essayService.getAllEssay();
        return new ResponseEntity<>(essayList, HttpStatus.OK);
    }

    @PostMapping("essayUpdatedSave")
    public ResponseEntity<MessageResponse> saveEssayUpdated(@RequestBody EssayUpdated essayUpdated) {
        MessageResponse response = updatedService.saveEssayUpdate(essayUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllEssayUpdated")
    @ResponseBody
    public ResponseEntity<List<EssayUpdated>> getAllEssayUpdated() {
        List<EssayUpdated> essayList = updatedService.getAllUpdatedEssay();
        return new ResponseEntity<>(essayList, HttpStatus.OK);
    }
    @GetMapping("/getEssayUpdatedById/{eUId}")
    public ResponseEntity<EssayUpdated> getEssayUpdatedById(@PathVariable("eUId") int eUId) {
        EssayUpdated essay = updatedService.findEssayById(eUId);
        return new ResponseEntity<>(essay, HttpStatus.OK);
    }
    // API to retrieve CheckList by id
    @GetMapping("/getEssayById/{eid}")
    public ResponseEntity<Essay> getEssayById(@PathVariable("eid") int eid) {
        Essay essay = essayService.findEssayById(eid);
        return new ResponseEntity<>(essay, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Essay> searchEssaysByTitle(@RequestParam String searchTerm) {
        return essayService.searchByTitle(searchTerm);
    }
//
//    http://localhost:8080/api/admin/search?searchTerm=cat

}
