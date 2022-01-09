public class Lines {

    public Lines() {}

    private String type;
    private String number;
    private String currency;
    private String date;
    private String referens;
    private String description;
    private String organization;
    private String income;
    private String out;


    public Lines(String type, String number, String date, String currency, String referens, String description, String income, String out, String organization) {
        this.type = type;
        this.number = number;
        this.date = date;
        this.currency =currency;
        this.referens = referens;
        this.description = description;
        this.income = income;
        this.out = out;
        this.organization = organization;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getIncome() {
        return income;
    }

    public String getOut() {
        return out;
    }

    public String getCurrency() {
        return currency;
    }

    public String getReferens() {
        return referens;
    }

    public String getOrganization() {
        return organization;
    }
}

