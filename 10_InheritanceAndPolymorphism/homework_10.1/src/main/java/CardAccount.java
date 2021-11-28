

public class CardAccount extends BankAccount {


    public CardAccount() {
        super();
    }

    public CardAccount(double amount) {
        super(amount);
    }
    public void take(double amountToTake) {
        double com =  amountToTake * 0.01;
        balance = ((amountToTake + com)< balance) ? balance - amountToTake -com: balance;
    }
    public boolean send(BankAccount receiver, double amount) {
        double startAmount = receiver.getAmount();
        if (amount > 0 && startAmount >= 0) {
            take(amount);
            receiver.put(amount);
        }
        return receiver.getAmount() == (startAmount + amount);
    }
}
