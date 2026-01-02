package com.agendamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.app.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
}
