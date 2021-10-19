package bsu.rfe.java.group7.lab1.kovalenko.varC3;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class mainClass {
    public static void main(String[] args) throws  IllegalAccessException, InvocationTargetException{

        Food[] breakfast = new Food[20];

        boolean logicSort = false;
        boolean logicCalories = false;
        ArrayList<Integer> cheeseArray = new ArrayList<>();
        ArrayList<Integer> appleArray = new ArrayList<>();
        ArrayList<Integer> dessertArray = new ArrayList<>();

        int iter = 0;
        int itemsSoFar = 0;
        for (String arg: args) {
            String[] partsOfArguments = arg.split("/");
            if(partsOfArguments[0].equals("-sort"))
            {
                logicSort = true;
                continue;
            }
            if(partsOfArguments[0].equals("-calories"))
            {
                logicCalories = true;
                continue;
            }

            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
                cheeseArray.add(itemsSoFar);
            }
            if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);
                appleArray.add(itemsSoFar);
            }
            if (parts[0].equals("Dessert")) {
                breakfast[itemsSoFar] = new Dessert(parts[1],parts[2]);
                dessertArray.add(itemsSoFar);
            }
            itemsSoFar++;
            try {
                Class myClass = Class.forName("bsu.rfe.java.group7.lab1." + partsOfArguments[0]);

                if (partsOfArguments.length==1) {

                    Constructor constructor = myClass.getConstructor();
                    breakfast[iter] = (Food)constructor.newInstance();
                } else
                if (partsOfArguments.length==2) {

                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[iter] = (Food)constructor.newInstance(partsOfArguments[1]);
                }
                if (partsOfArguments.length==3) {

                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[iter] = (Food)constructor.newInstance(partsOfArguments[1],partsOfArguments[2] );
                }
            }catch (ClassNotFoundException e)
            {
                System.out.println("("+iter+")This product can't be eaten");
                continue;
            }
            catch (NoSuchMethodException e)
            {
                System.out.println("There are no some method");
                continue;
            }
            catch (InstantiationException e)
                {
                    continue;
            }

            breakfast[iter].consume();
            ++iter;
        }
        System.out.println("---------------------------------");
        if(logicCalories)
        {
            System.out.println("AMOUNT OF CALORIES: " + calculateCaloriesOfBreakfast(breakfast));
        }
        if(logicSort)
        {
            System.out.println("SORT BREAKFAST:");
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object f1, Object f2) {
                    if (f1==null) return 1;
                    if (f2==null) return -1;
                    return ((Food)f2).amountOfParams > (((Food)f1).amountOfParams) ? 1: -1;
                }
            });
            printMyBreakfast(breakfast);

        }
        System.out.println("Cheeses:" + " " + cheeseArray.size());
        System.out.println("Apples:" + " " + appleArray.size());
        System.out.println("Desserts:" + " " + dessertArray.size());

    }

    public static void printMyBreakfast(Food[] breakfast)
    {
        for (Food obj: breakfast)
        {
            if(obj == null)
            {
                break;
            }
            obj.consume();

        }
    }

    public static int calculateCaloriesOfBreakfast(Food[] breakfast)
    {
        int totalCalories = 0;
        for(Food obj: breakfast)
        {
            if(obj == null)
            {
                break;
            }
            totalCalories+= obj.calculateCalories();
        }
        return totalCalories;
    }

}




