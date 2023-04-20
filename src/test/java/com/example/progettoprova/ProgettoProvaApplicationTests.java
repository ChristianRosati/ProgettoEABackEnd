package com.example.progettoprova;

import com.example.progettoprova.conf.CacheConfig;
import com.example.progettoprova.dao.AnnuncioDao;
import com.example.progettoprova.dao.ImageDao;
import com.example.progettoprova.dao.RecensioneDao;
import com.example.progettoprova.dao.UtenteDao;
import com.example.progettoprova.entities.*;
import com.example.progettoprova.services.ServiceProva;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProgettoProvaApplicationTests {

    @Autowired
    AnnuncioDao annuncioDao;
    @Autowired
    UtenteDao utenteDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    RecensioneDao recensioneDao;




    @Test
    void contextLoads() throws IOException {

        Prodotto p1=new Prodotto();
        p1.setType("Scarpe");
        p1.setColor("Rosso");
        p1.setPrice(150);





        Utente u1=new Utente();
        u1.setFirstName("Paperino");
        u1.setLastName("Bianchi");
        utenteDao.save(u1);

        Utente u2=new Utente();
        u2.setFirstName("Archimede");
        u2.setLastName("Rossi");
        utenteDao.save(u2);

        Recensione r=new Recensione();
        r.setUtente(u1);
        recensioneDao.save(r);

        Recensione r2=new Recensione();
        r2.setUtente(u1);
        recensioneDao.save(r2);


        Annuncio a1=new Annuncio();
        a1.setTitolo("Scarpe Fantastici");
        a1.setUtente(u1);
        a1.setProdotto(p1);
        annuncioDao.save(a1);

        byte[] immagine= Files.readAllBytes(Path.of("src/main/resources/img/Cattura.PNG"));
        Image i=new Image();
        i.setAnnuncio(a1);
        i.setImage(immagine);
        imageDao.save(i);

        Image i2=new Image();
        i2.setAnnuncio(a1);
        i2.setImage(immagine);
        imageDao.save(i2);



        //recensioneDao.delete(r);

//
//        annuncioDao.delete(annuncioDao.findById(1L).get());
//        utenteDao.delete(utenteDao.findById(1L).get());
//        recensioneDao.delete(recensioneDao.findById(1L).get());
//        imageDao.delete(i);


//        System.out.println("Tutte Le Recensioni"+recensioneDao.findAll());
//        System.out.println("Tutte gli Utenti"+utenteDao.findAll());
        System.out.println("Tutte gli Annunci"+annuncioDao.findAll());
//        System.out.println("Lista Immagini: "+imageDao.findAll());
//        System.out.println("TUTTI UTENTI: "+utenteDao.findAll());
//        System.out.println("TUTTE LE RECENSIONI: "+recensioneDao.findAll());

//        modo corretto per ritornare lista annuncio chiamare query
//        Optional<Utente> recuperoUtente=utenteDao.findById(1L);
//        System.out.println(recuperoUtente.get().getFirstName());
//        System.out.println(utenteDao.ciccio2(1L));


        /**Sorted */
//        System.out.println(utenteDao.findAll(Sort.by("firstName").descending()));
//          decrescente in base al nome, con nomi uguali crescente in base cognome
//        System.out.println(utenteDao.findAll(Sort.by("firstName").descending().and(Sort.by("lastName").ascending())));
//          ordina in base ad un array, sorted3 in serviceProva
//        System.out.println(new ServiceProva().getAllSorted3("firstName","ASC","lastName","ASC",utenteDao));
        /**Paginazione */
//          oggetto page devi chiamare il getContent per stampare
//        System.out.println(new ServiceProva().getPaged(3,utenteDao).getContent());










    }

}
