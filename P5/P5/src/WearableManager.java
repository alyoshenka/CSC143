public class WearableManager {
    /** all the wearables */
    private Wearable[] wearables;
    /** wearables by customer ranking */
    private BinarySearch<Integer> rankings;
    /** wearables by price */
    private BinarySearchDuplicate<String> prices;
    /** wearables by company name */
    private BinarySearchDuplicate<String> coNames;

    /**
     * gets the wearable at the given index
     *
     * @param idx index to get from
     * @return indexed wearable, null if invalid index
     */
    public Wearable getWearaleAtIndex(int idx){
        if(idx < 0 || idx >= wearables.length){
            return null;
        }
        return wearables[idx];
    }

    /**
     * gets the wearables sorted by ranking
     *
     * @return wearables in ranked order
     */
    public int[] getRankingPositionData(){
        return null;
    }

    /**
     * gets the wearables sorted by price
     *
     * @return the wearables in order by price
     */
    public int[] getPricePositionData(){
        return null;
    }

    /**
     * gets the wearables sorted by company name
     *
     * @return the wearables in order by company name
     */
    public int[] getCoNamePositionData(){
        return null;
    }

    /**
     * generates a CSV file with the data
     *
     * @param positions the positions to put in
     * @param fileName the file to save it in
     * @return whether saving was successful, ie valid file and not null positions
     */
    public boolean generateCSV(int[] positions, String fileName){
        return false;
    }
}
