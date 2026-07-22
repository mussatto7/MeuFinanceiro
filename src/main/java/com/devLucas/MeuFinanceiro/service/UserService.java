package com.devLucas.MeuFinanceiro.service;

import com.devLucas.MeuFinanceiro.dto.UserDTO;
import com.devLucas.MeuFinanceiro.entity.User;
import com.devLucas.MeuFinanceiro.repository.UserRepository;
import com.devLucas.MeuFinanceiro.service.exceptions.DatabaseException;
import com.devLucas.MeuFinanceiro.service.exceptions.LengthException;
import com.devLucas.MeuFinanceiro.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User obj) {
        if (obj.getUsername() == null || obj.getUsername().length() > 20) {
            throw new LengthException("Campo usuário é permitido somente 20 caracteres!");
        } else if (obj.getEmail() == null || obj.getEmail().length() > 50) {
            throw new LengthException("Campo email é permitido somente 50 caracteres!");
        } else if (obj.getPassword() == null || obj.getPassword().length() > 20) {
            throw new LengthException("Campo password é permitido somente 20 caracteres!");
        }
        try {
            return userRepository.save(obj);
        } catch (DataIntegrityViolationException | HttpMessageNotReadableException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(UUID id) {
        try {
            if (!userRepository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            userRepository.deleteById(id);
        } catch (MethodArgumentTypeMismatchException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public User uptade(UUID id, User obj) {
        if (obj.getUsername() == null || obj.getUsername().length() > 20) {
            throw new LengthException("Campo usuário é permitido somente 20 caracteres!");
        } else if (obj.getEmail() == null || obj.getEmail().length() > 50) {
            throw new LengthException("Campo email é permitido somente 50 caracteres!");
        } else if (obj.getPassword() == null || obj.getPassword().length() > 20) {
            throw new LengthException("Campo password é permitido somente 20 caracteres!");
        }
        try {
            User entity = userRepository.getReferenceById(id);
            updateData(entity, obj);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException | HttpMessageNotReadableException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(User entity, User obj) {
        entity.setUsername(obj.getUsername());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
        entity.setRole(obj.getRole());
    }

    public User fromDto(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getRole());
    }
}
