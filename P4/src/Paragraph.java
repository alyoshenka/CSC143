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
        /** bulleted list */
        List_Bulleted,
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
     * default Paragraph constructor
     */
    public Paragraph(){
        content = "New Paragraph";
        style = defStyle;
    }

    /**
     * Paragraph constructor
     *
     * @param text the content, default initializes if null
     * @param style the style
     */
    public Paragraph(String text, ParaStyle style){
        if(null == text){
            content = "New Paragraph";
        }else{
            content = text;
        }
        this.style = style;
    }

    /**
     * Paragraph constructor
     * style initialized to default
     * @param text the content, default initializes if null
     */
    public Paragraph(String text){
        if(null == text){
            content = "New Paragraph";
        }else{
            content = text;
        }
        this.style = defStyle;
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

    /**
     * sets the paragraph style
     *
     * @param newStyle the new paragraph style
     */
    public void setStyle(ParaStyle newStyle){
        style = newStyle;
    }

    /**
     * gets the paragraph style
     *
     * @return the paragraph style
     */
    public ParaStyle getStyle(){
        return style;
    }

    /**
     * gets an HTML string this object
     *
     * @param tabs the string to add to apply tabs
     * @return an HTML string this object
     */
    public String toHTML(String tabs){
        String s = "";
        String tabs2 = tabs + "\t";
        String tabs3 = tabs2 + "\t";
        switch(style){
            case Alignment_Center:
                s = tabs + "<p style=\"text-align:center\" >\n";
                s += tabs2 + content;
                s += "\n" + tabs + "</p>";
                break;
            case Alignment_Left:
                s = tabs + "<p style=\"text-align:left\" >\n";
                s += tabs2 + content;
                s += "\n" + tabs + "</p>";
                break;
            case Alignment_Right:
                s = tabs + "<p style=\"text-align:right\" >\n";
                s += tabs2 + content;
                s += "\n" + tabs + "</p>";
                break;
            case List_Bulleted:
                s = tabs + "<ul>\n";
                for(String sub : content.split("\n")){
                    s += tabs2 + "<li>\n";
                    s += tabs3 + sub;
                    s += "\n" + tabs2 + "</li>\n";
                }
                s += tabs + "</ul>";
                break;
            case List_Numbered:
                s = tabs + "<ol>\n";
                for(String sub : content.split("\n")){
                    s += tabs2 + "<li>\n";
                    s += tabs3 + sub;
                    s += "\n" + tabs2 + "</li>\n";
                }
                s += tabs + "</ol>";
                break;
            case Heading_1:
                s += tabs + "<h1>\n";
                s += tabs2 + content;
                s += "\n" + tabs + "</h1>";
                break;
            case Heading_2:
                s += tabs + "<h2>\n";
                s += tabs2 + content;
                s += "\n" + tabs + "</h2>";
                break;
            case Heading_3:
                s += tabs + "<h3>\n";
                s += tabs2 + content;
                s += "\n" + tabs + "</h3>";
                break;
            case Heading_4:
                s += tabs + "<h4>\n";
                s += tabs2 + content;
                s += "\n" + tabs + "</h4>";
                break;
            default:
                break;
        }
        return s;
    }

    /**
     * gets a string representation of this object
     *
     * @return the String representation of this object;
     */
    public String toString(){
        return style.toString() + " - " + content;
    }

}
