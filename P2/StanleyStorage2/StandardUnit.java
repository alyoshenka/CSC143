/** a standard storage unit */
public class StandardUnit extends Unit {

    /**
     * constructor for standard unit
     *
     * @param length the length of this unit, multiple of 4, greater than 0
     * @param width the width of this unit, multiple of 4, greater than 0
     * @param height the height of this unit, multiple of 2, greater than 0
     * @param location the location of this unit
     */
    public StandardUnit(int width, int length, int height, Location location){
        super(width, length, height, location);
    }

    /**
     * calculates and returns the price of the unit
     *
     * @return the monthly price of the unit
     */
    public double getPrice(){
        return getLocation().getBasePrice() + getLocation().standardFlatRate();
    }

}
