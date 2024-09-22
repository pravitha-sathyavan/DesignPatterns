/*
Starbucks needs to customize a management system. 
Their coffee has different brands, such as latte, cappuccino, etc. of course, they will change in the future. 
At the same time, all kinds of coffee can be added with milk, soy milk, sugar and other ingredients.
Of course, the ingredients will also change (one cup of coffeecan add two cents of milk). 
There are also large and small cups of coffee.
Try to use the decoration pattern to realize the program of calculating coffee priceand information and depict the class hierarchy.
*/
import java.util.*;

public class DecoratorPattern { 
    
    public interface Coffee {   
        public String getDescription();    
        public double getCost();
    }
    
    public class LatteCoffee implements Coffee{
        
        @Override    
        public String getDescription() {  
            return "Latte ";    
        }   
        
        @Override    
        public double getCost() {       
            return 4.00;   
        }
    }
    
    public class CappuccinoCoffee implements Coffee{
        
        @Override    
        public String getDescription() {
            return "Cappuccino  ";    
        }
        
        @Override    
        public double getCost() {        
            return 5.00;
        }
    }

    public abstract class CoffeeToppings implements Coffee{ 
        
        protected Coffee decoratedCoffee;    
        public CoffeeToppings(Coffee decoratedCoffee) {        
            this.decoratedCoffee = decoratedCoffee;   
        } 
        
        @Override   
        public String getDescription() {        
            return decoratedCoffee.getDescription();   
        }  
        
        @Override   
        public double getCost() {        
            return decoratedCoffee.getCost();    
        }
    }
    
    public class Sugar extends CoffeeToppings{    
        public Sugar(Coffee decoratedCoffee) { 
            super(decoratedCoffee);      
            System.out.println("Adding sugar");   
        }   
        
        @Override    
        public String getDescription() {    
            return super.getDescription()+" Sugar ";    
            
        }   
        @Override  
        public double getCost() {        
            return super.getCost();    
        }
    }
    
    public class Milk extends CoffeeToppings{    
        public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);      
            System.out.println("Adding Milk");   
        }   
        @Override    
        public String getDescription() {       
            return super.getDescription()+" Milk ";    
        }    
        
        @Override    
        public double getCost() {       
            return super.getCost()+ 0.50;    
        }    
    
      }

    public class SoyMilk extends CoffeeToppings{    
        public SoyMilk(Coffee decoratedCoffee) {   
            super(decoratedCoffee);        
            System.out.println("Adding soy milk");   
        }   
        
        @Override    
        public String getDescription() {        
            return super.getDescription()+" Soy Milk ";    
        }    
        
        @Override    
        public double getCost() {        
            return super.getCost()+ 1.50;   
        }
    }       

    public interface Cup {    
        public String getSize();    
        public double cost();
    }

    public abstract class CupDecorator implements Cup {    
        protected  Coffee coffee;    
        public CupDecorator(Coffee coffee) {        
        this.coffee = coffee;    
        }    
    
    @Override    
    public String getSize() {       
        return coffee.getDescription();    
    }    
    
    @Override    
    public double cost() {       
        return coffee.getCost();    
    }
   }

    public class LargeCup extends CupDecorator{    
        public LargeCup(Coffee coffee) {        
            super(coffee);       
            System.out.println("Making Large cup of coffee");   
        }    
        
        @Override    
        public String getSize() {        
            return "Large " + coffee.getDescription();    
        }    
        
        @Override    
        public double cost() {        
            System.out.println("Cost of Large cup "+1.00);        
            return coffee.getCost()+1.00;   
        }
    }

    public class SmallCup extends CupDecorator{    
        public SmallCup(Coffee coffee) {        
            super(coffee);       
            System.out.println("Making Small cup of coffee");   
        }    
        
        @Override    
        public String getSize() {        
            return "Small " + coffee.getDescription();    
        }    
        
        @Override    
        public double cost() {        
            System.out.println("Cost of Small cup "+0.75);        
            return coffee.getCost()+0.75;   
        }
    }

   
    public void createCoffee(){
                Coffee latteCoffee = new Milk(new Sugar(new SoyMilk(new LatteCoffee())));        
                Cup largeLatteCoffee = new LargeCup(latteCoffee);        
                System.out.println("Ingredients: "+latteCoffee.getDescription());     
                System.out.println("Price "+ latteCoffee.getCost());        
                System.out.println("Final Order : " + largeLatteCoffee.getSize());  
                System.out.println("Final Order Total : " + largeLatteCoffee.cost());     
                System.out.println('\n');        
                Coffee cappuccino = new Sugar(new Milk(new CappuccinoCoffee()));       
                Cup smallCup = new SmallCup(cappuccino);        
                System.out.println("Ingredients: " + cappuccino.getDescription()); 
                System.out.println("Final Order : " + smallCup.getSize()); 
                System.out.println("Final Order Total : " + smallCup.cost()); 
    }
  
    public static void main(String[] args) {                   
                DecoratorPattern main = new DecoratorPattern();
                main.createCoffee();
    }
  
}

