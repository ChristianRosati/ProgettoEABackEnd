package com.example.progettoprova.controller;

import com.example.progettoprova.config.i18n.MessageLang;
import com.example.progettoprova.dto.ProdottoDto;
import com.example.progettoprova.dto.RecensioneDto;
import com.example.progettoprova.dto.UtenteDto;
import com.example.progettoprova.services.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/utente-api/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteService utenteService;

    @GetMapping("utenti")//ok
    public ResponseEntity<List<UtenteDto>> dammiUtenti(){
        return ResponseEntity.ok(utenteService.dammiUtenti());
    }


    @GetMapping("utenti/{idUtente}")
    public ResponseEntity<UtenteDto> dammiUtente(@PathVariable Long idUtente){
        return ResponseEntity.ok(utenteService.dammiUtente(idUtente));
    }


    @PutMapping("utenti/{idUtente}")
    public ResponseEntity<UtenteDto> aggiorna(@PathVariable("idUtente") Long id, @RequestBody UtenteDto utente) {
        return ResponseEntity.ok(utenteService.aggiorna(id, utente));
    }

    @DeleteMapping("utenti/{idUtente}")
    public HttpStatus cancella(@PathVariable("idUtente") Long id){
        utenteService.cancella(id);
        return HttpStatus.OK;
    }

    @GetMapping("utenti/{idUtente}/recensioni")
    public ResponseEntity<List<RecensioneDto>> dammiRecensioniUtente(@PathVariable("idUtente") Long id){
        return ResponseEntity.ok(utenteService.dammiRecensioniUtente(id));
    }


    @GetMapping("utenti/{idUtente}/prodotti")//ok
    public ResponseEntity<List<ProdottoDto>> dammiProdottiVenditore(@PathVariable("idUtente") Long idUtente){
        return ResponseEntity.ok(utenteService.dammiProdottiUtente(idUtente));
    }



//    non riesce ad prendere requestHeader?
//    private final MessageLang messageLang;
//    @GetMapping("/test-lang")
//    public ResponseEntity<String> testLang(@RequestHeader(name = "Accept-Language", required = false) final Locale locale) {
//        System.out.println("Valore di Locale "+locale);
//        return ResponseEntity.ok(messageLang.getMessage("welcome"));
//    }

    @PostMapping("/salva")
    public HttpStatus salva(@RequestBody UtenteDto u){
        utenteService.salvaDto(u);
        return HttpStatus.OK;
    }




}
