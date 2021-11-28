

import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    public DepositAccount(){
        super();
    }

    LocalDate lastIncome;

    public void put(double amountToPut) {
       balance = (amountToPut > 0) ? balance + amountToPut: balance;
        lastIncome =  LocalDate.now();
    }

    public void take(double amountToTake) {
        LocalDate takeDay = LocalDate.now();
        if (takeDay.isAfter(lastIncome.plusMonths(1))) {
            balance = (amountToTake < balance) ? balance - amountToTake : balance;
        }
        else {
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

