package az.coders.tourmanagement.service;

import az.coders.tourmanagement.model.JwtResponse;
import az.coders.tourmanagement.model.LoginRequest;
import az.coders.tourmanagement.model.MessageResponse;
import az.coders.tourmanagement.model.SignupRequest;

public interface AuthService {

    JwtResponse authenticate(LoginRequest loginRequest);

    MessageResponse register(SignupRequest signUpRequest);
}