package ua.kharin.jadv.io;

import java.io.File;

public class FileUtils {
    public static void main(String[] args) {
        printAllFileNames(new File("D:\\a-level\\projects\\a-level-box"));
    }

    public static void printAllFileNames(File directory) {
        if (!directory.exists() || directory.isFile()) {
            return;
        }
        for (File subFile : getListFiles(directory)) {
            if (subFile.isFile()) {
                System.out.println(subFile.getAbsolutePath());
            } else {
                printAllFileNames(subFile);
            }
        }
    }

    private static File[] getListFiles(File file) {
        File[] result = file.listFiles();
        return result == null ? new File[0] : result;
    }
}
