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


}
