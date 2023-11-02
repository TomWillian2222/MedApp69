package com.MedApp.historico2.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/session-timeout")
    public ResponseEntity<Integer> getSessionTimeout() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return ResponseEntity.ok(session.getMaxInactiveInterval());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
