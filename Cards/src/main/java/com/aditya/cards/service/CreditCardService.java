package com.aditya.cards.service;

import com.aditya.cards.model.entity.CreditCard;
import com.aditya.cards.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> listAll() {
        return creditCardRepository.findAll();
    }

    public CreditCard create(CreditCard card) {
        if (card.getCardNumber() == null || card.getCardNumber().isBlank()) {
            throw new IllegalArgumentException("cardNumber must be provided");
        }
        return creditCardRepository.save(card);
    }
}