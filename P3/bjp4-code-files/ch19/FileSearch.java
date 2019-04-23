import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileSearch {
    public static void main(String[] args) throws IOException {
        String[] filenames = {
                "mobydick.txt", "hamlet.txt", "tomsawyer.txt",
                "mobydick.txt", "hamlet.txt", "tomsawyer.txt",
                "mobydick.txt", "hamlet.txt", "tomsawyer.txt",
                "mobydick.txt", "hamlet.txt", "tomsawyer.txt",
                "mobydick.txt", "hamlet.txt", "tomsawyer.txt"};
        
        System.out.println("Searching " + filenames.length + " files using Scanner:");
        long startTime = System.currentTimeMillis();
        processFileOldWay(filenames, "the");
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Took " + elapsedTime + " ms.");
        System.out.println();
        
        System.out.println("Searching " + filenames.length + " files using streams:");
        startTime = System.currentTimeMillis();
        processFileWithStreams(filenames, "the");
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Took " + elapsedTime + " ms.");
    }
        
    public static void processFileOldWay(String[] filenames, String word) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        for (String filename : filenames) {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains(word)) {
                    lines.add(line);
                }
            }
        }
        System.out.println("there were " + lines.size() + " total matching lines.");
    }
        
    public static void processFileWithStreams(String[] filenames, String word) throws IOException {
        List<String> lines =
            Arrays.stream(filenames)
            .parallel()
            .flatMap(filename -> Files_linesSafe(filename))
            .filter(line -> line.contains(word))
            .collect(Collectors.toList());
        System.out.println("there were " + lines.size() + " total matching lines.");
    }
    
    public static Stream<String> Files_linesSafe(String filename) {
        try {
            return Files.lines(Paths.get(filename));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
