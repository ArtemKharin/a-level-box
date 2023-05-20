package ua.kharin.jadv.io;

import java.io.*;
import java.util.Arrays;

public class ByteUtils {
    public static void main(String[] args) {
        byte[] unsorted = readFromFile(new File("input.txt"));
        byte[] sorted = sortByteArray(unsorted);
        writeToFile(new File("result.txt"), sorted);
    }

    public static byte[] sortByteArray(byte[] input) {
        byte[] sorted = Arrays.copyOf(input, input.length);
        Arrays.sort(sorted);
        return sorted;
    }

    public static byte[] readFromFile(File file) {
        if (file.exists()) {
            try (InputStream is = new FileInputStream(file)) {
                return is.readAllBytes();
            } catch (FileNotFoundException e) {
                System.err.println("File was not found " + e);
            } catch (IOException e) {
                System.err.println("Exception during reading from file " + e);
            }
        }
        return new byte[0];
    }

    public static void writeToFile(File file, byte[] content) {
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(content);
        } catch (FileNotFoundException e) {
            System.err.println("File was not found " + e);
        } catch (IOException e) {
            System.err.println("Exception during reading from file " + e);
        }
    }
}
