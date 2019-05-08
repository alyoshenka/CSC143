/** a paragraph */
public class Paragraph {
    /** Paragraph styles */
    public enum ParaStyle{
        /** left aligned */
        Alignment_Left,
        /** center aligned */
        Alignment_Right,
        /** center aligned */
        Alignment_Center,
        /** bulletted list */
        List_Bulletted,
        /** a numbered list */
        List_Numbered,
        /** largest heading */
        Heading_1,
        /** second largest heading */
        Heading_2,
        /** third largest heading */
        Heading_3,
        /** fourth largest heading */
        Heading_4
    }

    /** the default style */
    private static ParaStyle defStyle = ParaStyle.Alignment_Left;

    /** the content of the Paragraph */
    private String content;
    /** the style of the Paragraph */
    private ParaStyle style;

    /**
     * Paragraph constructor
     */
    public Paragraph(){
        content = "";
        style = defStyle;
    }

    /**
     * gets the content of the Paragraph
     *
     * @return the content
     */
    public String getContent(){
        return content;
    }

    /**
     * sets the content of the Paragraph
     * @param newContent the new content
     * @return if the setting was successful, ie newContent != null
     */
    public boolean setContent(String newContent){
        if(null == newContent){
            return false;
        }
        content = newContent;
        return true;
    }

    /**
     * adds content to the content of the Paragraph
     * @param newContent the new content
     * @return if the setting was successful, ie newContent != null
     */
    public boolean addContent(String newContent){
        if(null == newContent){
            return false;
        }
        content += newContent;
        return true;
    }


    public void setStyle(ParaStyle newStyle){} // just make public instead?
    public ParaStyle getSyele(){
        return style;
    }

}
