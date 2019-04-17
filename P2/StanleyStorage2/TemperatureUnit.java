/** a temperature-controlled unit */
public class TemperatureUnit extends Unit {

    /** the temperature of this unit */    
    private int temperature;

    /**
     * constructor for humidity unit
     *
     * @param length      the length of this unit, multiple of 4, greater than 0
     * @param width       the width of this unit, multiple of 4, greater than 0
     * @param height      the height of this unit, multiple of 2, greater than 0
     * @param location    the location of this unit
     * @param temperature the temperature for this unit
     */
    public TemperatureUnit(int length, int width, int height, Location location, int temperature) {
        super(length, width, height, location);
        validateTemperature(temperature);
        this.temperature = temperature;
    }

    /**
     * validates temperature value
     *
     * @param newTemp temperature value
     */
    private void validateTemperature(int newTemp) {
        if (newTemp < getLocation().MIN_TEMPERATURE || newTemp > getLocation().MAX_TEMPERATURE) {
            throw new IllegalArgumentException("temperature must be between "
                    + getLocation().MIN_TEMPERATURE + " and " + getLocation().MAX_TEMPERATURE);
        }
    }

    /**
     * calculates the price for this unit
     *
     * @return the monthly rate for this unit
     */
    public double getPrice() {
        return getLocation().getBasePrice() + (getLocation().getTemperatureCubedPrice() * getLength() * getWidth() * getHeight());
    }

    /**
     * gets the temperature value
     *
     * @return the temperature value for this unit
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * sets the humidity value
     *
     * @param temperature the desired humidity for this unit
     */
    public void setTemperature(int temperature) {
        validateTemperature(temperature);
        this.temperature = temperature;
    }
}
