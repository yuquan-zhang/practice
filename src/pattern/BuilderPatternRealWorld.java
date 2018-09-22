package pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

interface Item {
    String name();
    String size();
    float price();
}

abstract class Pizza implements Item {
    public abstract float price();
}

abstract class ColdDrink implements Item {
    public abstract float price();
}

abstract class VegPizza extends Pizza {
    public abstract String name();
    public abstract String size();
    public abstract float price();
}

abstract class NonVegPizza extends Pizza {
    public abstract String name();
    public abstract String size();
    public abstract float price();
}

class SmallCheezePizza extends VegPizza{
    @Override
    public float price() {
        return 170.0f;
    }
    @Override
    public String name() {
        return "Cheeze Pizza";
    }
    @Override
    public String size() {
        return "Small size";
    }
}

class MediumCheezePizza extends VegPizza{
    @Override
    public float price() {
        return  220.f;
    }
    @Override
    public String name() {
        return "Cheeze Pizza";
    }
    @Override
    public String size() {
        return "Medium Size";
    }
}

class LargeCheezePizza extends VegPizza{
    @Override
    public float price() {
        return 260.0f;
    }
    @Override
    public String name() {
        return "Cheeze Pizza";
    }
    @Override
    public String size() {
        return "Large Size";
    }
}

class ExtraLargeCheezePizza extends VegPizza{
    @Override
    public float price() {
        return 300.f;
    }
    @Override
    public String name() {
        return  "Cheeze Pizza";
    }
    @Override
    public String size() {
        return "Extra-Large Size";
    }
}

class SmallOnionPizza extends VegPizza {
    @Override
    public float price() {
        return 120.0f;
    }
    @Override
    public String name() {
        return  "Onion Pizza";
    }
    @Override
    public String size() {
        return  "Small Size";
    }
}

class MediumOnionPizza extends VegPizza {
    @Override
    public float price() {
        return 150.0f;
    }
    @Override
    public String name() {
        return  "Onion Pizza";
    }
    @Override
    public String size() {
        return  "Medium Size";
    }
}

class LargeOnionPizza extends  VegPizza{
    @Override
    public float price() {
        return 180.0f;
    }
    @Override
    public String name() {
        return "Onion Pizza";
    }
    @Override
    public String size() {
        return  "Large size";
    }
}

class ExtraLargeOnionPizza extends VegPizza {
    @Override
    public float price() {
        return 200.0f;
    }
    @Override
    public String name() {
        return  "Onion Pizza";
    }
    @Override
    public String size() {
        return  "Extra-Large Size";
    }
}

class SmallMasalaPizza extends VegPizza{
    @Override
    public float price() {
        return 100.0f;
    }
    @Override
    public String name() {
        return  "Masala Pizza";
    }
    @Override
    public String size() {
        return  "Samll Size";
    }
}

class MediumMasalaPizza extends VegPizza {

    @Override
    public float price() {
        return 120.0f;
    }

    @Override
    public String name() {

        return "Masala Pizza";

    }

    @Override
    public String size() {
        return "Medium Size";
    }
}

class LargeMasalaPizza extends  VegPizza{
    @Override
    public float price() {
        return 150.0f;
    }

    @Override
    public String name() {

        return  "Masala Pizza";

    }

    @Override
    public String size() {
        return  "Large Size";
    }
}

class ExtraLargeMasalaPizza extends VegPizza {
    @Override
    public float price() {
        return 180.0f;
    }

    @Override
    public String name() {

        return  "Masala Pizza";

    }

    @Override
    public String size() {
        return  "Extra-Large Size";
    }
}

class SmallNonVegPizza extends NonVegPizza {

    @Override
    public float price() {
        return 180.0f;
    }

    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Samll Size";
    }

}

class MediumNonVegPizza extends NonVegPizza {

    @Override
    public float price() {
        return 200.0f;
    }

    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Medium Size";
    }
}

class LargeNonVegPizza extends NonVegPizza{

    @Override
    public float price() {
        return 220.0f;
    }

    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Large Size";
    }

}

class ExtraLargeNonVegPizza extends NonVegPizza {
    @Override
    public float price() {
        return 250.0f;
    }

    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Extra-Large Size";
    }

}

abstract class Pepsi extends ColdDrink {

    @Override
    public abstract  String name();

    @Override
    public abstract  String size();

    @Override
    public abstract  float price();

}

abstract class Coke  extends ColdDrink {

    @Override
    public abstract  String name();

    @Override
    public abstract  String size();

    @Override
    public abstract  float price();

}

