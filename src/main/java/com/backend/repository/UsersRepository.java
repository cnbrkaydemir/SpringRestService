package com.backend.repository;

import com.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Integer> {
List<Users> findAllByUserName(String name);
Users findByUserId(int id);
Users findByUserEmail(String email);

List<Users> findByUserName(String name);
Users findByUserCity(String city);



}
