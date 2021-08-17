package br.com.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.helpdesk.domain.Chamado;
import br.com.helpdesk.domain.Cliente;
import br.com.helpdesk.domain.Tecnico;
import br.com.helpdesk.enums.Perfil;
import br.com.helpdesk.enums.Prioridade;
import br.com.helpdesk.enums.Status;
import br.com.helpdesk.repositories.ChamadoRepository;
import br.com.helpdesk.repositories.ClienteRepository;
import br.com.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskBeApplication implements CommandLineRunner {

	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	TecnicoRepository tecnicoRepository;
	
	@Autowired
	ChamadoRepository chamadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskBeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "760.457.770-93", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "705.117.440-13", "torvalds@mail.com", "123");
		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", cli1,tec1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(chamado1));
	}

}
