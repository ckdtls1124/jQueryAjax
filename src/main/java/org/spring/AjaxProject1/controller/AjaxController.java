package org.spring.AjaxProject1.controller;

import org.spring.AjaxProject1.dto.MemberDTO;
import org.spring.AjaxProject1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/registerMain")
    public String showRegister(){
        return "register1";
    }

    @PostMapping("/register")
    public @ResponseBody int register( @ModelAttribute MemberDTO memberDTO)
    {int rs=memberService.register(memberDTO);
        return rs;
    }

    @PostMapping("/dupCheck")
    public @ResponseBody int dupCheck(@RequestParam String username){
        int rs=memberService.dupCheck(username);

        return rs;
    }


}
