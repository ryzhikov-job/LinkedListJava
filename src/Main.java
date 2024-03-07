import gb_collections.lists.GbLinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GbLinkedList<Integer> list = new GbLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);
        System.out.println(list.size());
        list.addFirst(5);
        System.out.println(list);
        list.add(0, 6);
        System.out.println(list);
        list.add(1, 7);
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(7);
        System.out.println(list);
        System.out.println(list.getElementByIndex(2));
        System.out.println(list);
        list.removeByIndex(1);
        System.out.println(list);
//        list.removeByIndex(0);
//        System.out.println(list);
//        list.addFirst(3);
//        System.out.println(list.getElementByIndex(4));
//        System.out.println(list.size());
//        GbList<Integer> list = new GbArrayList<>();
//        ArrayList<Integer> list1 = new LinkedList<>();
//        list.add(5);
//        list.add(9);
//        list.add(66);
//        list.add(8);
//        list.add(5);
//        list.add(9);
//        list.add(66);
//        list.add(8);
//        list.add(5);
//        list.add(9);
//        list.add(66);
//        list.add(8);
//        System.out.println(list.size());
//        System.out.println(list);
//        list.removeByIndex(1);
//        list.remove(66);
//        System.out.println(list);
//        GbList<String> s = new GbArrayList<>();
//        s.add("asdf");
//        s.add("xcdf");
//        s.add("hjdf");
//        s.add("lkjf");
    }
}
