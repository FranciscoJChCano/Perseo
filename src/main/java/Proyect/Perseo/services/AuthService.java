package Proyect.Perseo.services;

import Proyect.Perseo.dtos.request.LoginRequest;
import Proyect.Perseo.dtos.request.RegisterRequest;
import Proyect.Perseo.dtos.response.AuthResponse;
import Proyect.Perseo.models.User;
import Proyect.Perseo.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        UserDetails users = iUserRepository.findByUsername(login.getUsername()).orElseThrow();

        String token = jwtService.getTokenService(users);

        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(RegisterRequest register) {
        User user =
                User.builder()
                        .username(register.getUsername())
                        .email(register.getEmail())
                        .password(passwordEncoder.encode(register.getPassword()))
                        .role(register.getRole())
                        .build();

        iUserRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getTokenService(user))
                .role(register.getRole())
                .build();
    }
}
