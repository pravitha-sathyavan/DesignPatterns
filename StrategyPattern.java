import java.util.*;

public class Main{
//Strategy Interface
public interface SortingStrategy{
    void sort(List<Integer> list);
}

//Concrete class1 for Interface
public class BubbleSort implements SortingStrategy{
  public void sort(List<Integer> list){
      System.out.println("Bubble sort is implemented");
  }
}


//Concrete class2 for Interface
public class QuickSort implements SortingStrategy{
  public void sort(List<Integer> list){
      System.out.println("Quick sort is implemented");
  }
}

class NumberList{
    private SortingStrategy sortstrategy;
    
    public void setStrategy(SortingStrategy sortstrategy){
        this.sortstrategy = sortstrategy;
    }
    
    public void sortList(List<Integer> list){
        sortstrategy.sort(list);
    }
} 

   public void sortUsingStrategy(){
        NumberList numberlist = new NumberList();
        numberlist.setStrategy(new BubbleSort());
        numberlist.sortList(Arrays.asList(5,4,3,2));
        
        numberlist.setStrategy(new QuickSort());
        numberlist.sortList(Arrays.asList(5,2,3,4)); 
   }
   
    public static void main(String[] args){
        Main main = new Main();
        main.sortUsingStrategy();
    }
}
