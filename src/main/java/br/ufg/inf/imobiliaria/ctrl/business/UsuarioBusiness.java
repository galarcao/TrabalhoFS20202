package br.ufg.inf.imobiliaria.ctrl.business;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.imobiliaria.ctrl.exception.UsuarioException;
import br.ufg.inf.imobiliaria.model.entities.Usuario;
import br.ufg.inf.imobiliaria.model.repositories.UsuarioRepository;

@Service
public class UsuarioBusiness {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario insert(Usuario usuario) throws UsuarioException {
		return(repository.save(usuario));
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
