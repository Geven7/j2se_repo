package test;

import java.io.File;
import java.io.FileNotFoundException;

public class TestOperationFile {

    public static void createFile() {
        String fileName = "D:" + File.separator + "hello.txt";
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        String fileName = "D:" + File.separator + "hello.txt";
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
            System.out.println("success delete file!");
        } else {
            System.out.println("file not exists!");
        }
    }

    public static void listFileName() {
        String fileName = "D:" + File.separator;
        File file = new File(fileName);
        String[] list = file.list();
        for (int i = 0, length = list.length; i < length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void listFileNameByPath() {
        String fileName = "D:" + File.separator;
        File file = new File(fileName);
        File[] list = file.listFiles();
        for (int i = 0, length = list.length; i < length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void checkDirectory() {
        String fileName = "D:" + File.separator;
        File file = new File(fileName);
        if (file.isDirectory()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void printFilePath(File f) {
        File[] list = f.listFiles();
        for (int i = 0, length = list.length; i < length; i++) {
            File tempFile = list[i];
            if (tempFile.isDirectory()) {
                printFilePath(tempFile);
            } else {
                System.out.println(tempFile);
            }
        }
    }

    public static void copyFileContent() throws FileNotFoundException {
        String filename_a = "c:\\temp\\a.txt";
        String filename_b = "c:\\temp\\b.txt";
        String charset = "UTF-8";

        // BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename_a), charset));
        // String result = "";
        // String temp = "";
        // while ((temp = reader.readLine()) != null) {
        // System.out.println(temp);
        // result += (temp + "\r");
        // }
        // reader.close();
        //
        // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filename_b)), charset));
        // writer.write(result);
        // writer.close();

        // FileReader fileReader = new FileReader(filename_a);
        // FileWriter fileWriter = new FileWriter(filename_b);
        // char[] cbuf = new char[10];
        // while ((fileReader.read(cbuf)) != -1) {
        // System.out.println(cbuf);
        // fileWriter.write(cbuf);
        // }
        // fileReader.close();
        // fileWriter.close();
        // FileInputStream fileInputStream = new FileInputStream(filename_a);
    }

    public static void main(String[] args) {
        // createFile();
        // deleteFile();
        // listFileName();
        // listFileNameByPath();
        // checkDirectory();
        // printFilePath(new File("D:" + File.separator));
    }
}
