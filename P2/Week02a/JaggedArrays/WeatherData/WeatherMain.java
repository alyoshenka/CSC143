import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WeatherMain {

    public static void main(String[] args) throws FileNotFoundException {

        // Create a jagged array for 2016 weather data
        WeatherData[][] wd2016 = new WeatherData[12][];
        // Create each month's subarray, with appropriate number of days
        wd2016[0] = new WeatherData[31];
        wd2016[1] = new WeatherData[29];
        wd2016[2] = new WeatherData[31];
        wd2016[3] = new WeatherData[30];
        wd2016[4] = new WeatherData[31];
        wd2016[5] = new WeatherData[30];
        wd2016[6] = new WeatherData[31];
        wd2016[7] = new WeatherData[31];
        wd2016[8] = new WeatherData[30];
        wd2016[9] = new WeatherData[31];
        wd2016[10] = new WeatherData[30];
        wd2016[11] = new WeatherData[31];

        // Prepare to read the file
        Scanner fileIn = new Scanner(new File("WeatherData2016.txt"));

        // Skip headings
        fileIn.nextLine();  
        fileIn.nextLine();  

        while (fileIn.hasNext()) {
            String lineIn = fileIn.nextLine();
            String[] lineParts = lineIn.split("@");

            // Create new object and fill it in
            WeatherData wdTemp = new WeatherData();

            wdTemp.month            = Integer.parseInt(lineParts[0]);
            wdTemp.day              = Integer.parseInt(lineParts[1]);
            wdTemp.tempHigh         = Integer.parseInt(lineParts[2]);
            wdTemp.tempAvg          = Integer.parseInt(lineParts[3]);
            wdTemp.tempLow          = Integer.parseInt(lineParts[4]);
            wdTemp.dewPointHigh     = Integer.parseInt(lineParts[5]);
            wdTemp.dewPointAvg      = Integer.parseInt(lineParts[6]);
            wdTemp.dewPointLow      = Integer.parseInt(lineParts[7]);
            wdTemp.humidityHigh     = Integer.parseInt(lineParts[8]);
            wdTemp.humidityAvg      = Integer.parseInt(lineParts[9]);
            wdTemp.humidityLow      = Integer.parseInt(lineParts[10]);
            wdTemp.pressHigh        = Double.parseDouble(lineParts[11]);
            wdTemp.pressAvg         = Double.parseDouble(lineParts[12]);
            wdTemp.pressLow         = Double.parseDouble(lineParts[13]);
            wdTemp.visibilityHigh   = Integer.parseInt(lineParts[14]);
            wdTemp.visibilityAvg    = Integer.parseInt(lineParts[15]);
            wdTemp.visibilityLow    = Integer.parseInt(lineParts[16]);
            wdTemp.windHigh         = Integer.parseInt(lineParts[17]);
            wdTemp.windAvg          = Integer.parseInt(lineParts[18]);
            wdTemp.precip           = Double.parseDouble(lineParts[19]);
            wdTemp.events           = lineParts[20];

            wd2016[wdTemp.month - 1][wdTemp.day - 1] = wdTemp;
        }
        
        // Display all the data
        // System.out.println("WEATHER DATA FOR 2016\n");
        // for (int monthIdx = 0; monthIdx < wd2016.length; monthIdx++) {
            // for (int dayIdx = 0; dayIdx < wd2016[monthIdx].length; dayIdx++) {
                // System.out.print(wd2016[monthIdx][dayIdx]);
            // }
            // System.out.println();
        // }
        
        for (WeatherData[] month : wd2016) {
            for (WeatherData day : month) {
                System.out.print(day);
            }
            System.out.println();
        }

    }
}
