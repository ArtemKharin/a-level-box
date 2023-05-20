package ua.kharin.jadv.io;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static ua.kharin.jadv.io.ByteUtils.readFromFile;
import static ua.kharin.jadv.io.ByteUtils.writeToFile;

class ByteUtilsTest {
    private byte[] emptyArray = new byte[0];
    private byte[] unsorted = new byte[]{5, 3, 1, 4, 2};

    @Test
    void sortByteArrayTest() {
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, ByteUtils.sortByteArray(unsorted));
    }

    @Test
    void sortByteArrayEmptyTest() {
        assertArrayEquals(emptyArray, ByteUtils.sortByteArray(emptyArray));
    }

    @Test
    void readFromFileTest() throws IOException {
        File tempFile = File.createTempFile("test", "txt");
        try (OutputStream os = new FileOutputStream(tempFile)) {
            os.write(unsorted);
        }

        assertArrayEquals(unsorted, readFromFile(tempFile));
    }

    @Test
    void writeToFileTest() throws IOException {
        File tempFile = File.createTempFile("test", "txt");
        writeToFile(tempFile, unsorted);

        try (InputStream is = new FileInputStream(tempFile)) {
            assertArrayEquals(unsorted, is.readAllBytes());
        }
    }
}