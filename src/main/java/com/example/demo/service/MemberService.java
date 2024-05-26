package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(com.example.demo.repository.MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //read
    public MemberDto getMemberById(int id){
        Member member = memberRepository.findById(id).orElse(null);
        if(member == null)
            return null;
        return MemberDto.from(member);
    }

    //create
    public void createMember(MemberDto memberDto){
        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        member.setName(memberDto.getName());
        member.setPasswd(memberDto.getPasswd());
        member.setEmail(memberDto.getEmail());
        memberRepository.save(member);
    }

    //update
    public void updateMember(int id, MemberDto memberDto){
        Member member = memberRepository.findById(id).orElse(null);
        if(member != null){
            member.setMemberId(memberDto.getMemberId());
            member.setName(memberDto.getName());
            member.setPasswd(memberDto.getPasswd());
            member.setEmail(member.getEmail());
            memberRepository.save(member);
        }
    }

    //delete
    public void deleteMember(int id){
        memberRepository.deleteById(id);
    }

}
