package utils;

import java.io.*;

/**
 * Created by Povilas on 2015.10.10.
 */
public class FileHelper {
    public void readFromFile(String pathWIthFileName, CustomCaller caller) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(pathWIthFileName).getFile());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        caller.read(bufferedReader);
        fileReader.close();
    }


    public void writeToFile(String pathWIthFileName, CustomCaller caller) throws Exception {
        File file = new File("resources/" + pathWIthFileName);
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        caller.write(bufferedWriter);
        writer.close();
    }


}
