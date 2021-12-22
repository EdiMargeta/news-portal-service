package com.newsPortal.newsPortal.model.dto;

import com.newsPortal.newsPortal.model.entity.Role;
import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    private String name;

    public static RoleDTO fromEntity(Role role){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());

        return roleDTO;
    }
}
