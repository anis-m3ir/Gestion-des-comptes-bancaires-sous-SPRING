package com.mycompany.bank.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
//Puisque je n'utiliserai pas l'annotation @Table --> la table dans la base de donn�e (l'entity) sera cr�er avec le nom de la classe $qui est Compte$( et c'est la valeur par defaut)
// @Table(name="compte") : on ne va pas utiliser cette annotation (car on a h�ritage) --> un compte peut etre un compte courant ou un compte epargne
// En plus , on va metre tous les comptes (courants et �pargne) dans la meme table -->  d'o� l'annotation suivante :
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable {

    //attributs normales
    @Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;

    //attributs d'association
    @ManyToOne          //donc on aura une clé etrangère qui est client (jointure)
    @JoinColumn(name = "CODE_CLI")
    private Client client;
    @OneToMany(mappedBy = "compte") //association � travers
    private Collection<Operation> operations;   //un compte peut subir plusieurs operations

    public Compte(String codeCompte, Date dateCreation, double solde, Client client) {
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }

    public String getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte(String codeCompte) {
        this.codeCompte = codeCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

    public Compte() {
    }
}
