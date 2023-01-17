package org.spring.AjaxProject1.dto;

import lombok.*;
import org.spring.AjaxProject1.entity.MemberEntity;

import javax.persistence.*;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
public class MemberDTO {

        private Long id;
        private String username;
        private String userpw;

        public static class MemberDTOReq{

            public static MemberEntity toEntity(MemberDTO dto){
                MemberEntity entity=new MemberEntity();
                entity.setId(dto.getId());
                entity.setUsername(dto.getUsername());
                entity.setUserpw(dto.getUserpw());
                return entity;
            }

        }

        public static class MemberDTOResp{
            public static MemberDTO toDTO(MemberEntity entity){
                MemberDTO dto=new MemberDTO();
                dto.setId(entity.getId());
                dto.setUsername(entity.getUsername());
                dto.setUserpw(entity.getUserpw());
                return dto;

            }

        }


}
