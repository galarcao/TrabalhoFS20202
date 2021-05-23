package br.ufg.inf.imobiaria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.imobiaria.entities.AgendaVisita;
import br.ufg.inf.imobiaria.entities.Contrato;
import br.ufg.inf.imobiaria.entities.Departamento;
import br.ufg.inf.imobiaria.entities.Funcionario;
import br.ufg.inf.imobiaria.entities.Imovel;
import br.ufg.inf.imobiaria.entities.PagamentoAluguel;
import br.ufg.inf.imobiaria.entities.Pessoa;
import br.ufg.inf.imobiaria.entities.Usuario;
import br.ufg.inf.imobiaria.enums.FormaPagamento;
import br.ufg.inf.imobiaria.enums.StatusImovel;
import br.ufg.inf.imobiaria.enums.TipoImovel;
import br.ufg.inf.imobiaria.repositories.AgendaVisitaRepository;
import br.ufg.inf.imobiaria.repositories.ContratoRepository;
import br.ufg.inf.imobiaria.repositories.DepartamentoRepository;
import br.ufg.inf.imobiaria.repositories.FuncionarioRepository;
import br.ufg.inf.imobiaria.repositories.ImovelRepository;
import br.ufg.inf.imobiaria.repositories.PagamentoAluguelRepository;
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
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private AgendaVisitaRepository agendaVisitaRepository; 

	@Autowired
	private ContratoRepository contratoRepository; 

	@Autowired
	private PagamentoAluguelRepository pagamentoAluguelRepository; 
	
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
		
		
		Imovel imo1 = new Imovel(null, TipoImovel.APARTAMENTO, StatusImovel.OCUPADO, "Rua das Arraras", "Ap 303", "Jardim dos Pássaros", "Goiânia", 3, 2, 1, 55);
		Imovel imo2 = new Imovel(null, TipoImovel.CASA, StatusImovel.OCUPADO, "Rua das Gaivotas", null, "Jardim dos Pássaros", "Goiânia", 3, 2, 2, 85);
		Imovel imo3 = new Imovel(null, TipoImovel.TERRENO_LOTE, StatusImovel.DESOCUPADO, "Rua dos Urubus", null, "Jardim dos Pássaros", "Goiânia", null, null, null, 360);
		Imovel imo4 = new Imovel(null, TipoImovel.SALA_COMERCIAL, StatusImovel.DESOCUPADO, "Rua dos Canários", null, "Jardim dos Pássaros", "Goiânia", null, null, null, 200);
		Imovel imo5 = new Imovel(null, TipoImovel.APARTAMENTO, StatusImovel.DESOCUPADO, "Rua dos Sabiás", null, "Jardim dos Pássaros", "Goiânia", 3, 1, 1, 70);
		Imovel imo6 = new Imovel(null, TipoImovel.CASA, StatusImovel.DESOCUPADO, "Rua dos Uirapuru", null, "Jardim dos Pássaros", "Goiânia", 3, 2, 2, 85);
	
		imovelRepository.saveAll(Arrays.asList(imo1, imo2, imo3, imo4, imo4, imo5, imo5, imo6));
		
		AgendaVisita age1 = new AgendaVisita(null, usu1, imo1, sdft.parse("01/03/2021 08:00:00"), sdft.parse("01/05/2021 08:03:00"), sdft.parse("01/05/2021 08:55:00"), true);
		AgendaVisita age2 = new AgendaVisita(null, usu2, imo2, sdft.parse("08/02/2021 15:00:00"), sdft.parse("08/02/2021 15:15:00"), sdft.parse("08/02/2021 15:40:00"), true);
		AgendaVisita age3 = new AgendaVisita(null, usu3, imo6, sdft.parse("22/04/2021 11:00:00"), sdft.parse("22/04/2021 11:03:00"), sdft.parse("22/04/2021 12:00:00"), true);

		agendaVisitaRepository.saveAll(Arrays.asList(age1, age2, age3));
		
		Set<Pessoa> fiadores = new HashSet<Pessoa>(); 
		fiadores.add(pes5);
		fiadores.add(pes6);
			
		Contrato con1 = new Contrato(null, usu1, imo1, fiadores, sdf.parse("20/04/2021"), true, 800.0f, 10, 0.1f, 12);
		Contrato con2 = new Contrato(null, usu2, imo1, fiadores, sdf.parse("15/02/2021"), true, 1200.0f, 1, 0.05f, 18);
		Contrato con3 = new Contrato(null, usu3, imo1, fiadores, sdf.parse("30/04/2021"), true, 1000.0f, 15, 0.07f, 19);

		contratoRepository.saveAll(Arrays.asList(con1, con2, con3));
		
		PagamentoAluguel pag1 = new PagamentoAluguel(null, con1, 720.0f, sdf.parse("10/05/2021"), sdf.parse("09/05/2021"), FormaPagamento.BOLETO);
		PagamentoAluguel pag2 = new PagamentoAluguel(null, con2, 1140.0f, sdf.parse("01/03/2021"), sdf.parse("01/03/2021"), FormaPagamento.PIX);
		PagamentoAluguel pag3 = new PagamentoAluguel(null, con2, 1140.0f, sdf.parse("01/04/2021"), sdf.parse("028/02/2021"), FormaPagamento.PIX);
		PagamentoAluguel pag4 = new PagamentoAluguel(null, con2, 1140.0f, sdf.parse("01/05/2021"), sdf.parse("01/04/2021"), FormaPagamento.TRANSFERENCIA);
		PagamentoAluguel pag5 = new PagamentoAluguel(null, con2, 1000.0f, sdf.parse("15/05/2021"), sdf.parse("20/05/2021"), FormaPagamento.CARTAOCREDITO);
		
		pagamentoAluguelRepository.saveAll(Arrays.asList(pag1, pag2, pag3, pag4, pag5));
	}

}
