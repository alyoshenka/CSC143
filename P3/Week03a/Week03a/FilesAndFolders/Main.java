import java.io.File;

public class Main {

    public static void main(String[] args) {
        System.out.print("\u000C");
        File myFileOrFolder = new File("C:/Program Files (x86)/BlueJ/lib");
        //File myFileOrFolder = new File(".");
        //File myFileOrFolder = new File("SampleFolder");
        
        File[] folderContents = myFileOrFolder.listFiles();
        String type = "";
        if (folderContents == null) {
            System.out.println("No files/folders found");
        } else {
            for (File aFile : folderContents) {
                if (aFile.isFile()) {
                    type = "file";
                } else if (aFile.isDirectory()) {
                    type = "fold"; 
                }
                System.out.println(type + " : " + aFile);
            }
        }    
    }
}
