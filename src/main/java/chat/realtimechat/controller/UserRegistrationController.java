package chat.realtimechat.controller;

import chat.realtimechat.model.User;
import chat.realtimechat.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/api/users")
public class UserRegistrationController {
    private final UserService userService;
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register-form")
    public String showRegistrationForm() {
        return "registracija";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password) {

        try {
            User user = userService.registerUser(username, email, password);
            return ResponseEntity.ok("User registered successfully! ID: " + user.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
