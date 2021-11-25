public class BankAccount {

  public double myAmount;
  public boolean checkSend = true;

  public double getAmount()
  {return myAmount;}

  public void put(double amountToPut) {
    myAmount = (amountToPut > 0) ? myAmount + amountToPut: myAmount;
  }

  public void take(double amountToTake) {
    if(amountToTake < myAmount){
      myAmount = myAmount - amountToTake;
    }
    else {
      checkSend = false;
    }
  }

//  public boolean send (BankAccount receiver, double amount)
 // {
//
//    return checkSend;
//
//  }
}
