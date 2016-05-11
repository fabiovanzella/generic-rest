package br.com.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {	

}
