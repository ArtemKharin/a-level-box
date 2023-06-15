package ua.kharin.jadv.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "goods")
public class Goods {
    @Id
    @Column(name = "goods_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Goods(BigDecimal price, String title, String category) {
        this.price = price;
        this.title = title;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
