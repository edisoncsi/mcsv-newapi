package eco.com.spring.mcsv.newapi.errors;

import eco.com.spring.mcsv.newapi.exception.BadRequestException;
import eco.com.spring.mcsv.newapi.exception.InternalServerException;
import eco.com.spring.mcsv.newapi.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
            case 400:
                return new BadRequestException("Bad request ! ");
            case 404:
                return new NotFoundException("Not found !");
            case 500:
                return new InternalServerException("Internal Server !");
            default:
                return new Exception("Generic error");
        }
    }
}