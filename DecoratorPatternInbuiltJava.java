/*
Java java.util.Collections (Built-in Decorator)
The Java Collections Framework uses the Decorator pattern to provide synchronized (thread-safe) versions of collections. 
For example, the Collections.synchronizedList method wraps an existing list to ensure that access to the list is synchronized.
*/

import java.util.*;

public class CollectionsDecoratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        
        // Decorate the list with synchronized behavior
        List<String> syncList = Collections.synchronizedList(list);
        
        synchronized (syncList) {
            // Iterate over the synchronized list
            for (String item : syncList) {
                System.out.println(item);
            }
        }
    }
}
