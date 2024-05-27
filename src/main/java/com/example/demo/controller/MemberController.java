package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService userService) {
        this.memberService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable int id){
        MemberDto member = memberService.getMemberById(id);
        if(member == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberDto memberDto){
        memberService.createMember(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMember(@PathVariable int id, @RequestBody MemberDto memberDto){
        memberService.updateMember(id, memberDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable int id){
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
}
