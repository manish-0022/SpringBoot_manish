package com.SthumbhManish.demo.Repositry;

import com.SthumbhManish.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementRepository extends JpaRepository<UserEntity,Long>{



}
