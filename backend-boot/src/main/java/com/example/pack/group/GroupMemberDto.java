package com.example.pack.group;

import java.util.List;

import com.example.pack.user.UserMemberDto;

public record GroupMemberDto(
        List<UserMemberDto> memberList
) {}
