import java.util.HashSet;
//import java.util.Iterator;

class Hashing {

    public static void main(String[] args) {
        //creation
        HashSet<Integer> set = new HashSet<>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2); //list.add(el)

        //Size
        System.out.println("Size of the set is: "+ set.size());

        //Print all elements
        System.out.println(set);

        //Search
        if(set.contains(1)) {
            System.out.println("Set contains 1");
        }
        if(!set.contains(4)) {
            System.out.println("Set does'nt contain");
        }

        //Delete
        set.remove(1);
        if(!set.contains(1)) {
            System.out.println("It doesn't contain 1 - We Deleted 1");
        }

        //Iterator
        // Iterator it = set.iterator();
        //     while(it.hasNext()) {
        //         System.out.println(it.next());
        //     }
    }
}