package com.example.bilete.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.example.bilete.model.Utilizator;
import com.example.bilete.repository.UtilizatorRepository;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilizatorRepository utilizatorRepository;

    public CustomUserDetailsService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilizator utilizator = utilizatorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilizatorul nu a fost găsit: " + email));

        return new org.springframework.security.core.userdetails.User(
                utilizator.getEmail(),
                utilizator.getParola(),
                utilizator.getRoluri().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getNume()))
                        .collect(Collectors.toList())
        );
    }
}