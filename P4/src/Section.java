import java.io.Serializable;

/** a word processing document section */
public class Section implements Serializable {
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
     * gets the number of sections
     * 
     * @return the number of sections
     */
    public int size(){
        return paragraphs.size();
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
     * moves a paragraph up
     *
     * @param para the paragraph to move
     * @param positions the number of positions
     * @return whether moving was successful
     */
    public boolean moveUp(Paragraph para, int positions){
        return paragraphs.moveUp(para, positions);
    }

    /**
     * moves a paragraph down
     *
     * @param para the paragraph to move
     * @param positions the number of positions
     * @return whether moving was successful
     */
    public boolean moveDown(Paragraph para, int positions){
        return paragraphs.moveDown(para, positions);
    }

    /**
     * gets an HTML string this object
     *
     * @param tabs the string to add to apply tabs
     * @return an HTML string this object
     */
    public String toHTML(String tabs){
        String s = tabs + "<body>";
        s += "\n" + tabs + "<hr/>";
        for(int i = 0; i < paragraphs.size(); i++){
            s += paragraphs.getItem(i).toHTML("\t" + tabs);
        }
        s += "\n" + tabs + "</body>";

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
