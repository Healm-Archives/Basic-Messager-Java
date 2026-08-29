package com.example.pack.group.dto;

import java.util.List;

public record GroupInfoListDto(
        List<GroupInfoDto> groupList
) {
        public GroupInfoListDto(GroupInfoDto group){
                this(List.of(group));
        }
}
