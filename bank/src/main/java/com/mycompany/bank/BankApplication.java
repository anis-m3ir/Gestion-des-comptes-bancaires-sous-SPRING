package com.mycompany.bank;

import com.mycompany.bank.entity.*;
import com.mycompany.bank.repository.ClientRepository;
import com.mycompany.bank.repository.CompteRepository;
import com.mycompany.bank.repository.OperationRepository;
import com.mycompany.bank.service.InterfaceBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private InterfaceBanqueService interfaceBanqueService;

	public static void main(String[] args){

	SpringApplication.run(BankApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	/*	Client c1 = clientRepository.save(new Client("anis","anis.guellal@outlook.fr"));
		Client c2 = clientRepository.save(new Client("amine","amine.guellal@outlook.fr"));

		Compte cp1 = compteRepository.save(new CompteCourant("c1",new Date(),10000,c1,6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2",new Date(),7000,c2,5.5));

		Operation op1 = operationRepository.save(new Versement(new Date(), 900, cp1));
		Operation op2 = operationRepository.save(new Retrait(new Date(), 500, cp2));

		interfaceBanqueService.verser("c1",111111111);
		interfaceBanqueService.verser("c2",111111111);

		interfaceBanqueService.virement("c1","c2",111111111);
	*/}
}
