package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(nativeQuery=true,value="select hd_id from user where user_name=:userName")
    public String findHdIdByUserName(@Param("userName") String userName);
}
