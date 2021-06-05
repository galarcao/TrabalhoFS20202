package br.ufg.inf.imobiliaria.business;


import java.util.List;
import java.util.Optional;

import br.ufg.inf.imobiliaria.ctrl.exception.PessoaException;
import br.ufg.inf.imobiliaria.model.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.imobiliaria.ctrl.exception.UsuarioException;
import br.ufg.inf.imobiliaria.model.entities.Usuario;
import br.ufg.inf.imobiliaria.model.repositories.UsuarioRepository;
import org.springframework.transaction.support.TransactionTemplate;
import javax.transaction.Transactional;

@Service
public class UsuarioBusiness {
	
	private final UsuarioRepository repository;
	private final PessoaBusiness pessoaBusiness;
	
	public UsuarioBusiness(UsuarioRepository repository, PessoaBusiness pessoaBusiness) {
		this.repository = repository;
		this.pessoaBusiness = pessoaBusiness;
	}
	
	@Transactional
	public Usuario insert(Usuario usuario) throws UsuarioException, PessoaException {
		this.pessoaBusiness.insert(usuario.getPessoa());
		return repository.saveAndFlush(usuario);
	}
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Integer id) throws UsuarioException {
		Optional<Usuario> retorno = repository.findById(id);
		if(retorno.isEmpty()) {
			throw new UsuarioException("Usuário não encontrado!");
		}
		return retorno.get();
	}
	
	public Usuario update(Usuario usuario) throws UsuarioException {
		Usuario usuarioUpd = repository.findById(usuario.getIdUsuario()).get();
		usuarioUpd.setLogin(usuario.getLogin());
		return repository.save(usuarioUpd);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
