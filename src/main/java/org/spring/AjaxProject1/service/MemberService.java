package org.spring.AjaxProject1.service;

import org.spring.AjaxProject1.dto.MemberDTO;
import org.spring.AjaxProject1.entity.MemberEntity;
import org.spring.AjaxProject1.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private final MemberRepo memberRepo;
    public MemberService(MemberRepo memberRepo){
        this.memberRepo=memberRepo;
    }


    public int register(MemberDTO  memberDTO) {

        try {
            MemberEntity entity=MemberDTO.MemberDTOReq.toEntity(memberDTO);
            memberRepo.save(entity);
            return 1;
        } catch (Exception e){
            return 0;
        }

    }

    public List<MemberDTO> showLists() {
        List<MemberEntity> result=memberRepo.findAll();
        List<MemberDTO> dto=new ArrayList<>();

        for (MemberEntity i:result){
            dto.add(MemberDTO.MemberDTOResp.toDTO(i));
        }
        return dto;
    }

    @Transactional
    public int dupCheck(String username) {
        Optional<MemberEntity> result=memberRepo.findByUsername(username);
        if(result.isPresent()){
            return 1;
        } else {
            return 0;
        }
    }

    public MemberDTO showEachList(Long id) {
        Optional<MemberEntity> result=memberRepo.findById(id);
        if(result.isPresent()){
            return MemberDTO.MemberDTOResp.toDTO(result.get());
        } else {
            return null;
        }
    }
}
