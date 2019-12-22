package org.example;

import java.io.*;
import java.util.ArrayList;


public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        Hobby hobby1 = new Hobby("Reading", 5, false);
        Hobby hobby2 = new Hobby("Play football", 3, true);
        Hobby hobby3 = new Hobby("Fishning", 7, true);

        ArrayList<Hobby> arrayList = new ArrayList<>();
        arrayList.add(hobby1);
        arrayList.add(hobby2);
        arrayList.add(hobby3);

        File file = new File(".\\src\\main\\java\\org\\example\\input.bin");
        file.createNewFile();
        if(!file.exists()){
            file.createNewFile();
        }
        File dir = new File(".\\src\\main\\java\\org\\example\\copy");
        dir.mkdir();

        File fileCopy = new File(".\\src\\main\\java\\org\\example\\copy\\output.bin");
        if(!fileCopy.exists()){
            fileCopy.createNewFile();
        }


        try (InputStream is = new FileInputStream(file); OutputStream os = new FileOutputStream(fileCopy)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(arrayList);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileCopy));
        ArrayList<Hobby> newArrayList = (ArrayList<Hobby>) objectInputStream.readObject();
        System.out.println(newArrayList);

    }
}
