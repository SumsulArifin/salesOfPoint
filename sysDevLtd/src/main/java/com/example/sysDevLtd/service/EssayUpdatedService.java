package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.userA.EssayUpdated;
import com.example.sysDevLtd.repository.EssayUpdatedRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayUpdatedService {
    @Autowired
    EssayUpdatedRepository essayUpdatedRepository;

    public MessageResponse saveEssayUpdate(EssayUpdated essayUpdated) {

        EssayUpdated updated = new EssayUpdated();
        updated.setEId(essayUpdated.getEId());
        updated.setTitle(essayUpdated.getTitle());
        updated.setColumn1(essayUpdated.getColumn1());
        updated.setColumn2(essayUpdated.getColumn2());
        updated.setColumn3(essayUpdated.getColumn3());
        updated.setCreatedAt(essayUpdated.getCreatedAt());
        essayUpdatedRepository.save(updated);
        return new MessageResponse(Message.SUCCESS);
    }


    public List<EssayUpdated> getAllUpdatedEssay() {
        return essayUpdatedRepository.findAll();
    }


    public EssayUpdated findEssayById(int eUId) {
        return essayUpdatedRepository.findById(eUId).get();
    }
}
