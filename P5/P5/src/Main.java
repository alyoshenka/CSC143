public class Main {
    public static void main(String[] args){
        WearableManager wm = new WearableManager();
        int[] ranks = wm.getRankingPositionData();
        int[] prices = wm.getPricePositionData();
        int[] coNames = wm.getCoNamePositionData();
        for(int i = 0; i < ranks.length; i++){
            System.out.println(ranks[i] + ": " +
                    wm.getWearableAtIndex(i).getName()
                    + " $" + wm.getWearableAtIndex(i).getPrice()
                    + " by: " + wm.getWearableAtIndex(i).getCompanyName());
        }
    }
}
