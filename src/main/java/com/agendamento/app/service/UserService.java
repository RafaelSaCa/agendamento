package com.agendamento.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agendamento.app.domain.User;
import com.agendamento.app.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repostirory) {
        this.repository = repostirory;
    }

    public void create(User user) {
        if (repository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email já usado por outro usuário.");
        }
        repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(Long id, User user) {
        User userExists = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        if (user.getNome() != null) {
            userExists.setNome(user.getNome());
        }

        if (user.getEmail() != null) {
            User userEmail = repository.findByEmail(user.getEmail());

            if (userEmail != null && !userEmail.getId().equals(userExists.getId())) {
                throw new IllegalArgumentException("Email já usado por outro usuário.");
            }
            userExists.setEmail(user.getEmail());

        }

        if (user.getSenha() != null) {
            userExists.setSenha(user.getSenha());
        }

        return repository.save(userExists);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