class SmallPepsi  extends Pepsi{

    @Override
    public String name() {
        return "300 ml Pepsi";
    }

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String size() {
        return "Small Size";
    }
}

class MediumPepsi extends Pepsi {

    @Override
    public String name() {
        return "500 ml Pepsi";
    }

    @Override
    public String size() {
        return "Medium Size";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}

class LargePepsi extends Pepsi{
    @Override
    public String name() {
        return "750 ml Pepsi";
    }

    @Override
    public String size() {
        return "Large Size";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}

class SmallCoke extends Coke{

    @Override
    public String name() {
        return "300 ml Coke";
    }

    @Override
    public String size() {

        return "Small Size";
    }

    @Override
    public float price() {

        return  25.0f;
    }
}

class MediumCoke extends Coke{

    @Override
    public String name() {
        return "500 ml Coke";
    }

    @Override
    public String size() {

        return "Medium Size";
    }

    @Override
    public float price() {

        return  35.0f;
    }
}

class LargeCoke extends Coke {
    @Override
    public String name() {
        return "750 ml Coke";
    }

    @Override
    public String size() {

        return "Large Size";
    }

    @Override
    public float price() {

        return  50.0f;
    }
}

class OrderedItems {

    List<Item> items=new ArrayList<Item>();

    public void addItems(Item item){

        items.add(item);
    }
    public float getCost(){

        float cost=0.0f;
        for (Item item : items) {
            cost+=item.price();
        }
        return cost;
    }
    public void showItems(){

        for (Item item : items) {
            System.out.println("Item is:" +item.name());
            System.out.println("Size is:" +item.size());
            System.out.println("Price is: " +item.price());

        }
    }

}

class OrderBuilder {
    public OrderedItems preparePizza() throws IOException {

        OrderedItems itemsOrder = new OrderedItems();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(" Enter the choice of Pizza ");
        System.out.println("============================");
        System.out.println("        1. Veg-Pizza       ");
        System.out.println("        2. Non-Veg Pizza   ");
        System.out.println("        3. Exit            ");
        System.out.println("============================");

        int pizzaandcolddrinkchoice = Integer.parseInt(br.readLine());
        switch (pizzaandcolddrinkchoice) {
            case 1: {

                System.out.println("You ordered Veg Pizza");
                System.out.println("\n\n");
                System.out.println(" Enter the types of Veg-Pizza ");
                System.out.println("------------------------------");
                System.out.println("        1.Cheeze Pizza        ");
                System.out.println("        2.Onion Pizza        ");
                System.out.println("        3.Masala Pizza        ");
                System.out.println("        4.Exit            ");
                System.out.println("------------------------------");
                int vegpizzachoice = Integer.parseInt(br.readLine());
                switch (vegpizzachoice) {
                    case 1: {
                        System.out.println("You ordered Cheeze Pizza");

                        System.out.println("Enter the cheeze pizza size");
                        System.out.println("------------------------------------");
                        System.out.println("    1. Small Cheeze Pizza ");
                        System.out.println("    2. Medium Cheeze Pizza ");
                        System.out.println("    3. Large Cheeze Pizza ");
                        System.out.println("    4. Extra-Large Cheeze Pizza ");
                        System.out.println("------------------------------------");
                        int cheezepizzasize = Integer.parseInt(br.readLine());
                        switch (cheezepizzasize) {
                            case 1:
                                itemsOrder.addItems(new SmallCheezePizza());
                                break;
                            case 2:
                                itemsOrder.addItems(new MediumCheezePizza());
                                break;
                            case 3:
                                itemsOrder.addItems(new LargeCheezePizza());
                                break;
                            case 4:
                                itemsOrder.addItems(new ExtraLargeCheezePizza());
                                break;
                        }
                    }
                    case 2: {
                        System.out.println("You ordered Onion Pizza");
                        System.out.println("Enter the Onion pizza size");
                        System.out.println("----------------------------------");
                        System.out.println("    1. Small Onion Pizza ");
                        System.out.println("    2. Medium Onion Pizza ");
                        System.out.println("    3. Large Onion Pizza ");
                        System.out.println("    4. Extra-Large Onion Pizza ");
                        System.out.println("----------------------------------");
                        int onionpizzasize = Integer.parseInt(br.readLine());
                        switch (onionpizzasize) {
                            case 1:
                                itemsOrder.addItems(new SmallOnionPizza());
                                break;

                            case 2:
                                itemsOrder.addItems(new MediumOnionPizza());
                                break;

                            case 3:
                                itemsOrder.addItems(new LargeOnionPizza());
                                break;

                            case 4:
                                itemsOrder.addItems(new ExtraLargeOnionPizza());
                                break;

                        }
                    }
                    break;
                    case 3: {
                        System.out.println("You ordered Masala Pizza");
                        System.out.println("Enter the Masala pizza size");
                        System.out.println("------------------------------------");
                        System.out.println("    1. Small Masala Pizza ");
                        System.out.println("    2. Medium Masala Pizza ");
                        System.out.println("    3. Large Masala Pizza ");
                        System.out.println("    4. Extra-Large Masala Pizza ");
                        System.out.println("------------------------------------");
                        int masalapizzasize = Integer.parseInt(br.readLine());
                        switch (masalapizzasize) {
                            case 1:
                                itemsOrder.addItems(new SmallMasalaPizza());
                                break;

                            case 2:
                                itemsOrder.addItems(new MediumMasalaPizza());
                                break;

                            case 3:
                                itemsOrder.addItems(new LargeMasalaPizza());
                                break;

                            case 4:
                                itemsOrder.addItems(new ExtraLargeMasalaPizza());
                                break;

                        }

                    }
                    break;

                }

            }
            break;// Veg- pizza choice completed.

            case 2: {
                System.out.println("You ordered Non-Veg Pizza");
                System.out.println("\n\n");

                System.out.println("Enter the Non-Veg pizza size");
                System.out.println("------------------------------------");
                System.out.println("    1. Small Non-Veg  Pizza ");
                System.out.println("    2. Medium Non-Veg  Pizza ");
                System.out.println("    3. Large Non-Veg  Pizza ");
                System.out.println("    4. Extra-Large Non-Veg  Pizza ");
                System.out.println("------------------------------------");


                int nonvegpizzasize = Integer.parseInt(br.readLine());

                switch (nonvegpizzasize) {

                    case 1:
                        itemsOrder.addItems(new SmallNonVegPizza());
                        break;

                    case 2:
                        itemsOrder.addItems(new MediumNonVegPizza());
                        break;

                    case 3:
                        itemsOrder.addItems(new LargeNonVegPizza());
                        break;

                    case 4:
                        itemsOrder.addItems(new ExtraLargeNonVegPizza());
                        break;
                }

            }
            break;
            default: {
                break;

            }

        }//end of main Switch

        //continued?..
        System.out.println(" Enter the choice of ColdDrink ");
        System.out.println("============================");
        System.out.println("        1. Pepsi            ");
        System.out.println("        2. Coke             ");
        System.out.println("        3. Exit             ");
        System.out.println("============================");
        int coldDrink = Integer.parseInt(br.readLine());
        switch (coldDrink) {
            case 1: {
                System.out.println("You ordered Pepsi ");
                System.out.println("Enter the  Pepsi Size ");
                System.out.println("------------------------");
                System.out.println("    1. Small Pepsi ");
                System.out.println("    2. Medium Pepsi ");
                System.out.println("    3. Large Pepsi ");
                System.out.println("------------------------");
                int pepsisize = Integer.parseInt(br.readLine());
                switch (pepsisize) {
                    case 1:
                        itemsOrder.addItems(new SmallPepsi());
                        break;

                    case 2:
                        itemsOrder.addItems(new MediumPepsi());
                        break;

                    case 3:
                        itemsOrder.addItems(new LargePepsi());
                        break;

                }
            }
            break;
            case 2: {
                System.out.println("You ordered Coke");
                System.out.println("Enter the Coke Size");
                System.out.println("------------------------");
                System.out.println("    1. Small Coke ");
                System.out.println("    2. Medium Coke  ");
                System.out.println("    3. Large Coke  ");
                System.out.println("    4. Extra-Large Coke ");
                System.out.println("------------------------");

                int cokesize = Integer.parseInt(br.readLine());
                switch (cokesize) {
                    case 1:
                        itemsOrder.addItems(new SmallCoke());
                        break;

                    case 2:
                        itemsOrder.addItems(new MediumCoke());
                        break;

                    case 3:
                        itemsOrder.addItems(new LargeCoke());
                        break;


                }

            }
            break;
            default: {
                break;

            }

        }//End of the Cold-Drink switch
        return itemsOrder;
    }
}


public class BuilderPatternRealWorld {
    public static void main(String[] args) throws IOException {
        OrderBuilder builder=new OrderBuilder();

        OrderedItems orderedItems=builder.preparePizza();

        orderedItems.showItems();

        System.out.println("\n");
        System.out.println("Total Cost : "+ orderedItems.getCost());
    }
}
