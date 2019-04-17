/** a humidity-controlled unit */
public class HumidityUnit extends Unit{

    /** the humidity of this unit */
    private int humidity;

    /**
     * constructor for humidity unit
     *
     * @param length the length of this unit, multiple of 4, greater than 0
     * @param width the width of this unit, multiple of 4, greater than 0
     * @param height the height of this unit, multiple of 2, greater than 0
     * @param location the location of this unit
     * @param humidity the humidity for this unit
     */
    public HumidityUnit(int length, int width, int height, Location location, int humidity){
        super(length, width, height, location);
        
        if(location == null){        
            throw new IllegalArgumentException("Location must not be null");
        }
        
        validateHumidity(humidity);
        this.humidity = humidity;
    }

    /**
     * validates humidity value
     *
     * @param newHumidity humidity value
     */
    private void validateHumidity(int newHumidity){
        
        if(new Integer(newHumidity) == null || newHumidity < getLocation().MIN_HUMIDITY || newHumidity > getLocation().MAX_HUMIDITY){
            throw new IllegalArgumentException("humidity must be between "
                    + getLocation().MIN_HUMIDITY + " and " + getLocation().MAX_HUMIDITY);
        }
    }

    /**
     * calculates the price for this unit
     *
     * @return the monthly rate for this unit
     */
    public double getPrice(){
        return getLocation().getBasePrice() + (getLocation().getHumditySquaredPrice() * getLength() * getWidth());    }

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