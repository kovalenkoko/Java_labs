package bsu.rfe.java.group7.lab1.kovalenko.varC3;

public class Cheese extends Food {
    public Cheese() {
        super("Cheese");
        amountOfParams=0;
    }

    public void consume() {
        System.out.println(super.getName());
    }
    @Override
    public boolean equals(Object cheese) {
        if (super.getName().equals(((String[])cheese)[0])){
            return true;
        }
        return  false;
    }

    @Override
    public int calculateCalories() {
    calories = 25;
    return calories;
    }
}