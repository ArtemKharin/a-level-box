package ua.kharin.jadv.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Client {
    private Long clientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private boolean registered;

    public Client(String firstName, String lastName, Date dateOfBirth, boolean registered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.registered = registered;
    }
}
