package br.com.estudos.testeopenfeign.feign;

import br.com.estudos.testeopenfeign.config.AppConstantes;
import br.com.estudos.testeopenfeign.dto.CepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep-client", url = AppConstantes.VIACEP_BASE_URL)
public interface CepClient {
    
    @GetMapping(value = "/{cep}/" + AppConstantes.VIACEP_FORMATO_JSON, produces = "application/json")
    CepDTO getCepInfo(@PathVariable("cep") String cep);
    
}
