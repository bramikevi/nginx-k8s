package com.project.springbootpodnginx.service;

import com.project.springbootpodnginx.dto.UserDto;
import com.project.springbootpodnginx.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import com.project.springbootpodnginx.repo.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void updateUser(String id, String updatePod, UserDto updatedUser) {
        try {
            Optional<UserEntity> existingUserOpt = userRepository.findById(id);
            if (existingUserOpt.isPresent()) {
                UserEntity existingUser = existingUserOpt.get();
                existingUser.setName(updatedUser.getName());
                existingUser.setUpdatePod(updatePod);
                userRepository.save(existingUser);
            } else {
                throw new RuntimeException("User not found with id: " + id);
            }
        } catch (OptimisticLockingFailureException e) {
            // Obsługa konfliktu wersji, np. ponowienie operacji lub informowanie użytkownika
            throw new RuntimeException("Conflict occurred while updating the user", e);
        }
    }
}
