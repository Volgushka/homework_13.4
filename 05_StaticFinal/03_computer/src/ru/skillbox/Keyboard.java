public class Keyboard {

    private final String kbType;
    private final boolean hasBacklight;
    private final double kbWeight;

    public Keyboard(String kbType, boolean hasBacklight, double kbWeight) {
        this.kbType = kbType;
        this.hasBacklight = hasBacklight;
        this.kbWeight = kbWeight;
    }

    public double getKbWeight() {
        return kbWeight;
    }


}
