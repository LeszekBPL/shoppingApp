package dto;

public class ShoppingListDto {
    private String name;
    private int amount;

    public ShoppingListDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ShoppingListDto{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
