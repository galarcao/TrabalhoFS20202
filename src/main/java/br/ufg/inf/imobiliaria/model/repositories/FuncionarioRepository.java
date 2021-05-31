package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiliaria.model.entities.Funcionario;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

	List<Funcionario> list(Pageable page);
}
