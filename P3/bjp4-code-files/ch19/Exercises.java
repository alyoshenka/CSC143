import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

// include ternary ? : in discussion of lambdas?
// map, filter, reduce
// distinct
// (Arrays|Collections).sort() that takes a lambda comparison function?
//     Tree(Set|Map) constructor, the same? etc.
//     Arrays.sort(months, Comparator.comparing(String::length));
//     Integer.compare
// String.chars -> IntStream

// word count
// longest line in a file
// file searcher for a given word

public class Exercises {
    public static void main(String[] args) throws Throwable {
        int[] a = {5, -1, 3, 20, 47, 0, 6};
        double[] a2 = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        String[] a3 = {"b", "ddd", "aa", "b", "ccccc", "ccccc", "aa", "b", "b"};
        int[] a4 = {5, -1, -3, 20, 47, -10, -8, -4, 0, -6, -6};
        
        double[] radii = {3.0, 1.0, 7.2, 5.5};
        
        System.out.println("print doubled");
        printDoubled(a);
        System.out.println();
        
        System.out.println("count negatives");
        System.out.println(countNegatives(a4));
        System.out.println();
        
        System.out.println("sum abs vals");
        System.out.println(sumAbsVals(a));
        System.out.println();
        
        System.out.println("total circle area");
        System.out.println(totalCircleArea(radii));   // 289.30926746908403
        System.out.println();
        
        System.out.println("largest even");
        System.out.println(largestEven(a));
        System.out.println();
        
        System.out.println("stdev");
        System.out.println(stdev(a2));
        System.out.println();
        
        System.out.println("toPigLatin");
        System.out.println(toPigLatin("go Seattle Mariners"));
        System.out.println();
        
        System.out.println("concatenatedByLength");
        System.out.println(concatenatedByLength(Arrays.asList(a3)));
        System.out.println();
        
        System.out.println("toSortedForm");
        System.out.println(toSortedForm("eeeennsst"));
        System.out.println();
        
        System.out.println("longestLine");
        System.out.println(longestLine("poem.txt"));
        System.out.println();
        
        System.out.println("multOf10");
        multOf10();
        System.out.println();

        System.out.println("freeBoundVars");
        freeBoundVars();
        System.out.println();
        
        System.out.println("array streams:");
        arrayStreamSelfChecks();
        System.out.println();
        
        System.out.println("list streams:");
        listStreamSelfChecks();
        System.out.println();
        
        System.out.println("glue reverse:");
        List<String> revWords = Arrays.asList("the", "quick", "brown", "fox");
        System.out.println(glueReverse(revWords));
        System.out.println();
    }
    
    public static void listStreamSelfChecks() {
        int[] a = {10, -28, 33, 28, -49, 56, 49};
        Arrays.stream(a)
            .map(Math::abs)
            .forEach(System.out::println);
    }
    
    public static void arrayStreamSelfChecks() {
        int[] a = {10, -28, 33, 28, -49, 56, 49};
        Arrays.stream(a)
            .map(Math::abs)
            .forEach(System.out::println);
    }
    
    public static String glueReverse(List<String> elements) {
        return elements.stream()
            .reduce("", (a, b) -> b + a);
    }
    
    public static void freeBoundVars() {
        int a = 10;
        int b = 20;
        int sum = IntStream.of(1, 2, 3, 4, 5)
            .map(n -> n + b - (/*++*/a))
            .sum();
    }
    
    public static void multOf10() {
        // print largest multiple of 10 in the list
        int largest = IntStream.of(55, 20, 19, 31, 40, -2, 62, 30)
            .filter(n -> n % 10 == 0)
            .max()
            .getAsInt();
        System.out.println(largest);
    }
    
    // print 2x the value of each number, one per line 
    public static void printDoubled(int[] a) {
        Arrays.stream(a)
            	.map(n -> n + n)
            	.forEach(System.out::print);
        System.out.println();
    }
    
    // return the sum of the absolute values of the ints in the array 
    public static int sumAbsVals(int[] a) {
        return Arrays.stream(a)
            	.map(Math::abs)
            	.sum();
    }
    
    public static int longestLine(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
            .mapToInt(String::length)
            .max()
			.getAsInt();
    }
    
//     public static boolean isSorted(int[] a) {
//         return Arrays.stream(a)
//             	.reduce(true, (n1, n2) )
//             	.sum();
//     }
    
    public static double totalCircleArea(double[] radii) {
        return Math.round(Arrays.stream(radii)
                .map(r -> Math.PI * r * r)
                .sum());
    }
    
    // returns the largest even number in the array
    public static int largestEven(int[] a) {
        return Arrays.stream(a)
            	.filter(n -> n % 2 == 0)
            	.max().getAsInt();
    }
    
    public static int countNegatives(int[] a) {
        return Arrays.stream(a)
                .filter(n -> n < 0)
                .map(n -> 1)
                .reduce(0, (n1, n2) -> n1 + n2);
    }
    
    public static String toPigLatin(String phrase) {
        return Arrays.stream(phrase.split(" "))
                .map(s -> s.substring(1) + "-" + s.charAt(0) + "ay")
                .reduce("", (s1, s2) -> s1 + " " + s2);
    }
    
    public static String longPlurals(String[] a) {
        return Arrays.stream(a)
                .filter(s -> s.endsWith("s") && s.length() >= 8)
                .reduce("", (s1, s2) -> s1 + " " + s2);
    }
    
    // concatenated, sorted by length
    public static String concatenatedByLength(List<String> a) {
        return a.stream()
            	.sorted(Comparator.comparing(s -> s.length()))
            	.distinct()
            	.reduce("", (s1, s2) -> s1 + s2);
    }
    
    // canonical form: "tennessee" -> "eeeennsst"
    public static String toSortedForm(String s) {
        return s.chars()
            	.sorted()
            	.mapToObj(c -> String.valueOf((char) c))
            	.reduce("", (s1, s2) -> s1 + s2);
    	// .collect(Collectors.joining());
    }
    
    // compute the standard deviation of the doubles in the array
    // https://www.mathsisfun.com/data/standard-deviation-formulas.html
    public static double stdev(double[] a) {
        double avg = DoubleStream.of(a).average().getAsDouble();
        return DoubleStream.of(a)
            	.map(n -> Math.pow(n - avg, 2))
            	.average().getAsDouble();
    }
}
