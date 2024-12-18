package com.example.demo.Controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.CadastroRequest;
import com.example.demo.dto.CadastroResponse;

import com.example.demo.model.Coordenador;
import com.example.demo.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coordenadores")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            Coordenador coordenador = coordenadorService.autenticar(loginRequest.getLogin(), loginRequest.getSenha());
            LoginResponse response = new LoginResponse("Login realizado com sucesso!", coordenador);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new LoginResponse("Credenciais inválidas.", null));
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<CadastroResponse> cadastrar(@RequestBody CadastroRequest cadastroRequest) {
        try {
            CadastroResponse response = coordenadorService.cadastrar(cadastroRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new CadastroResponse("Erro ao cadastrar usuário: " + e.getMessage(), null));
        }
    }
}

