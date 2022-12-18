package ua.kharin.single;

import lombok.Data;

@Data
public class Order {
    private String customerName;
    private String customerEmail;
    private boolean isValid;
}
