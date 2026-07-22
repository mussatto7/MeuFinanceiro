package com.devLucas.MeuFinanceiro.repository;

import com.devLucas.MeuFinanceiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
