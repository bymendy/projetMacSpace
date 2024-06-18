package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Users;


import com.macsecurite.macsecurite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByNameLikeIgnoreCase(String name);
}
