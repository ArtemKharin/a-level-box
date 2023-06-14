package ua.kharin.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String title;
    private String description;
    private BigDecimal price;
    private Timestamp lastModified;

    public Goods(String title, String description, BigDecimal price, Timestamp lastModified) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.lastModified = lastModified;
    }
}
