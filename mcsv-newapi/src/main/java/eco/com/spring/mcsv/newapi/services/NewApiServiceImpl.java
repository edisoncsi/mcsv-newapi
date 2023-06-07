package eco.com.spring.mcsv.newapi.services;

import eco.com.spring.mcsv.newapi.model.ProductDetail;
import eco.com.spring.mcsv.newapi.model.SimilarProducts;
import eco.com.spring.mcsv.newapi.util.FeignServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class NewApiServiceImpl implements  NewApiService{

    Logger logger = LoggerFactory.getLogger(NewApiServiceImpl.class);
    @Autowired
    private FeignServiceUtil client;

    @Override
    public SimilarProducts productDetails(String id) {

        SimilarProducts sp = new SimilarProducts();

        Consumer<String> consumerDetail = new Consumer<String>() {
            @Override
            public void accept(String t) {
                try{
                    ProductDetail products = client.detalleProducto(t);
                    sp.add(products);
                }catch (Exception e){
                    logger.error("Product ID: " + t +" - " + e.getCause().toString());
                }
            }
        };

        try{
            List<String> listSimilarIds = client.obtenerlistSimilarIds(id);
            if (listSimilarIds.size()!=0) {
                listSimilarIds.stream().forEach(consumerDetail);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return sp;
    }
}
