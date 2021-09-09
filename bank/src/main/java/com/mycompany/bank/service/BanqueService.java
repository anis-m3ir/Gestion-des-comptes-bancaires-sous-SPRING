package com.mycompany.bank.service;

import com.mycompany.bank.entity.*;
import com.mycompany.bank.repository.CompteRepository;
import com.mycompany.bank.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BanqueService implements InterfaceBanqueService{

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Compte  consulterCompte(String codeCpte) {
        Compte cp = compteRepository.findById(codeCpte).orElse(null);
        if(cp==null) throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public void verser(String codeCpte, double montant) {
        Compte cp = consulterCompte(codeCpte);
        Versement v=new Versement(new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);
    }

    @Override
    public void retirer(String codeCpte, double montant) {

        Compte cp = consulterCompte(codeCpte);
        double facilitesCaisse=0;
        if(cp instanceof CompteCourant)
            facilitesCaisse=((CompteCourant) cp).getDecouvert();

        if(cp.getSolde()+facilitesCaisse<montant)
            throw new RuntimeException("Solde insufisant");
        Retrait r=new Retrait(new Date(),montant,cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);

    }

    @Override
    public void virement(String codeCpte1, String codeCpte, double montant) {
        if(codeCpte.equals(codeCpte1))
           throw new RuntimeException("Impossible d'effectuer le virement sur le meme compte");
        retirer(codeCpte1,montant);
        verser(codeCpte,montant);
    }

    public Page<Operation> listOperation(String codeCpte,int page,int size){
        return operationRepository.listOperation(codeCpte,PageRequest.of(page,size));
    }


}
