public class Main {

    public static boolean DEBUG = true;

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println(list.toString());
        System.out.println(list.dataAt(1));
        // System.out.println(list.move(list.dataAt(1), 5));
        System.out.println(list.moveDown(list.dataAt(1), 4));
        System.out.println(list.toString());
    }
}
