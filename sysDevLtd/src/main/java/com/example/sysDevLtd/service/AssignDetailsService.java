package com.example.sysDevLtd.service;
import com.example.sysDevLtd.entity.model.userA.AssignDetails;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public interface AssignDetailsService {
    public MessageResponse saveAssignDetails(AssignDetails assignDetails);
    public List<AssignDetails> getAllAssignDetails();
    public AssignDetails findAssignDetailsById(int a_M_Id);
    public void deleteAssignDetailsById(int a_M_Id);
    public AssignDetails findCheByA_M_Id(int a_M_Id);
    public List<AssignDetails> getCheckListsByAMId(int a_M_Id);

}
