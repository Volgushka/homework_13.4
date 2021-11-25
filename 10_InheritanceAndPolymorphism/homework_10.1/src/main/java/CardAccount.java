public class CardAccount extends BankAccount {

    public void take(double amountToTake) {
        double com =  amountToTake * 0.01;
        myAmount = ((amountToTake + com)< myAmount) ? myAmount - amountToTake -com: myAmount;
    }

}
