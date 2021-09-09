package com.mycompany.bank.entity;

import jdk.jfr.Enabled;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
//puisque cette classe h�rite de la classe 'Compte' et que que la creation d'un compte �pargne attribut � la colonne "TYPE_CPTE" de la table "Compte" la valeur "CE" --> alors l'annotation sera la suivante :
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{

    private double taux;

    public CompteEpargne(){
        super();
    }

    public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
        super(codeCompte, dateCreation, solde, client);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
