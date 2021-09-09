package com.mycompany.bank.entity;

import jdk.jfr.Enabled;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("R")   //l'enregistrement d'une instance de Retrait attribue la valeur "R" � la colonne "TYPE_OP" dans la table "Operation"
public class Retrait extends Operation{
    public Retrait() {
        super();
    }

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
