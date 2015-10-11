package exams2006.task2;

import utils.CustomCaller;
import utils.FileHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Povilas on 2015.10.11.
 */
public class JourneySimulator {

    public void start() throws Exception {
        FileHelper fileHelper = new FileHelper();
        JourneyCaller caller = new JourneyCaller();
        fileHelper.readFromFile("2006_2/Duom2.txt", caller);
        fileHelper.writeToFile("2006_2/Rez2.txt", caller);
    }

    public static class JourneyCaller implements CustomCaller {

        private Integer stationsCount;

        private double averageSpeed;

        private Double time;

        private Station[] stations;

        public JourneyCaller() {
            stations = new Station[100];
        }

        @Override
        public void read(BufferedReader bufferedReader) throws IOException {
            String[] data = bufferedReader.readLine().split(" ");
            stationsCount = Integer.parseInt(data[0]);
            averageSpeed = Double.parseDouble(data[1]);
            time = Double.parseDouble(data[2]) * 60 + Integer.parseInt(data[3]);

            for(int i = 0; i < stationsCount; i++) {
                String line = bufferedReader.readLine();
                stations[i] = new Station();
                stations[i].setName(line.substring(0, 15));
                stations[i].setDistance(Double.parseDouble(line.substring(15)));
            }
        }

        @Override
        public void write(BufferedWriter bufferedWriter) throws IOException {
            Station[] results = calculateResult();
            for(int i = 0; i < stationsCount; i++) {
                bufferedWriter.write(results[i].getName() + results[i].getHour() + " val. " + results[i].getMinutes() + " min.\n");
            }
            bufferedWriter.flush();
        }

        public Station[] calculateResult() {
            for(int i = 0; i < stationsCount; i++) {
                time += time(stations[i].getDistance(), averageSpeed);
                Integer hours = (int)(time / 60);
                Integer minutes = (int)(time - hours * 60);
                stations[i].setHour(hours);
                stations[i].setMinutes(minutes);
            }
            return stations;
        }

        private double time(double distance, double speed) {
            return (int)(distance / speed * 60);
        }
    }
}
