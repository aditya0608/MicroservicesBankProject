package com.aditya.cards.service.assembler;

import com.aditya.cards.model.dto.CreditCardDTO;
import com.aditya.cards.model.entity.CreditCard;
import org.springframework.stereotype.Component;


@Component
public class CreditCardAssembler {

    public CreditCard toDomainObject(CreditCardDTO req) {
        if (req == null) return null;
        CreditCard entity = new CreditCard();
        entity.setCardNumber(req.cardNumber());
        entity.setAccountId(req.accountId());
        entity.setCardStatus(req.cardStatus());
        entity.setCardOwnerName(req.cardOwnerName());
        entity.setBalance(req.balance());
        entity.setCurrency(req.currency());
        return entity;
    }

    public CreditCardDTO fromDomainObject(CreditCard entity) {
        if (entity == null) return null;
        return new CreditCardDTO(
                entity.getCardNumber(),
                entity.getAccountId(),
                entity.getCardStatus(),
                entity.getCardOwnerName(),
                entity.getBalance(),
                entity.getCurrency()
        );
    }
}