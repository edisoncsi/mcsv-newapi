package eco.com.spring.mcsv.newapi.controllers;

import eco.com.spring.mcsv.newapi.model.SimilarProducts;
import eco.com.spring.mcsv.newapi.services.NewApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class NewApiController {

   @Autowired
    private NewApiService newApiService;

    @GetMapping("/{id}/similar")
    public ResponseEntity<?> listar(@PathVariable @NotEmpty  String id) {
        Map<String, String> errors = new HashMap<>();

        if(id.isEmpty() || id.isBlank()){
            errors.put(id, "El parámetro ID es obligatiorio");
            return ResponseEntity.badRequest().body(errors);
        }

        if(Integer.parseInt(id)< 0){
            errors.put(id, "El parámetro ID debe ser positivo");
            return ResponseEntity.badRequest().body(errors);
        }

        SimilarProducts similarProducts = newApiService.productDetails(id);
        if(similarProducts.size()==0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(similarProducts);
    }
}
