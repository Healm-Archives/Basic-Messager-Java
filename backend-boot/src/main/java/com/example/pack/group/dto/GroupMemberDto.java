package com.example.pack.group.dto;

import java.util.List;

import com.example.pack.user.dto.UserMemberDto;

public record GroupMemberDto(
        List<UserMemberDto> memberList
) {}
