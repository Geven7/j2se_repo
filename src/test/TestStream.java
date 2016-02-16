package test;

import java.io.FileInputStream;

public class TestStream {

    public static void main(String[] args) throws Exception {
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

        FileInputStream fileInputStream = new FileInputStream(filename_a);
    }
}
