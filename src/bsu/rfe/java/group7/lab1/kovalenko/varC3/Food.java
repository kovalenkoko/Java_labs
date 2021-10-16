package bsu.rfe.java.group7.lab1.kovalenko.varC3;

public abstract class Food implements INutritious, IConsumable{
    int calories = 0;
    int amountOfParams = 0;
    private String name;

    public String getName() {
        return name;
    }

    public Food(String name) {
        this.name = name;
    }

}
