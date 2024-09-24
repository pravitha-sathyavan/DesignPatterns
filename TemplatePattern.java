import java.util.*;

public class Main{
public abstract class Game {
    abstract void startPlay();
    abstract void endPlay();
    
    public void play(){
        startPlay();
        endPlay();
    }
}


public class Cricket extends Game {
    void startPlay(){
        System.out.println("Cricket started");
    }
    
    void endPlay(){
        System.out.println("Cricket ended");
    }
}


public class Football extends Game {
    void startPlay(){
        System.out.println("Football started");
    }
    
    void endPlay(){
        System.out.println("Football ended");
    }
}

public void createGame(){
        Game game = new Cricket();
        game.play();
        
        game = new Football();
        game.play();
}

    public static void main(String[] args){
       Main main = new Main();
       main.createGame();
    }
}
