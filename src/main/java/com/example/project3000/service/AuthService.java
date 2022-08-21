package com.example.project3000.service;

import com.example.project3000.model.User;
import com.example.project3000.model.dto.UserRegistrationDTO;
import com.example.project3000.repository.UsersRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    public AuthService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byEmail = this.usersRepository.findByEmail(registrationDTO.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }

        User user = new User(
                registrationDTO.getUsername(),
                passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getEmail(),
                registrationDTO.getFullName(),
                registrationDTO.getAge()
        );

        this.usersRepository.save(user);
    }

    public User getByUsername(String username){
        return usersRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
