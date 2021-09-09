package com.mycompany.bank.web;

import com.mycompany.bank.entity.Compte;
import com.mycompany.bank.entity.Operation;
import com.mycompany.bank.entity.Retrait;
import com.mycompany.bank.service.InterfaceBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BanqueController {
    @Autowired
    private InterfaceBanqueService interfaceBanqueService;

    @RequestMapping("/operations")
    public String index(){

        return "comptes";
    }
    @RequestMapping("/consulterCompte")
    public String consulter(Model model, String codeCompte){
        model.addAttribute("codeCompte",codeCompte);
        try{
            Compte cp=interfaceBanqueService.consulterCompte(codeCompte);
            Page<Operation> pageOperations=interfaceBanqueService.listOperation(codeCompte,0,4);
            model.addAttribute("listOperations",pageOperations.getContent()); //pageOperation.getCpntent permet de retourner la liste des op
            model.addAttribute("compte",cp);
        } catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "comptes";
    }

    @RequestMapping(value = "/saveOperation",method= RequestMethod.POST)
    public String saveOperation(Model model,String typeOperation,String codeCompte,double montant,String codeCompte2){
       try {
           if (typeOperation.equals("VERS")) {
               interfaceBanqueService.verser(codeCompte, montant);
           } else if (typeOperation.equals("RETR")) {
               interfaceBanqueService.retirer(codeCompte, montant);
           } else {
               interfaceBanqueService.virement(codeCompte, codeCompte2, montant);
           }
       }catch (Exception e){
           model.addAttribute("error",e);
           return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
       }
        return "redirect:/consulterCompte?codeCompte="+codeCompte;
    }
}
