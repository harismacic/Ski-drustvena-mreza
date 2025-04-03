package chat.realtimechat.services;

import chat.realtimechat.model.User;
import chat.realtimechat.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService (PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String email, String plainTextPassword) {
        if(userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists!");
        }
        if(userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists!");
        }
        if (username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (plainTextPassword == null || plainTextPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long!");
        }

        String encodedPassword = passwordEncoder.encode(plainTextPassword);
        User user = new User(username, email, encodedPassword);

        return userRepository.save(user);
    }
}
