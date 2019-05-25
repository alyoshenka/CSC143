import java.util.Arrays;

/**
 * demonstration class
 */
public class Main {
    /**
     * main application method
     * @param args command line arguments
     */
    public static void main(String[] args){
        WearableManager wm = new WearableManager();
        int[] ranks = wm.getRankingPositionData();
        int[] prices = wm.getPricePositionData();
        int[] coNames = wm.getCoNamePositionData();

        wm.generateCSV(ranks, "Rankings");
        wm.generateCSV(prices, "Prices");
        wm.generateCSV(coNames, "CoNames");

        /** get sorted data */
        int[] top10Ranked = Arrays.copyOfRange(ranks, 0, 10);
        int[] top20Prices = Arrays.copyOfRange(prices, 0,20);
        int min, max;
        for(min = 0; min < coNames.length; min++){
            if(wm.getWearableAtIndex(coNames[min]).getCompanyName().compareTo("M") >= 0){
                break;
            }
        }
        for(max = coNames.length - 1; max >= 0; max--){
            if(wm.getWearableAtIndex(coNames[max]).getCompanyName().startsWith("O")){
                break;
            }
        }
        int[] MtoO = Arrays.copyOfRange(coNames, min, max + 1);

        /** display in files */
        wm.generateCSV(top10Ranked, "Top10Ranked");
        wm.generateCSV(top20Prices, "Top20Prices");
        wm.generateCSV(MtoO, "MtoOCompanies");

        /** show by ranking */
        System.out.println("----- Rankings -----");
        for(int i = 0; i < ranks.length; i++){
            System.out.println(i + 1 + ": " + wm.getWearableAtIndex(ranks[i]).toDisplay());
        }

        /** show by price */
        System.out.println("\n----- Prices -----");
        for(int i = 0; i < prices.length; i++){
            System.out.println(i + 1 + ": " + wm.getWearableAtIndex(prices[i]).toDisplay());
            if(i < prices.length - 1 &&
                    wm.getWearableAtIndex(prices[i + 1]).getPrice() != wm.getWearableAtIndex(prices[i]).getPrice()){
                System.out.println("--");
            }
        }

        /** show by company */
        System.out.println("\n----- Companies -----");
        for(int i = 0; i < coNames.length; i++){
            System.out.println(i + 1 + ": " + wm.getWearableAtIndex(coNames[i]).toDisplay());
            if(i < coNames.length - 1 &&
                    wm.getWearableAtIndex(coNames[i + 1]).getCompanyName().compareTo(wm.getWearableAtIndex(coNames[i]).getCompanyName()) != 0){
                System.out.println("--");
            }
        }
    }
}
