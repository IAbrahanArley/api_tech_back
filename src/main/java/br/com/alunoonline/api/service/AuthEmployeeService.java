package br.com.alunoonline.api.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


import br.com.alunoonline.api.dtos.CredenciaisConta;
import br.com.alunoonline.api.dtos.EmployeeCredentialsDTO;
import br.com.alunoonline.api.dtos.TokenDTO;
import br.com.alunoonline.api.model.Employee;
import br.com.alunoonline.api.model.Permission;
import br.com.alunoonline.api.repository.AuthRepository;
import br.com.alunoonline.api.repository.EmployeeRepository;
import br.com.alunoonline.api.repository.PermissionRepository;
import br.com.alunoonline.api.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
import org.springframework.stereotype.Service;


@Service
public class AuthEmployeeService {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    private static final Logger logger = Logger.getLogger(AuthEmployeeService.class.getName());

    @SuppressWarnings("rawtypes")
    public ResponseEntity signin(CredenciaisConta data) {
        try {
            var username = data.getUsuario();
            var password = data.getSenha();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            var user = authRepository.findByEmail(username);

            var tokenResponse = new TokenDTO();
            if (user != null) {

                tokenResponse = tokenProvider.createAccessToken(username, user.getRoles());
            } else {

                throw new UsernameNotFoundException("Username " + username + " not found!");
            }

            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }
    @SuppressWarnings("rawtypes")
    public ResponseEntity refreshToken(String username, String refreshToken) {
        var user = employeeRepository.findByUsername(username);

        var tokenResponse = new TokenDTO();
        if (user != null) {
            tokenResponse = tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
        return ResponseEntity.ok(tokenResponse);
    }

    public Employee signUp(EmployeeCredentialsDTO data) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        Permission permission = permissionRepository.findByDescription("ROLE_ADMIN");
        Pbkdf2PasswordEncoder pbkdf2Encoder =
                new Pbkdf2PasswordEncoder(
                        "", 8, 185000,
                        SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

        encoders.put("pbkdf2", pbkdf2Encoder);
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);

        String result1 = passwordEncoder.encode(data.getPassword());
        data.setPassword(result1);
        Employee obj = fromDTO(data);
        obj.setPermissions(new ArrayList<>());
        obj.getPermissions().add(permission);
        return employeeRepository.save(obj);
    }
    public Employee fromDTO(EmployeeCredentialsDTO objDto) {
        return new Employee(objDto.getEmail(), objDto.getPassword(), objDto.getNameEmployee(),   true, true, true, true);
    }

}