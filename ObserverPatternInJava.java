import java.util.Observable;
import java.util.Observer;

public class ObserverPatternJava{
    
    //Observable is java inbuilt class for obsever pattern
    public class SubjectImpl extends Observable{
       
        //properties of subject that has to be updated with observers on change
        int property1;
        int property2;
        
        void setState(int p1, int p2){
            this.property1 = p1;
            this.property2 = p2;
            this.setChanged(); // this method signifies that state has changed in subject
            notifyObservers(); //call method in Observable class to notify observers.
        }
    }
    
    
    public class Observerimpl1 implements Observer{
        //All potential observers need to implement Observer inerface and has to register with subject
        private Observable subject;
        public Observerimpl1(Observable subject){
            this.subject = subject;
            subject.addObserver(this);
        }
        
        public void update(Observable o, Object arg){
            // Process the values of subject
            if(o instanceof SubjectImpl){
               SubjectImpl subject = (SubjectImpl) o;
               System.out.println(subject.property1 * subject.property2);
            }
        }
        
        //Other observer specific methods and variables
    }
    
    public class Observerimpl2 implements Observer{
        
        private Observable subject;
        public Observerimpl2(Observable subject){
            this.subject = subject;
            subject.addObserver(this);
        }
        
        public void update(Observable o, Object arg){
            // Process the values of subject
            if(o instanceof SubjectImpl){
               SubjectImpl subject = (SubjectImpl) o;
               System.out.println(subject.property1 + subject.property2);
            }
        }
    }
    
    public void createObjects(){
       SubjectImpl subject = new SubjectImpl();
       Observerimpl1 o1 = new Observerimpl1(subject);
       Observerimpl2 o2 = new Observerimpl2(subject);
       subject.setState(10,5);
    }
    
    public static void main(String[] args){
        ObserverPatternJava observerPattern = new ObserverPatternJava();
        observerPattern.createObjects();
    }
}
