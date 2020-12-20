package dto;

public class FavouritesDto {
    private String name;
    private int rate;

    public FavouritesDto(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "FavouritesDto{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
