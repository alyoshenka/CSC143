
/** a word processing document section */
public class Section {
    /** paragraphs in this section */
    private ListManager<Paragraph> paragraphs;
    /** heading of this section */
    private String heading;

    /**
     * Section constructor
     */
    public Section(){
        paragraphs = new ListManager<Paragraph>();
        heading = "";
    }

    /**
     * Section constructor
     *
     * @param paragraphs the paragraphs for this Section, default initialized if null
     * @param heading the heading for this Section, default initialized if null
     */
    public Section(String heading, ListManager<Paragraph> paragraphs){
        this.heading = null == heading ? "New Section" : heading;
        this.paragraphs = null == paragraphs ? new ListManager<Paragraph>() : paragraphs;
    }

    /**
     * gets the heading
     *
     * @return the heading
     */
    public String getHeading(){
        return heading;
    }

    /**
     * sets the heading, does nothing if new heading is null
     *
     * @param newHeading the new heading
     * @return whether newHeading is valid, ie not null
     */
    public boolean setHeading(String newHeading){
        if(null == newHeading){
            return false;
        }
        this.heading = heading;
        return true;
    }
}
