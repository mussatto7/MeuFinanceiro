package com.devLucas.MeuFinanceiro.entity;

import com.devLucas.MeuFinanceiro.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "usuario", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 20, nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDate registrationDate;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDate updateDate;

    public User() {
    }

    ;

    public User(UUID id, String username, String email, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
