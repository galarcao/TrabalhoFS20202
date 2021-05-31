package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.ufg.inf.imobiliaria.model.entities.Funcionario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {

}
