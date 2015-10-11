package exams2006.task1;

import utils.CustomCaller;
import utils.FileHelper;

import java.io.*;

/**
 * Created by Povilas on 2015.10.09.
 */
public class ResistivitySimulator{

    public void start() throws Exception {
        FileHelper fileHelper = new FileHelper();
        ResistivityCaller caller = new ResistivityCaller();
        fileHelper.readFromFile("2006_1/Duom1.txt", caller);
        fileHelper.writeToFile("2006_1/Rez1.txt", caller);
    }

    public static class ResistivityCaller implements CustomCaller{

        private Integer[][] result;

        private Integer resistivityCount;

        public ResistivityCaller() {
            result = new Integer[100][50];
        }

        @Override
        public void read(BufferedReader bufferedReader) throws IOException {
            resistivityCount = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i < resistivityCount; i++) {
                String line = bufferedReader.readLine();
                String[] numbers = line.split(" ");
                for(int j = 0; j < Integer.parseInt(numbers[0]) + 1; j++) {
                    result[i][j] = Integer.parseInt(numbers[j]);
                }
            }
        }

        @Override
        public void write(BufferedWriter bufferedWriter) throws IOException {
            double calculatedResult  = calculateResult();
            bufferedWriter.write(String.format("%.2f", calculatedResult));
            bufferedWriter.flush();
        }

        public double calculateResult() {
            double resistanceResult = 0;
            for(int i = 0; i < resistivityCount; i++) {
                double value = 0;
                for(int j = 1; j <= result[i][0]; j++) {
                    value += ((double)1/(double)result[i][j]);
                }
                resistanceResult += ((double)1/value);
            }
            return resistanceResult;
        }
    }
}
