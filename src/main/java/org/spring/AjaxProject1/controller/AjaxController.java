package org.spring.AjaxProject1.controller;

import org.spring.AjaxProject1.dto.MemberDTO;
import org.spring.AjaxProject1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    private MemberService memberService;
    private AjaxController(MemberService memberService){
        this.memberService=memberService;
    }

//    @PostMapping("/ajax3")
//    public @ResponseBody String ajax3(
//            @RequestParam(value = "username", required = true) String username,
//            @RequestParam(value = "userpw", required = true) String userpw
//    ){
//        System.out.println("Ajax3");
//
//        System.out.println("username: "+username);
//        System.out.println("userpw: "+userpw);
//
//        return "ajax_index";
//    }

//=======================================================



//=======================Register========================
    @GetMapping("/registerMain")
    public String showRegister(){
        return "register1";
    }
//    Duplication Check
    @PostMapping("/dupCheck")
    public @ResponseBody int dupCheck(@RequestParam String username){
        int rs=memberService.dupCheck(username);

        return rs;
    }
//    Register
    @PostMapping("/register")
    public @ResponseBody int register( @ModelAttribute MemberDTO memberDTO)
    {int rs=memberService.register(memberDTO);
        return rs;
    }

//=======================Show==========================

//    go to Lists Page
    @GetMapping("/listsPage")
    public String goListsPage(){
        return "ajax_ex/ajax_list";
    }


//    show all the lists
    @GetMapping("/showLists")
    public @ResponseBody List<MemberDTO> showAllLists(){
        List<MemberDTO> result=memberService.showLists();
        return result;
    }

//    show each list
    @PostMapping("/detailList")
    public @ResponseBody MemberDTO showEachList(@RequestParam Long id){
        MemberDTO dto=memberService.showEachList(id);
        if(dto != null){
            System.out.println("Show "+id+"'s data went successful.");
            return dto;
        } else {
            System.out.println("Nothing returned.");
            return null;
        }

    }
}
