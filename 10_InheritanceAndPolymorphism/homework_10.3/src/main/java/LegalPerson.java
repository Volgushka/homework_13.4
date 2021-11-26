public class LegalPerson extends Client {

    private double com = 0.01;

    public void take(double amountToTake) {
        amount = (amountToTake + amount * com) < amount? amount-amountToTake-com :amount;
    }

    @Override
    public String information() {
        return "Условия";
    }

}
