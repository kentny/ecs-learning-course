package org.example.sessionmanagement.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final HttpSession httpSession;

    public UserController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping("/status")
    ResponseEntity<String> status() {
        if (this.httpSession.getAttribute("login-status") == null) {
            return ResponseEntity.ok("You Are 'Logged Out'");
        }
        return ResponseEntity.ok("You Are 'Logged In'");
    }

    @GetMapping("/login")
    ResponseEntity<String> login() {
        this.httpSession.setAttribute("login-status", "Logged In");
        return ResponseEntity.ok("Logged In");
    }

    @GetMapping("/logout")
    ResponseEntity<String> logout() {
        this.httpSession.invalidate();
        return ResponseEntity.ok("Logged Out");
    }
}
