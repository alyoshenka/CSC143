public class WeatherData {

    public int     month;
    public int     day;
    public int     tempHigh;
    public int     tempAvg;
    public int     tempLow;
    public int     dewPointHigh;
    public int     dewPointAvg;
    public int     dewPointLow;
    public int     humidityHigh;
    public int     humidityAvg;
    public int     humidityLow;
    public double  pressHigh;
    public double  pressAvg;
    public double  pressLow;
    public int     visibilityHigh;
    public int     visibilityAvg;
    public int     visibilityLow;
    public int     windHigh;
    public int     windAvg;
    public double  precip;
    public String  events;

    public String toString() {
        return month + "/" + day + ", " + "precip = " + precip + "\n";
    }
}
