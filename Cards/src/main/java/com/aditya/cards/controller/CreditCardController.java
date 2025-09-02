package com.aditya.cards.controller;

import com.aditya.cards.model.dto.CardConfig;
import com.aditya.cards.model.dto.CreditCardDTO;
import com.aditya.cards.model.entity.CreditCard;
import com.aditya.cards.service.CreditCardService;
import com.aditya.cards.service.assembler.CreditCardAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CreditCardAssembler creditCardAssembler;

    @Autowired
    private CardConfig cardConfig;

    @GetMapping
    public ResponseEntity<List<CreditCardDTO>> listCards() {
        List<CreditCardDTO> res = creditCardService.listAll().stream()
                .map(creditCardAssembler::fromDomainObject)
                .collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<CreditCardDTO> createCard(@RequestBody CreditCardDTO req) {
        CreditCard card = creditCardAssembler.toDomainObject(req);
        CreditCard saved = creditCardService.create(card);
        return ResponseEntity.ok(creditCardAssembler.fromDomainObject(saved));
    }
    @GetMapping("/config")
    public ResponseEntity<CardConfig> getConfiguration()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(cardConfig);
    }
}
