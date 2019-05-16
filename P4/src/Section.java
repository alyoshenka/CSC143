
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

    /**
     * adds a paragraph to the ListManager
     *
     * @param para the Paragraph to add
     * @return whether adding was successful, ie para != null
     */
    public boolean addParagraph(Paragraph para){
        if(null == para){
            return false;
        }
        paragraphs.add(para);
        return true;
    }

    /**
     * gets an HTML string this object
     *
     * @return an HTML string this object
     */
    public String toHTML(String tabs){
        String s = tabs + "<body>\n";
        tabs += "\t";
        for(int i = 0; i < paragraphs.getCount(); i++){
            s += paragraphs.getItem(i).toHTML(tabs);
            s += "\n" + tabs + "<hr/>\n";
        }
        s += tabs + "</body>\n";

        return s;
    }

    /**
     * gets a string representation of this object
     *
     * @return the String representation of this object;
     */
    public String toString(){
        return "Heading: " + heading + "Paragraphs: " + paragraphs.toString();
    }
}
