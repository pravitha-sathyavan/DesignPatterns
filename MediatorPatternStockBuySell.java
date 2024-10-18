import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface StockExchangeMediator {
    void buyStock(Buyer buyer, int quantity);
    void sellStock(Seller seller, int quantity);
}

// Concrete Mediator
class StockExchange implements StockExchangeMediator {
    private List<Buyer> buyers;
    private List<Seller> sellers;

    public StockExchange() {
        buyers = new ArrayList<>();
        sellers = new ArrayList<>();
    }

    public void registerBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    public void registerSeller(Seller seller) {
        sellers.add(seller);
    }

    @Override
    public void buyStock(Buyer buyer, int quantity) {
        System.out.println(buyer.getName() + " is trying to buy " + quantity + " stocks.");
        for (Seller seller : sellers) {
            // For simplicity, assume every seller has stock available for sale
            seller.sellStock(quantity, buyer);
        }
    }

    @Override
    public void sellStock(Seller seller, int quantity) {
        System.out.println(seller.getName() + " is trying to sell " + quantity + " stocks.");
        for (Buyer buyer : buyers) {
            buyer.buyStock(quantity, seller);
        }
    }
}

// Colleague class
abstract class User {
    protected StockExchangeMediator mediator;
    protected String name;

    public User(StockExchangeMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Concrete Colleague classes
class Buyer extends User {
    public Buyer(StockExchangeMediator mediator, String name) {
        super(mediator, name);
        mediator.registerBuyer(this);
    }

    public void buyStock(int quantity) {
        mediator.buyStock(this, quantity);
    }
}

class Seller extends User {
    public Seller(StockExchangeMediator mediator, String name) {
        super(mediator, name);
        mediator.registerSeller(this);
    }

    public void sellStock(int quantity, Buyer buyer) {
        System.out.println(name + " sold " + quantity + " stocks to " + buyer.getName() + ".");
    }
}

// Usage
public class StockExchangeExample {
    public static void main(String[] args) {
        StockExchangeMediator stockExchange = new StockExchange();

        Buyer buyer1 = new Buyer(stockExchange, "Alice");
        Buyer buyer2 = new Buyer(stockExchange, "Bob");
        Seller seller1 = new Seller(stockExchange, "Charlie");
        Seller seller2 = new Seller(stockExchange, "Diana");

        // Buyers trying to buy stocks
        buyer1.buyStock(10);
        buyer2.buyStock(5);

        // Sellers trying to sell stocks
        seller1.sellStock(10, buyer1);
        seller2.sellStock(5, buyer2);
    }
}
