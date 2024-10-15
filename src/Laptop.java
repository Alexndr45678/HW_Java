public class Laptop {
    private String brand;
    private String os;
    private String color;
    private int hddSize;
    private int ram;

    public Laptop(String brand, String os, String color, int hddSize, int ram) {
        this.brand = brand;
        this.os = os;
        this.color = color;
        this.hddSize = hddSize;
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHddSize() {
        return hddSize;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, " +
                "OS: %s, " +
                "Color: %s, " +
                "HDD: %d, " +
                "RAM: %d.", brand, os, color, hddSize, ram);
    }
}
