package com.mycompany.bank.service;

import com.mycompany.bank.entity.Compte;
import com.mycompany.bank.entity.Operation;
import org.springframework.data.domain.Page;

public interface InterfaceBanqueService {

    public Compte consulterCompte(String codeCpte);
    public void verser(String codeCpte,double montant);
    public void retirer(String codeCpte, double montant);
    public void virement(String codeCpte1, String codeCpte, double montant);
    public Page<Operation> listOperation(String codeCpte,int page,int size);
}
