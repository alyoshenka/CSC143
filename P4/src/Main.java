/**
 * main application class
 */
public class Main {

    /** debug mode enabled */
    public static boolean DEBUG = true;

    /**
     * main application method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Document myDoc = Document.getInstance().newDocument("Hippos");
        Section firstSect = new Section();
        firstSect.addParagraph(  new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.Heading_1));
        firstSect.addParagraph(  new Paragraph("While the hippopotamus exists in various places in Africa..."));
        firstSect.addParagraph(new Paragraph("Hippo facts:"));
        String bulletedText = "";
        bulletedText += "The name Hippopotamus comes from the Ancient Greek 'river horse'. \n";
        bulletedText += "Hippos secrete an oily red substance; they do not sweat blood. \n";
        bulletedText += "An adult Hippo resurfaces every 3 to 5 minutes to breathe.\n";
        bulletedText += "They are only territorial while in the water.";
        firstSect.addParagraph(  new Paragraph(bulletedText, Paragraph.ParaStyle.List_Bulleted));
        firstSect.addParagraph(  new Paragraph("I hope you have enjoyed our foray into the world of the pygmy hippo..."));

        String fileName = myDoc.getTitle();
        myDoc.addSection(firstSect);
        myDoc.save();
        myDoc.saveToHTML();
        myDoc.close();

        Document mySecDoc = Document.getInstance();
        mySecDoc.open(fileName);
        mySecDoc.setTitle("MySecondDocument");
        Section sec = new Section();
        sec.addParagraph(new Paragraph("Hippos are super cool!", Paragraph.ParaStyle.Alignment_Right));
        Paragraph p = new Paragraph("This paragraph will be in the middle", Paragraph.ParaStyle.Alignment_Center);
        sec.addParagraph(p);
        sec.moveUp(p, 1);
        mySecDoc.addSection(sec);
        mySecDoc.save();
        mySecDoc.saveToHTML();
        mySecDoc.close();
    }
}
