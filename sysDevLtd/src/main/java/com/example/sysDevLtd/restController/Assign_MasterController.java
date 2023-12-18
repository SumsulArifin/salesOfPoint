package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.userA.Assign_Master;
import com.example.sysDevLtd.entity.model.salesOfPoint.Department;
import com.example.sysDevLtd.service.Assign_MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/a_m")
@CrossOrigin(originPatterns = {"*"})
public class Assign_MasterController {
    @Autowired
    Assign_MasterServiceImpl assignMasterService;

    @PostMapping("/a_m_save")
    public ResponseEntity<Assign_Master> saveA_M(@RequestBody Assign_Master assign_master) {
        Assign_Master response = assignMasterService.saveAssign_Master(assign_master);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllA_M")
    @ResponseBody
    public ResponseEntity<List<Assign_Master>> getAllAssign_Master() {
        List<Assign_Master> assign_masters = assignMasterService.getAllAssign_Master();
        return new ResponseEntity<>(assign_masters, HttpStatus.OK);
    }

    @GetMapping("/getDepBy/{a_M_Id}")
    public ResponseEntity<Department> getDivisionById(@PathVariable("a_M_Id") Integer a_M_Id) {
        Department department = assignMasterService.findDepByA_M_Id(a_M_Id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

}
