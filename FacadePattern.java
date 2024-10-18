/*
The facade simplifies the process by providing a single interface for customers to check their balance, transfer funds, pay bills, and manage loans, 
without needing to know the details of how these operations are coordinated among different subsystems.
*/

class OnlineBankingFacade {
    private AccountService accountService;
    private PaymentService paymentService;
    private LoanService loanService;
    
    public OnlineBankingFacade() {
        accountService = new AccountService();
        paymentService = new PaymentService();
        loanService = new LoanService();
    }
    
    public void transferFunds(String fromAccount, String toAccount, double amount) {
        if (accountService.hasSufficientBalance(fromAccount, amount)) {
            paymentService.transfer(fromAccount, toAccount, amount);
        }
    }
    
    public void payLoan(String accountNumber, double amount) {
        loanService.payLoan(accountNumber, amount);
    }
}

/*
The facade provides a single interface for ATM transactions by coordinating the operations of the ATM hardware interface (card reader, cash dispenser), 
the core banking services (balance, transactions), and security (PIN validation, fraud detection).
*/

class ATMFacade {
    private AccountVerificationService verificationService;
    private TransactionService transactionService;
    private ATMHardwareInterface hardwareInterface;
    
    public ATMFacade() {
        verificationService = new AccountVerificationService();
        transactionService = new TransactionService();
        hardwareInterface = new ATMHardwareInterface();
    }
    
    public void withdraw(String cardNumber, String pin, double amount) {
        if (verificationService.verifyCardAndPin(cardNumber, pin) && 
            transactionService.checkBalance(cardNumber, amount)) {
            transactionService.debitAccount(cardNumber, amount);
            hardwareInterface.dispenseCash(amount);
        }
    }
}
