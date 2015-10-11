package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Povilas on 2015.10.10.
 */
public interface CustomCaller {

    public void read(BufferedReader bufferedReader) throws IOException;

    public void write(BufferedWriter bufferedWriter) throws IOException;
}
