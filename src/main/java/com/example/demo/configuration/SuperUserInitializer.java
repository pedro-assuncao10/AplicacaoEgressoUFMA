package com.example.demo.configuration;

import com.example.demo.model.Coordenador;
import com.example.demo.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SuperUserInitializer implements CommandLineRunner {

    private final CoordenadorRepository coordenadorRepository;

    @Value("${superuser.login}")
    private String superUserLogin;

    @Value("${superuser.password}")
    private String superUserPassword;

    @Value("${superuser.type}")
    private String superUserType;

    public SuperUserInitializer(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verificar se o superusuário já existe
        if (coordenadorRepository.findByLogin(superUserLogin).isEmpty()) {
            Coordenador superUser = new Coordenador();
            superUser.setLogin(superUserLogin);
            superUser.setSenha(superUserPassword);
            superUser.setTipo("super");

            coordenadorRepository.save(superUser);
        System.out.println("Superusuário criado com sucesso: " + superUserLogin);
        } else {
            System.out.println("Superusuário já existe: " + superUserLogin);
        }
    }
}

