package ua.kharin.jadv.clone.serialization;

import lombok.SneakyThrows;

import java.io.*;

public class Box implements Cloneable, Serializable {
    @SneakyThrows
    @Override
    protected Box clone() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Box) ois.readObject();
    }
}
