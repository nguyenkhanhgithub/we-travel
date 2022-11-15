package com.example.wetravel.Repository;

import com.example.wetravel.DTO.RoleDTO;
import com.example.wetravel.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getByRoleId(Integer roleId);
}
