import java.util.ArrayList;
public class ObserverPattern{
    
    
    public interface Subject{
        //Observers use this interface methods to register/deregister as observer
        public void addObserver(Observer o);
        public void deleteObserver(Observer o);
        public void notifyObserver();
    }
    
    public class SubjectImpl implements Subject{
        private ArrayList<Observer> observers; //To store list of observers.
        
        //properties of subject that has to be updated with observers on change
        int property1;
        int property2;
        
        public SubjectImpl(){
            this.observers = new ArrayList<>();
        }
        
        public void addObserver(Observer o){
            this.observers.add(o);
        }
        public void deleteObserver(Observer o){
            if(observers.indexOf(o)>=0){
                observers.remove(o);
            }
        }
        public void notifyObserver(){
            for(Observer o:this.observers){
                o.update(property1, property2);
            }
        }
        
        void setState(int p1, int p2){
            this.property1 = p1;
            this.property2 = p2;
            this.notifyObserver();
        }
    }
    
    public interface Observer{
        public void update(int p1, int p2);
    }
    
    public class Observerimpl1 implements Observer{
        //All potential observers need to implement Observer inerface and has to register with subject
        private Subject subject;
        
        public Observerimpl1(Subject subject){
            this.subject = subject;
            subject.addObserver(this);
        }
        
        public void update(int p1, int p2){
            // Process the values of subject
            System.out.println(p1+p2);
        }
        
        //Other observer specific methods and variables
    }
    
    public class Observerimpl2 implements Observer{
        
        private Subject subject;
        
        public Observerimpl2(Subject subject){
            this.subject = subject;
            subject.addObserver(this);
        }
        
        public void update(int p1, int p2){
            // Process the values of subject
            System.out.println(p1*p2);
        }
    }
    
    public void createObjects(){
       SubjectImpl subject = new SubjectImpl();
       Observerimpl1 o1 = new Observerimpl1(subject);
       Observerimpl2 o2 = new Observerimpl2(subject);
       subject.setState(10,5);
    }
    
    public static void main(String[] args){
        ObserverPattern observerPattern = new ObserverPattern();
        observerPattern.createObjects();
    }
}


