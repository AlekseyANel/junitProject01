package Thing;

public class Thing {
    private String name;
    private int quantity;

    public Thing(String name, int age) {
        this.name = name;
        this.quantity = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
