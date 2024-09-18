package com.example.exercicio08.Controllers;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/fipe")
public class fipe {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public ResponseEntity<Map<String, Object>> fipe(@PathVariable("marca") Integer marca,
                                                    @PathVariable("modelo") Integer modelo,
                                                    @PathVariable("ano") String ano) {

        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/"+ marca + "/modelos/"+ modelo +"/anos/"+ ano;

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Map.class);
        return ResponseEntity.ok(response.getBody());
    }


}
