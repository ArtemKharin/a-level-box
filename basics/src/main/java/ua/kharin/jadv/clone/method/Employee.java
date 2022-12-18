package ua.kharin.jadv.clone.method;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements Cloneable {
    private int employeeId;
    private String name;
    private Department department;

    @Override
    public Employee clone() {
        try {
            Employee clone = (Employee) super.clone();
            clone.setDepartment(clone.getDepartment().clone());
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
