package com.example.exercicio07;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;



@RestController
@RequestMapping("/")
public class controller {

    @GetMapping("nomes")
    public String nomezinnhos(@RequestParam String primeironome, @RequestParam String segundonome) throws Exception {

            String[] vetorElementos = new String[4];
            vetorElementos[0] = "Agua";
            vetorElementos[1] = "Fogo";
            vetorElementos[2] = "Ar";
            vetorElementos[3] = "Terra";
            if(primeironome == "") return "";
            Random geradorAleatorio = new Random();
            Integer numeroAleatorio = geradorAleatorio.nextInt();
            Integer indiceAleatorio = geradorAleatorio.nextInt(4);
            String elemento = vetorElementos[indiceAleatorio];

            System.out.println(elemento +""+ segundonome +""+ segundonome +""+ numeroAleatorio);
            return null;
    }
}







