package br.ufg.inf.imobiaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiaria.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
}
