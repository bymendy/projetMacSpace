package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Role;
import com.macsecurite.macsecurite.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService  {


    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role) {
        Role findRole = roleRepository.findByNameLikeIgnoreCase(role.getName());
        if (findRole != null) {
            return findRole;
        }
        return roleRepository.save(role);
    }
}