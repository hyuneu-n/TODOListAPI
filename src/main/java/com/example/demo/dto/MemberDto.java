package com.example.demo.dto;

import com.example.demo.domain.Todo;
import com.example.demo.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MemberDto {
    private int id;
    private String memberId;
    private String name;
    private String email;
    private String passwd;
    private List<Integer> todoIds;

    public static MemberDto from(Member member){
        MemberDto dto = new MemberDto();
        dto.setId(member.getId());
        dto.setMemberId(member.getMemberId());
        dto.setPasswd(member.getPasswd());
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());
        dto.setTodoIds(member.getTodoList().stream().map(Todo::getId).collect(Collectors.toList()));
        return dto;
    }
}
