// Strategy Interface
public interface DriveStrategy {
    void drive();
}



// Concrete Strategy for driving on the road
public class RoadDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving on the road");
    }
}

// Concrete Strategy for driving off-road
public class OffRoadDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving off-road");
    }
}

// Concrete Strategy for driving on the race track
public class RaceTrackDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving on a race track");
    }
}




// Abstract Vehicle Class
public abstract class Vehicle {
    protected DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void performDrive() {
        driveStrategy.drive();
    }

    public void setDriveStrategy(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public abstract void display();
}



// Concrete Vehicle Classes with different drive behaviors
public class Car extends Vehicle {
    public Car() {
        super(new RoadDriveStrategy());
    }

    @Override
    public void display() {
        System.out.println("I am a car");
    }
}

public class Truck extends Vehicle {
    public Truck() {
        super(new OffRoadDriveStrategy());
    }

    @Override
    public void display() {
        System.out.println("I am a truck");
    }
}

public class RaceCar extends Vehicle {
    public RaceCar() {
        super(new RaceTrackDriveStrategy());
    }

    @Override
    public void display() {
        System.out.println("I am a race car");
    }
}



public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.display();
        car.performDrive();  // Output: Driving on the road

        Vehicle truck = new Truck();
        truck.display();
        truck.performDrive();  // Output: Driving off-road

        Vehicle raceCar = new RaceCar();
        raceCar.display();
        raceCar.performDrive();  // Output: Driving on a race track

        // Dynamically change strategy
        car.setDriveStrategy(new OffRoadDriveStrategy());
        car.performDrive();  // Output: Driving off-road
    }
}


