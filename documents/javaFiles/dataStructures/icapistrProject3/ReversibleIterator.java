package dataStructures;
import java.util.*;

public interface ReversibleIterator<T> extends Iterator<T> {
   // return true if a previous element can be returned
   public boolean hasPrevious(); 

   // return the previous element
   public T previous(); 
}
