package linkedlistset;

import java.util.*;

import lib.SetADT;
import sets.*;

public class LinkedListSetTest {
  public static Boolean contains (SetADT<Integer> s1, SetADT<Integer> s2){
    //contains implemented as a static method
    Boolean isSubset = true;
     Iterator<Integer> iter = s1.iterator();
     while (iter.hasNext())
       if (!s2.contains(iter.next()))
         isSubset = false;
     return isSubset;
  }
  public static void main(String[] args) {

    // this main simply tests the methods for the implementations of the SetADT
    // to try a different implementation change the instations below to fit the
    // other classes.

    LinkedListSet.setDebug(true);
    System.out.println("Create mySet1: ");
    SetADT<Integer> mySet1 = new LinkedListSet<Integer> ();
    System.out.println("mySet1 = " + mySet1);

    Integer neg1 = new Integer(-1);
    Integer zero = new Integer(0);
    mySet1.add(zero);
    mySet1.add(zero);
    System.out.println("mySet1 = " + mySet1);

    System.out.println("does mySet1 contain 0? " + mySet1.contains(zero));
    System.out.println("does mySet1 contain -1? " + mySet1.contains(neg1));

    Random rand = new Random();
    System.out.println("Add to mySet1: ");
    for (int i = 0; i < 10; i++){
      mySet1.add(new Integer(rand.nextInt(100)));
    }
    System.out.println("now, mySet1 =" + mySet1);
    
    System.out.println("Create mySet2: ");
    SetADT<Integer> mySet2 = new LinkedListSet<Integer>();
    System.out.println("Add mySet1 to mySet2: ");
    mySet2.addAll(mySet1);
    System.out.println("mySet2 = " + mySet2);

    Integer removed = mySet1.removeRandom();
    System.out.println("remove " + removed + ", and mySet1 = " + mySet1);
    System.out.println("mySet1.equals(mySet2) = "+mySet1.equals(mySet2));
    mySet2.remove(removed);
    System.out.println("remove " + removed + ", and mySet2 = " + mySet2);
    System.out.println("Now, are they equal? "+mySet1.equals(mySet2));
    
    System.out.println("Create mySet3: ");
    SetADT<Integer> mySet3 = new LinkedListSet<Integer> ();
    System.out.println("Add to mySet3: ");
    for (int i = 0; i < 10; i++){
      mySet3.add(new Integer(rand.nextInt(100)));
    }
    System.out.println("now, mySet3= " + mySet3);

    LinkedListSet<Integer>  mySetTotal = (LinkedListSet<Integer>)mySet1.union(mySet3);
    System.out.println("mySetTotal = mySet1 union mySet3 = " +mySetTotal);

    // test for set containment in main
    Boolean isSubset = true;
    Iterator<Integer> iter = mySet1.iterator();
    while (iter.hasNext()) {
      if (!mySetTotal.contains(iter.next()))
        isSubset = false;
    }
    System.out.println("mySetTotal contains mySet1: " + isSubset);

    // Use a static method
    System.out.println("contains(mySet1, mySetTotal) = "+contains(mySet1,mySetTotal));

    // use an object method
    System.out.println("mySetTotal.contains(mySet1) = "+mySetTotal.contains(mySet1));
    

  }
}
