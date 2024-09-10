package com.example.exercicio07;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;



@SpringBootApplication
@RestController
public class Exercicio07ApplicationTests {

	@GetMapping("/")
	public String nomezinnhos(@RequestParam String firstname, @RequestParam String secondName) throws Exception {
		while(true) {
			String[] vetorElementos = new String[4];
			vetorElementos[0] = "Agua";
			vetorElementos[1] = "Fogo";
			vetorElementos[2] = "Ar";
			vetorElementos[3] = "Terra";
			if(firstname == "") return "";
			Random geradorAleatorio = new Random();
			Integer numeroAleatorio = geradorAleatorio.nextInt();
			Integer indiceAleatorio = geradorAleatorio.nextInt(4);
			String elemento = vetorElementos[indiceAleatorio];

			System.out.println(elemento + firstname + secondName + numeroAleatorio);
		}
	}
}







