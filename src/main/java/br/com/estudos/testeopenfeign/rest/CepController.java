package br.com.estudos.testeopenfeign.rest;

import br.com.estudos.testeopenfeign.config.AppConstantes;
import br.com.estudos.testeopenfeign.dto.CepDTO;
import br.com.estudos.testeopenfeign.feign.CepClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CepController {

    @Autowired
    CepClient cepClient;

    @GetMapping(path = "/buscar/{cep}")
    public ResponseEntity<CepDTO> buscarCep(@PathVariable("cep") String cep) {
        if (!isCepValido(cep)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cep inválido.");
        }

        return ResponseEntity.ok().body(cepClient.getCepInfo(cep));
    }

    private static boolean isCepValido(String cep) {
        return StringUtils.isNumeric(cep) && cep.length() == AppConstantes.TAMANHO_CEP;
    }

}
