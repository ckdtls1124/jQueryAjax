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

    public MemberDTO showLists() {
        List<MemberEntity> result;
        MemberDTO memberDTO=new MemberDTO();

        result=memberRepo.findAll();
        for(MemberEntity i:result){
            memberDTO.setId(i.getId());
            memberDTO.setUsername(i.getUsername());
            memberDTO.setUserpw(i.getUserpw());
        }
        return memberDTO;
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
}
