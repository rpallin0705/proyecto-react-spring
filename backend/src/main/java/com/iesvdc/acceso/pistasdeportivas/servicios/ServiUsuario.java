package com.iesvdc.acceso.pistasdeportivas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesvdc.acceso.pistasdeportivas.modelos.Usuario;
import com.iesvdc.acceso.pistasdeportivas.repos.RepoUsuario;

@Service
public class ServiUsuario {

    @Autowired
    private RepoUsuario repoUsuario;

    public List<Usuario> findAll() {
        return repoUsuario.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return repoUsuario.findById(id);
    }

    public Usuario save(Usuario usuario) {
        // usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        // lo hace Spring por nosotros
        return repoUsuario.save(usuario);
    }    

    public void delete(Usuario usuario) {
        repoUsuario.delete(usuario);
    }

    public Optional<Usuario> update(Long id, Usuario usuario) {
        return repoUsuario.findById(id).map(existing -> {

            existing.setUsername(usuario.getUsername());
            existing.setEmail(usuario.getEmail());
            existing.setEnabled(usuario.isEnabled());
            existing.setPassword(usuario.getPassword());
            
            return repoUsuario.save(existing);
        });
    }
}