package com.mycompany.bank.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*; //importer pour la persistance (pour pouvoir utiliser les annotations des entity)

//les annotations JPA sont : @Entity , @Table, @Id, @GeneratedValue , @Inheritance ,@ManyToOne , @ManyToMany , ....

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue         //�ad code g�n�rer automatiquement
    private Long code;       //c'est l'identifiant de la table et qui est g�n�rer automatiquement
    private String nom;
    private String email;
    @OneToMany(mappedBy="client",fetch= FetchType.LAZY)     // "client" est attribut $ d'association $ de la classe Compte (association entre la classe Client et Compte )
    private Collection<Compte> comptes;

    public Client() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
}
