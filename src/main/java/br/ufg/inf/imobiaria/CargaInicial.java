package br.ufg.inf.imobiaria;

import java.util.Arrays;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.imobiaria.entities.Departamento;
import br.ufg.inf.imobiaria.entities.Funcionario;
import br.ufg.inf.imobiaria.entities.Pessoa;
import br.ufg.inf.imobiaria.entities.Usuario;
import br.ufg.inf.imobiaria.repositories.DepartamentoRepository;
import br.ufg.inf.imobiaria.repositories.FuncionarioRepository;
import br.ufg.inf.imobiaria.repositories.PessoaRepository;
import br.ufg.inf.imobiaria.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class CargaInicial implements CommandLineRunner {

	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat sdft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Pessoa pes1 = new Pessoa(null, "Harry James Poter", "00100100101", sdf.parse("31/07/1980"));
		Pessoa pes2 = new Pessoa(null, "Ronald Bilius Weasley", "00200200202", sdf.parse("01/03/1980"));
		Pessoa pes3 = new Pessoa(null, "Hermione Jean Granger", "00300300303", sdf.parse("19/09/1979"));
		Pessoa pes4 = new Pessoa(null, "Draco Lucius Malfoy", "00400400404", sdf.parse("05/06/1980"));
		Pessoa pes5 = new Pessoa(null, "Neville Longbottom", "00500500505", sdf.parse("30/07/1980"));
		Pessoa pes6 = new Pessoa(null, "Luna Lovegood", "00600600606", sdf.parse("13/02/1981"));
		Pessoa pes7 = new Pessoa(null, "Albus Percival Wulfric Brian Dumbledorer", "00700700707", sdf.parse("21/08/1881"));
		Pessoa pes8 = new Pessoa(null, "Severus Snape", "000800800808", sdf.parse("09/01/1860"));
		Pessoa pes9 = new Pessoa(null, "Minerva McGonagall", "00900900909", sdf.parse("04/09/1935"));
		Pessoa pes10 = new Pessoa(null, "Rúbeo Hagrid ", "01001001010", sdf.parse("06/12/1928"));

		pessoaRepository.saveAll(Arrays.asList(pes1, pes2, pes3, pes4, pes5, pes6, pes7, pes8, pes9, pes10));

		Usuario usu1 = new Usuario(null, "harry", "12345", pes1, true);
		Usuario usu2 = new Usuario(null, "rony", "12345", pes2, true);
		Usuario usu3 = new Usuario(null, "hermione", "12345", pes3, true);
		Usuario usu4 = new Usuario(null, "albus", "12345", pes7, true);
		Usuario usu5 = new Usuario(null, "severus", "12345", pes8, true);
		Usuario usu6 = new Usuario(null, "minerva", "12345", pes9, true);
		Usuario usu7 = new Usuario(null, "rubeo", "12345", pes10, true);
			
		usuarioRepository.saveAll(Arrays.asList(usu1, usu2, usu3, usu4, usu5, usu6, usu7));
	
		Departamento dep1 = new Departamento(null, "Comercial", null);
		Departamento dep2 = new Departamento(null, "Financeiro", null);
		departamentoRepository.saveAll(Arrays.asList(dep1, dep2));
		
		Funcionario func1 = new Funcionario(null, usu7, 3000.0f, sdf.parse("15/07/2020"), dep1, true);
		Funcionario func2 = new Funcionario(null, usu4, 5000.0f, sdf.parse("01/05/2015"), dep2, true);
		Funcionario func3 = new Funcionario(null, usu5, 2000.0f, sdf.parse("13/08/2018"), dep1, true);
		Funcionario func4 = new Funcionario(null, usu5, 1500.0f, sdf.parse("05/09/2017"), dep2, true);
		funcionarioRepository.saveAll(Arrays.asList(func1, func2, func3, func4));
		
		dep1.setChefe(func1);
		dep2.setChefe(func2);
		departamentoRepository.saveAll(Arrays.asList(dep1, dep2));
		
		
	}

}
