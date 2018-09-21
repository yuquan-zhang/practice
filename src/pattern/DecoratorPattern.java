package pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Food {
    String preparedFood();
    double foodPrice();
}

class VegFood implements Food {
    public String preparedFood() {
        return "Veg food";
    }
    public double foodPrice() {
        return 25.5;
    }
}

abstract class FoodDecorator implements Food {
    private Food newFood;
    public FoodDecorator(Food newFood) {
        this.newFood = newFood;
    }

    @Override
    public String preparedFood() {
        return newFood.preparedFood();
    }

    @Override
    public double foodPrice() {
        return newFood.foodPrice();
    }
}

class NonVegFood extends FoodDecorator {
    public NonVegFood(Food food) {
        super(food);
    }
    public String preparedFood() {
        return super.preparedFood() + " With Roasted Chiken and Chiken Curry ";
    }
    public double foodPrice() {
        return super.foodPrice() + 14.4;
    }
}

class ChineseFood extends FoodDecorator{
    public ChineseFood(Food newFood)    {
        super(newFood);
    }
    public String preparedFood(){
        return super.preparedFood() +" With Fried Rice and Manchurian  ";
    }
    public double foodPrice()   {
        return super.foodPrice()+65.0;
    }
}

public class DecoratorPattern {
    private static int choice;
    public static void main(String args[]) throws NumberFormatException, IOException {
        do{
            System.out.print("========= Food Menu ============ \n");
            System.out.print("            1. Vegetarian Food.   \n");
            System.out.print("            2. Non-Vegetarian Food.\n");
            System.out.print("            3. Chineese Food.         \n");
            System.out.print("            4. Exit                        \n");
            System.out.print("Enter your choice: ");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            choice=Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:{
                    VegFood vf=new VegFood();
                    System.out.println(vf.preparedFood());
                    System.out.println( vf.foodPrice());
                }
                break;

                case 2:{
                    Food f1=new NonVegFood((Food) new VegFood());
                    System.out.println(f1.preparedFood());
                    System.out.println( f1.foodPrice());
                }
                break;
                case 3:{
                    Food f2=new ChineseFood((Food) new VegFood());
                    System.out.println(f2.preparedFood());
                    System.out.println( f2.foodPrice());
                }
                break;

                default:{
                    System.out.println("Other than these no food available");
                }
                return;
            }//end of switch

        }while(choice!=4);
    }
}
