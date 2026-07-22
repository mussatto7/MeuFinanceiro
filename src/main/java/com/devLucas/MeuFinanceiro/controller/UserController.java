package com.devLucas.MeuFinanceiro.controller;

import com.devLucas.MeuFinanceiro.dto.UserDTO;
import com.devLucas.MeuFinanceiro.entity.User;
import com.devLucas.MeuFinanceiro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOS = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOS);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserDTO userDTO) {
        User obj = userService.fromDto(userDTO);
        obj = userService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UserDTO userDTO) {
        User obj = userService.fromDto(userDTO);
        obj.setId(id);
        userService.uptade(id, obj);
        return ResponseEntity.noContent().build();
    }

}
