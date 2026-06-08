package com.isabelle.crud.eligibility;

import com.isabelle.crud.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EligibilityService {
    //todo: Usar lista (ArrayList) no lugar de set<String>
    private static final Set<String> ALLOWED_MCCS = Set.of(
            "742",
            "1799",
            "4121",
            "5499",
            "5697",
            "5963",
            "7230",
            "7538",
            "8011",
            "8021",
            "8099",
            "8111",
            "8999"
    );

    public boolean isEligible(Customer customer) {

        if (!"PF".equals(customer.getIndicationDocumentType())) {
            return false;
        }

        if (customer.getCustomerCompanyFlag()) {
            return false;
        }

        if (!ALLOWED_MCCS.contains(customer.getMcc())) {
            return false;
        }
        //todo: Criar uma outra classe service de verificação de mcc (I.D)
        //todo: método for pra fazer a verificação de mcc válido

        if (customer.getAnnualTpv().doubleValue() > 30000) {
            return false;
        }

        return true;
    }

}