package bsu.rfe.java.group7.lab1.kovalenko.varC3;

public class Dessert extends Food{
    String component1 = "something sweet";
    String component2 = "something sweet";
    public Dessert(String component1, String component2) {
        super("Dessert");
        this.component1 = component1;
        this.component2 = component2;
        amountOfParams+= 2;
    }
    public Dessert(String component1) {
        super("Dessert");
        this.component1 = component1;
        amountOfParams++;
    }
    public Dessert() {
        super("Dessert");
            }

    @Override
    public boolean equals(Object dessert) {

        if (super.getName().equals(((String[])dessert)[0])){
            if(((String[])dessert).length == 2)
            {
                return this.component1.equals(((String[])dessert)[1]);
            }
            if(((String[])dessert).length == 3)
            {
                return this.component1.equals(((String[])dessert)[1]) && this.component2.equals(((String[])dessert)[2]);
            }
            return true;
        }
        return  false;

    }

    @Override
    public void consume() {
        System.out.println(component1 + " with " + component2 + " (" + super.getName() + ") ");
    }

    @Override
    public int calculateCalories() {
        switch (component1){
            case "bagel": calories = 14; break;
            case "biscotti": calories = 16;break;
            case "cake": calories = 25;break;
            default:
                component1 = "something sweet with component 1";
                calories = 5;break;
        }

        switch (component2){
            case "cookie": calories += 6; break;
            case "cracker": calories += 10;break;
            case "donut": calories += 24;break;
            default:
                component2= "something sweet with component 2";
                calories += 5;break;
        }
        return calories;
    }
}
