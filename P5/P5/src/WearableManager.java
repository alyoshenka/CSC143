import java.io.*;

/**
 * manages the Wearables and file IO
 */
public class WearableManager {
    /** all the wearables */
    private Wearable[] wearables;
    /** wearables by customer ranking */
    private BinarySearch<Integer> rankings;
    /** wearables by price */
    private BinarySearchDuplicate<Double> prices;
    /** wearables by company name */
    private BinarySearchDuplicate<String> coNames;

    /**
     * default constructor
     */
    public WearableManager(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Wearables.txt"));
            int size = Integer.parseInt(br.readLine());
            wearables = new Wearable[size];
            int idx = 0;
            /** take off csv label line */
            String line = br.readLine();
            /** add to array */
            int i = 1;
            while(null != (line = br.readLine())){
                String[] sections = line.split("@");
                if(sections.length != 11){
                    // break
                }
                Wearable wear = new Wearable(Integer.parseInt(sections[0]), sections[1],
                    Double.parseDouble(sections[2]), sections[3], sections[4], sections[5], sections[6],
                    sections[7], sections[8], sections[9], sections[10]);
                wearables[idx++] = wear;
            }
            br.close();
        } catch(Exception e){
            // deal with error
            wearables = new Wearable[0];
        }

        rankings = new BinarySearch<>();
        prices = new BinarySearchDuplicate<>();
        coNames = new BinarySearchDuplicate<>();
        for(int i = 0; i < wearables.length; i++){
            rankings.add(wearables[i].getRanking(), i);
            prices.add(wearables[i].getPrice(), i);
            coNames.add(wearables[i].getCompanyName(), i);
        }
    }

    /**
     * gets the wearable at the given index
     *
     * @param idx index to get from
     * @return indexed wearable, null if invalid index
     */
    public Wearable getWearableAtIndex(int idx){
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
        return rankings.inOrder();
    }

    /**
     * gets the wearables sorted by price
     *
     * @return the wearables in order by price
     */
    public int[] getPricePositionData(){
        return prices.inOrder();
    }

    /**
     * gets the wearables sorted by company name
     *
     * @return the wearables in order by company name
     */
    public int[] getCoNamePositionData(){
        return coNames.inOrder();
    }

    /**
     * generates a CSV file with the data
     *
     * @param positions the positions to put in
     * @param fileName the file to save it in, no extension
     * @return whether saving was successful, ie valid file and not null positions
     */
    public boolean generateCSV(int[] positions, String fileName){
        try{
            FileWriter fileOut = new FileWriter(fileName + ".txt");
            BufferedWriter bufOut = new BufferedWriter(fileOut);
            String val = "";
            for(int i : positions){
                bufOut.write(wearables[i].toCSV());
                bufOut.newLine();
            }
            bufOut.flush();
            bufOut.close();
            fileOut.flush();
            fileOut.close();
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}
