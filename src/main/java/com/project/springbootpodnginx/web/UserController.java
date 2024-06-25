package com.project.springbootpodnginx.web;

import com.project.springbootpodnginx.dto.UserDto;
import com.project.springbootpodnginx.entity.UserEntity;
import com.project.springbootpodnginx.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
//@AllArgsConstructor
public class UserController {

    @Value("${POD_NAME:unknown}")
    private String podName;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserDto userDto) {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid.toString())
                .name(userDto.getName())
                .pod(podName)
                .build();
        return userService.saveUser(userEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UserDto updatedUser) {
        try {
            userService.updateUser(id, podName, updatedUser);
            return ResponseEntity.ok("User updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // Conflict status code
        }
    }
}
