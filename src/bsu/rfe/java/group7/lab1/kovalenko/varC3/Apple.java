package bsu.rfe.java.group7.lab1.kovalenko.varC3;


public class Apple extends Food{
    String size = "some size";

    public Apple(String size) {
        super("Apple");
        this.size = size;
        amountOfParams++;
    }

    public Apple() {
        super("Apple");


    }
    @Override
    public void consume() {
        System.out.println(size + " " + super.getName());
    }

    @Override
    public boolean equals(Object apple) {
        if (super.getName().equals(((String[])apple)[0])){
            if(((String[])apple).length == 2)
            {
                return this.size.equals(((String[])apple)[1]);
            }
            return true;
        }
            return  false;

    }

    @Override
    public int calculateCalories() {
        switch (size){
            case "big": calories = 18; break;
            case "small": calories = 9;break;
            case "middle": calories = 15;break;
           default:
               size = "some size";
               calories = 5;break;
        }
        return calories;
    }
}
