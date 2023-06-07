package eco.com.spring.mcsv.newapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductDetail {
    @JsonProperty(value = "id", required = true)
    @Size(min=1)
    private String id = null;

    @JsonProperty(value = "name", required = true)
    private String name = null;

    @JsonProperty(value = "price", required = true)
    private BigDecimal price = null;

    @JsonProperty(value = "availability", required = true)
    private Boolean availability = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
