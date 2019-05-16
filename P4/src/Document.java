import java.io.*;

/** a word processing document */
public class Document implements Serializable {
    /** the singleton instance of Document */
    private static Document instance = null;
    /** the file extension */
    private static final String EXT = ".wpd";
    /** the local directory where documents are stored */
    private static final String DIR = "Documents/";
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
        title = "New Document";
        instance = null; // no open doc at init
        File directory = new File(DIR);
        if(!directory.exists()){
            directory.mkdir();
        }
    }

    /**
     * gets the singleton instance of Document
     *
     * @return the singleton instance of Document
     */
    public static Document getInstance(){
        return null == instance ? new Document() : instance;
    }

    /**
     * gets the Document title
     *
     * @return the Document title
     */
    public String getTitle(){
        if(null == instance){
            return "";
        }
        return instance.title;
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
        instance.title = newTitle;
        return true;
    }

    /**
     * adds a section to the end of the list
     *
     * @param newSection the new section
     * @return whether section was added successfully, ie not null
     */
    public boolean addSection(Section newSection){
        if(null == newSection) {
            return false;
        }
        instance.sections.add(newSection);
        return true;
    }

    /**
     * adds a section at a given position
     *
     * @param newSection the section to add
     * @param idx the index to add it at, will add to end if out of bounds
     * @return whether section was added successfully, ie not null and within bounds
     */
    public boolean addSectionAt(Section newSection, int idx){
        if(null == newSection) {
            return false;
        }
        return instance.sections.addAt(newSection, idx);
    }

    /**
     * gets the number of sections
     *
     * @return the number of sections
     */
    public int size(){
        if(null == instance){
            return -1;
        }
        return instance.sections.size();
    }

    /**
     * saves the file
     *
     * @return whether save was successful
     * @throws IllegalStateException if no open document
     */
    public boolean save(){
        if(null == instance){
            throw new IllegalStateException("No open document to save");
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(DIR + instance.title + EXT);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(instance);
            objOut.flush();
            objOut.close();
            fileOut.flush();
            fileOut.close();
        }
        catch(IOException e){
            return false;
        }
        return true;
    }

    /**
     * saves the file to HTML
     *
     * @return whether the file was saved successfully
     * @throws IllegalStateException if no open document
     */
    public boolean saveToHTML(){
        if(null == instance){
            throw new IllegalStateException("No open document to save");
        }
        try{
            FileWriter writer = new FileWriter(new File(DIR + instance.title + ".html"));
            writer.write(instance.toHTML());
            writer.flush();
            writer.close();
        }
        catch(IOException e){
            return false;
        }
        return true;
    }

    /**
     * opens a file
     *      does nothing if another file is open
     *
     * @param title the title of the document to open
     * @return whether file was opened successfully
     */
    public boolean open(String title){
        title = "Documents/" + title + ".wpd";
        if(null != instance){
            return false;
        }
        try{
            FileInputStream fileIn = new FileInputStream(title);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            instance = (Document)objIn.readObject();
            objIn.close();
            fileIn.close();
        }
        catch(IOException | ClassNotFoundException e){
            return false;
        }
        return true;
    }

    /**
     * closes the current file
     *      Note: DOES NOT SAVE
     */
    public void close(){
        instance = null;
    }

    /**
     * makes a new Document
     *
     * @param title the title of the new Document
     * @return the new Document
     * @throw IllegalStateException if another doc is open
     */
    public static Document newDocument(String title){
        if(null != instance){
            throw new IllegalStateException("another document is open");
        }
        Document newDoc = new Document();
        newDoc.title = title;
        instance = newDoc;
        return newDoc;
    }

    /**
     * gets an HTML string this object
     *
     * @return an HTML string this object
     */
    private String toHTML(){
        String s = "<!DOCTYPE html>\n<html>\n";
        for(int i = 0; i < instance.sections.size(); i++){
            s += instance.sections.getItem(i).toHTML("\t");
        }
        s += "\n</html>";

        return s;
    }

    /**
     * gets a string representation of this object
     *
     * @return the String representation of this object;
     */
    public String toString(){
        return "Document: " + title + " Sections: " + sections.toString();
    }
}
