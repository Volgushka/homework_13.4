public class IndividualBusinessman extends Client {


    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount = (amountToPut < 1000) ? amount + amountToPut - amountToPut*0.01 : amount + amountToPut - amountToPut*0.005;
        }
        else {
            amount = amount;
        }
    }

    @Override
    public String information() {
        return "Условия";
    }

}

