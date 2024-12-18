package com.example.demo.service;

import com.example.demo.dto.CadastroRequest;
import com.example.demo.dto.CadastroResponse;
import com.example.demo.model.Coordenador;
import com.example.demo.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository repository;

    /**
     * Autentica um coordenador pelo login e senha.
     *
     * @param login Login do coordenador.
     * @param senha Senha do coordenador.
     * @return Coordenador autenticado.
     */
    public Coordenador autenticar(String login, String senha) {
        Coordenador coordenador = repository.findByLoginAndSenha(login, senha);
        if (coordenador == null) {
            throw new RuntimeException("Login ou senha inválidos!");
        }
        return coordenador;
    }

    /**
     * Cadastra um novo coordenador.
     *
     * @param cadastroRequest Dados do cadastro.
     * @return Resposta com mensagem de sucesso e ID do coordenador cadastrado.
     */
    public CadastroResponse cadastrar(CadastroRequest cadastroRequest) {
        Coordenador coordenador = new Coordenador();
        coordenador.setLogin(cadastroRequest.getLogin());
        coordenador.setSenha(cadastroRequest.getSenha()); // Em produção, usar criptografia
        coordenador.setTipo(cadastroRequest.getTipo() != null ? cadastroRequest.getTipo() : "egresso");

        Coordenador coordenadorSalvo = repository.save(coordenador);

        return new CadastroResponse("Usuário cadastrado com sucesso!", coordenadorSalvo.getIdCoordenador());
    }

    /**
     * Lista todos os coordenadores.
     *
     * @return Lista de todos os coordenadores.
     */
    public List<Coordenador> listarTodos() {
        return repository.findAll();
    }

    /**
     * Busca um coordenador por ID.
     *
     * @param id ID do coordenador.
     * @return Coordenador encontrado.
     */
    public Optional<Coordenador> buscarPorId(Long id) { // Alterado para Long
        return repository.findById(id);
    }

    /**
     * Salva ou atualiza um coordenador.
     *
     * @param coordenador Coordenador a ser salvo.
     * @return Coordenador salvo.
     */
    public Coordenador salvar(Coordenador coordenador) {
        return repository.save(coordenador);
    }

    /**
     * Exclui um coordenador pelo ID.
     *
     * @param id ID do coordenador.
     */
    public void excluir(Long id) { // Alterado para Long
        repository.deleteById(id);
    }

    /**
     * Busca um coordenador pelo login.
     *
     * @param login Login do coordenador.
     * @return Coordenador encontrado.
     */
    public Coordenador buscarPorLogin(String login) {
        Coordenador coordenador = repository.fetchByLogin(login);
        if (coordenador == null) {
            throw new RuntimeException("Coordenador com login " + login + " não encontrado!");
        }
        return coordenador;
    }

    /**
     * Verifica se um coordenador existe pelo login e senha.
     *
     * @param login Login do coordenador.
     * @param senha Senha do coordenador.
     * @return Coordenador encontrado ou null.
     */
    public Coordenador verificarPorLoginESenha(String login, String senha) {
        return repository.findByLoginAndSenha(login, senha);
    }

    /**
     * Busca todos os coordenadores de um determinado tipo.
     *
     * @param tipo Tipo do coordenador.
     * @return Lista de coordenadores do tipo especificado.
     */
    public List<Coordenador> buscarPorTipo(String tipo) {
        return repository.findByTipo(tipo);
    }
}
