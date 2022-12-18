package ua.kharin.jadv.clone.method;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department implements Cloneable{
    private int id;
    private String name;

    @Override
    public Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
    }
}
