package eco.com.spring.mcsv.newapi.util;


import eco.com.spring.mcsv.newapi.config.FeignConfig;
import eco.com.spring.mcsv.newapi.errors.CustomErrorDecoder;
import eco.com.spring.mcsv.newapi.model.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "feignDemo", url = "http://localhost:3001/product",
        configuration = { FeignConfig.class, CustomErrorDecoder.class })
public interface FeignServiceUtil {

    @GetMapping("/{id}")
    ProductDetail detalleProducto(@PathVariable String id);

    @GetMapping("/{id}/similarids")
    List<String> obtenerlistSimilarIds(@PathVariable String id);
}
