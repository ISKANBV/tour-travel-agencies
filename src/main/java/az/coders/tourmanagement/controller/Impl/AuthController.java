package az.coders.tourmanagement.controller.Impl;

import az.coders.tourmanagement.model.JwtResponse;
import az.coders.tourmanagement.model.LoginRequest;
import az.coders.tourmanagement.model.MessageResponse;
import az.coders.tourmanagement.model.SignupRequest;
import az.coders.tourmanagement.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public JwtResponse authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return service.authenticate(loginRequest);
    }

    @PostMapping("/signup")
    public MessageResponse register(@Valid @RequestBody SignupRequest signUpRequest) {
        return service.register(signUpRequest);
    }
}