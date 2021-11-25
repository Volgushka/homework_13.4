
import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    LocalDate lastIncome;


    public void put(double amountToPut) {
        myAmount = (amountToPut > 0) ? myAmount + amountToPut: myAmount;
        lastIncome =  LocalDate.now();
    }

    public void take(double amountToTake) {
        LocalDate takeDay = LocalDate.now();
        if (takeDay.isAfter(lastIncome.plusMonths(1))) {
            myAmount = (amountToTake < myAmount) ? myAmount - amountToTake : myAmount;
        }
        else {
            checkSend = false;
        }
        }

    }

