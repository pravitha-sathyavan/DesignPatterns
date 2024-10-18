/*

The Mediator Design Pattern is a behavioral design pattern used to reduce the direct dependencies between communicating objects, 
making their interaction more manageable and loosely coupled. 
Instead of objects communicating directly with each other, they communicate via a mediator object, which handles the interactions and encapsulates the communication logic.

Key Concepts of the Mediator Pattern:
Mediator Interface: Defines the communication methods that can be invoked by different participants or colleagues.
Concrete Mediator:  Implements the mediator interface and coordinates the communication between different objects (colleagues).
Colleague (or Participant): Objects that communicate with each other through the mediator rather than directly. These objects send messages to the mediator instead of sending them to other colleagues.

When to Use the Mediator Pattern:
You want to decouple the objects in your system to avoid tight coupling.
A large number of objects are interacting in complex ways.
You want to centralize the control logic that affects multiple objects or systems.

*/

// Mediator interface
interface ChatRoomMediator {
    void showMessage(User user, String message);
}

// Concrete Mediator
class ChatRoom implements ChatRoomMediator {
    @Override
    public void showMessage(User user, String message) {
        System.out.println("[" + user.getName() + "]: " + message);
    }
}

// Colleague class
class User {
    private String name;
    private ChatRoomMediator chatRoom;

    public User(String name, ChatRoomMediator chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chatRoom.showMessage(this, message);
    }
}

// Usage
public class MediatorPatternExample {
    public static void main(String[] args) {
        ChatRoomMediator chatRoom = new ChatRoom();

        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Bob", chatRoom);

        user1.sendMessage("Hello Bob!");
        user2.sendMessage("Hi Alice!");
    }
}
