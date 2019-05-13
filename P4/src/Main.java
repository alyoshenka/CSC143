public class Main {

    public static boolean DEBUG = true;

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.BOF();
        System.out.println(list.dataAt(4));
        list.BOF();
        System.out.println(list.moveDown(list.dataAt(0), 5));
        list.BOF();
        System.out.println(list.moveUp(list.dataAt(5), 2));
        list.BOF();
    }
}
