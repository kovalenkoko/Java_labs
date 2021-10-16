package bsu.rfe.java.group7.lab1.kovalenko.varC3;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;


public class mainClass {
    public static void main(String[] args) throws  IllegalAccessException, InvocationTargetException{

        Food[] breakfast = new Food[20];
        breakfast[0] = new Apple("big");
        breakfast[1] = new Dessert("bagel","donut");
        breakfast[2] = new Cheese();
        breakfast[3] = new Dessert("cake");


        boolean logicSort = false;
        boolean logicCalories = false;
        int iter = 0;
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
