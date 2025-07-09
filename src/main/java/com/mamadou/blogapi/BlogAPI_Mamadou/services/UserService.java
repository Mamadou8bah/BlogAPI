package com.mamadou.blogapi.BlogAPI_Mamadou.services;

import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import com.mamadou.blogapi.BlogAPI_Mamadou.repositories.UserRepository;
import com.mamadou.blogapi.BlogAPI_Mamadou.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User register(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repo.save(user);
    }

    public String login(String email, String rawPassword) {
        User user = repo.findByEmail(email);
        if (user==null) {
            throw new RuntimeException("User not found");
        }

        if (!bCryptPasswordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        return jwtUtil.generateToken(user.getEmail());
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }
    public void deleteUserByEmail(String email) {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        repo.delete(user);
    }

}
