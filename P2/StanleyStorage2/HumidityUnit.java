public class HumidityUnit extends Unit{

    /** the humidity of this unit */
    private int humidity;
    /** the location of this unit */
    private Location location;

    /**
     * constructor for humidity unit
     *
     * @param length the length of this unit, multiple of 4, > 0
     * @param width the width of this unit, multiple of 4, > 0
     * @param height the height of this unit, multiple of 2, > 0
     * @param location the location of this unit
     * @param humidity the humidity for this unit
     */
    public HumidityUnit(int length, int width, int height, Location location, int humidity){
        super(length, width, height, location);
        validateHumidity(humidity);
        this.humidity = humidity;
    }

    /**
     * validates humidity value
     *
     * @param newHumidity humidity value
     */
    private void validateHumidity(int newHumidity){
        if(newHumidity < location.MIN_HUMIDITY || newHumidity > location.MAX_HUMIDITY){
            throw new IllegalArgumentException("humidity must be between "
                    + location.MIN_HUMIDITY + " and " + location.MAX_HUMIDITY);
        }
    }

    /**
     * calculates the price for this unit
     *
     * @return the monthly rate for this unit
     */
    public double getPrice(){
        return location.getBasePrice() * (location.getHumditySquaredPrice() * getLength() * getWidth());    }

    /**
     * gets the humidity value
     *
     * @return the huditity value for this unit
     */
    public int getHumidity(){
        return humidity;
    }

    /**
     * sets the humidity value
     *
     * @param humidity the desired humidity for this unit
     */
    public void setHumidity(int humidity){
        validateHumidity(humidity);
        this.humidity = humidity;
    }
}