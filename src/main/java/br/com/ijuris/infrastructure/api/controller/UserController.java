package br.com.ijuris.infrastructure.api.controller;

import br.com.ijuris.core.application.dto.CreateUserInput;
import br.com.ijuris.core.application.dto.UpdateUserInput;
import br.com.ijuris.core.application.port.in.ChangeEmailUseCase;
import br.com.ijuris.core.application.port.in.UpdateUserProfileUseCase;
import br.com.ijuris.core.application.usecase.CreateUser;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.infrastructure.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final UpdateUserProfileUseCase updateUserProfileUseCase;
    private final ChangeEmailUseCase changeEmailUseCase;

    public UserController(CreateUser createUser, UpdateUserProfileUseCase updateUserProfileUseCase, ChangeEmailUseCase changeEmailUseCase) {
        this.createUser = createUser;
        this.updateUserProfileUseCase = updateUserProfileUseCase;
        this.changeEmailUseCase = changeEmailUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> handleCreateUser(@RequestBody @Valid CreateUserRequestDTO request) {

        CreateUserInput createUserInput = request.toInput();

        User createdUser = createUser.execute(createUserInput);

        return ResponseEntity.status(HttpStatus.CREATED).body(CreateUserResponseDTO.fromDomain(createdUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponseDTO> handleUpdateUserProfile(
            @RequestBody @Valid UpdateUserRequestDTO request, @PathVariable UUID id
    ) {

        UpdateUserInput updateUserInput = request.toInput();

        User updatedUser = updateUserProfileUseCase.execute(id, updateUserInput);

        return ResponseEntity.status(HttpStatus.OK).body(UpdateUserResponseDTO.fromDomain(updatedUser));
    }

    @PatchMapping("/{id}/email")
    public ResponseEntity<ChangeEmailResponseDTO> handleChangeEmail(
            @RequestBody
            @Valid ChangeEmailRequestDTO request,
            @PathVariable UUID id
    ) {
        String updatedEmail = changeEmailUseCase.execute(id, request.email());

        return ResponseEntity.status(HttpStatus.OK).body(ChangeEmailResponseDTO.fromDomain(updatedEmail));
    }
}
