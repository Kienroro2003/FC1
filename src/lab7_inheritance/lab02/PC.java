package lab7_inheritance.lab02;

public class PC extends Game{
    private int minimumRam;
    private int numberOfMegabytesNeeded;
    private int minimumGHz;

    public PC() {
    }

    public PC(String description, int minimumRam, int numberOfMegabytesNeeded, int minimumGHz) {
        super(description);
        this.minimumRam = minimumRam;
        this.numberOfMegabytesNeeded = numberOfMegabytesNeeded;
        this.minimumGHz = minimumGHz;
    }

    public int getMinimumRam() {
        return minimumRam;
    }

    public void setMinimumRam(int minimumRam) {
        this.minimumRam = minimumRam;
    }

    public int getNumberOfMegabytesNeeded() {
        return numberOfMegabytesNeeded;
    }

    @Override
    public String toString() {
        return "PC{" +
                "minimumRam=" + minimumRam +
                ", numberOfMegabytesNeeded=" + numberOfMegabytesNeeded +
                ", minimumGHz=" + minimumGHz +
                '}';
    }

    public void setNumberOfMegabytesNeeded(int numberOfMegabytesNeeded) {
        this.numberOfMegabytesNeeded = numberOfMegabytesNeeded;
    }

    public int getMinimumGHz() {
        return minimumGHz;
    }

    public void setMinimumGHz(int minimumGHz) {
        this.minimumGHz = minimumGHz;
    }
}
