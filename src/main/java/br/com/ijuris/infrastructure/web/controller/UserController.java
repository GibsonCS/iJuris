package br.com.ijuris.infrastructure.web.controller;

import br.com.ijuris.application.dto.CreateUserInput;
import br.com.ijuris.application.usecase.CreateUser;
import br.com.ijuris.domain.entity.User;
import br.com.ijuris.infrastructure.web.dto.CreateUserRequestDTO;
import br.com.ijuris.infrastructure.web.dto.CreateUserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> handleCreateUser(@RequestBody @Valid CreateUserRequestDTO request) {

        CreateUserInput createUserInput = request.toInput();

        User createdUser = createUser.execute(createUserInput);

        return ResponseEntity.status(HttpStatus.CREATED).body(CreateUserResponseDTO.fromDomain(createdUser));
    }
}
