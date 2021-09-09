package com.mycompany.bank.repository;

import com.mycompany.bank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
//utilisation de spring data
//cette interface permet de gérer l'entite client
public interface ClientRepository extends JpaRepository<Client,Long> {    //interface JPA/repository (utilisation de spring data necessite la creation de l'interface jpaRepository)  ---- le Id de Client est de type long

}


