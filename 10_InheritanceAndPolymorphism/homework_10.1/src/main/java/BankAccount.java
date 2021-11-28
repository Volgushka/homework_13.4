public class BankAccount {

  protected boolean transfer = true;
  protected double balance;

  public BankAccount() {
  }
  public BankAccount(double balance) {
    this.balance = balance;
  }

  public double getAmount() {
    return balance;
  }
  public void put(double amountToPut) {
    balance = (amountToPut > 0) ? balance + amountToPut : balance;
  }

  public void take(double amountToTake) {
    if (amountToTake < balance) {
      balance = balance - amountToTake;
    } else {
      transfer = false;
    }
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
