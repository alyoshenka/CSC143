/**
 * holds data for wearable devices
 */
public class Wearable {
    /** the device ranking */
    private int ranking;
    /** the device name */
    private String name;
    /** the device price */
    private double price;
    /** location device is worn */
    private String bodyLocation;
    /** category of device */
    private String category;
    /** name of company */
    private String companyName;
    /** company website url */
    private String companyURL;
    /** company mapping location */
    private String companyMappingLocation;
    /** company city */
    private String companyCity;
    /** company state */
    private String companyState;
    /** company country */
    private String companyCountry;

    /**
     * Wearable constructor
     *
     * @param ranking customer ranking
     * @param name company name
     * @param price device price
     * @param bodyLocation location device is worn
     * @param category device category
     * @param companyName company name
     * @param companyURL company url
     * @param companyMappingLocation company mapping location
     * @param companyCity company city
     * @param companyState company state
     * @param companyCountry company country
     */
    public Wearable(int ranking, String name, double price, String bodyLocation, String category,
        String companyName, String companyURL, String companyMappingLocation,
        String companyCity, String companyState, String companyCountry){

        // deal with preconditions

        this.ranking = ranking;
        this.name = name;
        this.price = price;
        this.bodyLocation = bodyLocation;
        this.category = category;
        this.companyName = companyName;
        this.companyURL = companyURL;
        this.companyMappingLocation = companyMappingLocation;
        this.companyCity = companyCity;
        this.companyState = companyState;
        this.companyCountry = companyCountry;
    }

    /**
     * gets the device ranking
     *
     * @return the device ranking;
     */
    public int getRanking(){
        return ranking;
    }

    /**
     * gets the device name
     *
     * @return device name
     */
    public String getName(){
        return name;
    }

    /**
     * gets the device price
     *
     * @return device price
     */
    public double getPrice(){
        return price;
    }

    /**
     * gets the device body location
     *
     * @return device body location
     */
    public String getBodyLocation(){
        return bodyLocation;
    }

    /**
     * gets the device category
     *
     * @return device category
     */
    public String getCategory(){
        return category;
    }

    /**
     * gets the device company name
     *
     * @return device company name
     */
    public String getCompanyName(){
        return companyName;
    }

    /**
     * gets the device company URL
     *
     * @return device company URL
     */
    public String getCompanyURL(){
        return companyURL;
    }

    /**
     * gets the device company mapping location
     *
     * @return device company mapping location
     */
    public String getCompanyMappingLocation(){
        return companyMappingLocation;
    }

    /**
     * gets the device company city
     *
     * @return device company city
     */
    public String getCompanyCity(){
        return companyCity;
    }

    /**
     * gets the device company state
     *
     * @return device company state
     */
    public String getCompanyState(){
        return companyState;
    }

    /**
     * gets the device company country
     *
     * @return device company country
     */
    public String getCompanyCountry(){
        return companyCountry;
    }

    /**
     * gets a CSV formatted string of the object
     *
     * @return the object in CSV form
     */
    public String toCSV(){
        String val = "";
        val += ranking + ",\"";
        val += CSVCommas(name) + "\",";
        val += price + ",\"";
        val += CSVCommas(bodyLocation) + "\",\"";
        val += CSVCommas(category) + "\",\"";
        val += CSVCommas(companyName) + "\",\"";
        val += CSVCommas(companyURL) + "\",\"";
        val += CSVCommas(companyMappingLocation) + "\",\"";
        val += CSVCommas(companyCity) + "\",\"";
        val += CSVCommas(companyState) + "\",\"";
        val += CSVCommas(companyCountry) + "\"";

        return val;
    }

    /**
     * inserts commas at appropriate places for csv file
     *
     * @param orig the original string to check
     * @return the string modified for csv
     */
    private String CSVCommas(String orig){
        if(orig.contains("\"")){
            StringBuilder sb = new StringBuilder(orig);
            int idx = sb.indexOf("\"");
            while(idx != -1) {
                sb.insert(idx, "\"");
                idx = sb.indexOf("\"", idx + 2);
            }
            orig = sb.toString();
        }
        return orig;
    }

    /**
     * gets a display value of the object with price, company name, and device name
     *
     * @return a display view of the object
     */
    public String toDisplay(){
        String val = "";
        if(price == -99.99){
            val += "$: none";
        }else{
            val += String.format("$%.2f", price);
        }
        val += " ~By: " + companyName;
        val += " ~Device: " + name;

        return val;
    }
}
