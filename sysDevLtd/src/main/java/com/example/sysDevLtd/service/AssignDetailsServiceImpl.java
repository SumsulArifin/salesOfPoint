package com.example.sysDevLtd.service;
import com.example.sysDevLtd.entity.model.userA.AssignDetails;
import com.example.sysDevLtd.repository.AssignDetailsRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssignDetailsServiceImpl  implements AssignDetailsService{
    @Autowired
    AssignDetailsRepository assignMasterRepo;
    @Override
    public MessageResponse saveAssignDetails(AssignDetails assignDetails) {
        AssignDetails assignDetails1 = new AssignDetails();
        assignDetails1.setAssign_master(assignDetails.getAssign_master());
        assignDetails1.setCheckLists(assignDetails.getCheckLists());
        assignMasterRepo.save(assignDetails1);
        return new MessageResponse(Message.SUCCESS);
    }

    @Override
    public List<AssignDetails> getAllAssignDetails() {
        return assignMasterRepo.findAll();
    }

    @Override
    public AssignDetails findAssignDetailsById(int a_M_Id) {
        return null;
    }

    @Override
    public void deleteAssignDetailsById(int a_M_Id) {
    }
    @Override
    public AssignDetails findCheByA_M_Id(int a_M_Id) {
        return null;
    }
    @Override
    public List<AssignDetails> getCheckListsByAMId(int a_M_Id) {
        return assignMasterRepo.findByAssign_master(a_M_Id);
    }



}
