package com.wixis.bigidy.authentication.repo;

import com.wixis.bigidy.authentication.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
