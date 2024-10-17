// PaymentProcessor interface that your application uses
public interface PaymentProcessor {
    void processPayment(double amount);
}

// Third-party PayPal payment gateway
public class PayPalPayment {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed through PayPal.");
    }
}

// Adapter class to adapt PayPalPayment to PaymentProcessor interface
public class PayPalAdapter implements PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PayPalAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void processPayment(double amount) {
        payPalPayment.makePayment(amount);  // Adapt the call
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the PayPal payment gateway
        PayPalPayment payPalPayment = new PayPalPayment();

        // Create an adapter for PayPal to work with your PaymentProcessor interface
        PaymentProcessor paymentProcessor = new PayPalAdapter(payPalPayment);

        // Process a payment using the adapter
        paymentProcessor.processPayment(100.0);
    }
}
