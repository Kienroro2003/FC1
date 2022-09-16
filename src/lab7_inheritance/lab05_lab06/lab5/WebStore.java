package lab7_inheritance.lab05_lab06.lab5;

import lab7_inheritance.lab05_lab06.Store;

public class WebStore extends Store {
    private String internetAddress;
    private String programming;

    public WebStore() {
    }

    public WebStore(String newName, String internetAddress, String programming) {
        super(newName);
        this.internetAddress = internetAddress;
        this.programming = programming;
    }

    public String getInternetAddress() {
        return internetAddress;
    }

    public void setInternetAddress(String internetAddress) {
        this.internetAddress = internetAddress;
    }

    public String getProgramming() {
        return programming;
    }

    public void setProgramming(String programming) {
        this.programming = programming;
    }

    @Override
    public String toString() {
        return "WebStore{" +
                "internetAddress='" + internetAddress + '\'' +
                ", programming='" + programming + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
