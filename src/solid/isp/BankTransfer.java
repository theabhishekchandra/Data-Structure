package solid.isp;


/** SOLID -> I: No client should be force to depend on methods its does not use. */
public class BankTransfer implements PaymentProcessor{
    @Override
    public void processPayment() {
        // ig
    }

    @Override
    public void refundProcess() {
        // Ig
    }
}
