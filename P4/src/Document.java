import java.io.*;

/** a word processing document */
public class Document {
    /** the singleton instance of Document */
    private static Document instance;
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
        sections.add(newSection);
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
        return sections.addAt(newSection, idx);
    }

    /**
     * saves the file
     *
     * @return whether save was successful
     */
    public boolean save(){
        instance.close();
        try {
            FileOutputStream fileOut = new FileOutputStream(DIR + title + EXT);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);
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
     */
    public boolean saveToHTML(){
        return false;
    }

    /**
     * opens a file
     *
     * @param file the File to open
     * @return whether file was opened successfully
     */
    public boolean open(File file){
        if(null != instance){
            instance.save();
            instance.close();
        }
        try{
            FileInputStream fileIn = new FileInputStream(file);
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
     */
    public void close(){
        instance = null;
    }

    /**
     * makes a new Document
     *
     * @param title the title of the new Document
     * @return the new Document
     */
    public Document newDocument(String title){
        instance.close();
        Document newDoc = new Document();
        newDoc.title = title;
        instance = newDoc;
        return newDoc;
    }
}
