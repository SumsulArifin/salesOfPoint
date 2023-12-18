package com.example.sysDevLtd.service;
import com.example.sysDevLtd.entity.model.userA.Essay;
import com.example.sysDevLtd.repository.EssayRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayService {

    @Autowired
    EssayRepository essayRepository;

    public MessageResponse saveEssay(Essay essay) {

        Essay essay1 = new Essay();
        essay1.setTitle(essay.getTitle());
        essay1.setColumn1(essay.getColumn1());
        essay1.setColumn2(essay.getColumn2());
        essay1.setColumn3(essay.getColumn3());
         essayRepository.save(essay1);
        return new MessageResponse(Message.SUCCESS);
    }


    public List<Essay> getAllEssay() {
        return essayRepository.findAll();
    }


    public Essay findEssayById(int eid) {
        return essayRepository.findById(eid).get();
    }

    public List<Essay> searchByTitle(String searchTerm) {
        return essayRepository.findByTitleContainingIgnoreCase(searchTerm);
    }
}
