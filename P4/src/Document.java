
/** a word processing document */
public class Document {
    /** the songleton instance of Document */
    private static Document instance;
    /** the file extension */
    private static final String EXT = ".wpd";
    /** the Sections in this Document */
    ListManager<Section> sections;
    /** the title of this Document */
    String title;

    /**
     * Document constructor
     * private to maintain singleton
     */
    private Document(){
        sections = new ListManager<Section>();
        title = "WPD";
        // instance ?
    }

    /**
     * gets the singleton instance of Document
     *
     * @return the singleton instance of Document
     */
    public Document getInstance(){
        if(null == instance){
            instance = new Document();
        }
        return instance;
    }

    /**
     * gets the Document title
     *
     * @return the Document title
     */
    public String getTitle(){
        return title;
    }

    /**
     * sets the title
     *
     * @param newTitle the new title, does nothing if null
     * @return whether setting worked, ie new title not null
     */
    public boolean setTitle(String newTitle){
        if(null == newTitle){
            return false;
        }
        title = newTitle;
        return true;
    }
}
