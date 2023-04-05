import java.util.*;

/**
 * The following code prompts the user to enter an option 1 through 8.
 * The option menu is looped until the user wishes to exit.
 */
public class Inventory {
    public static void main(String args[]){
        // Instantiates scanner and menu
        Scanner input = new Scanner(System.in);
        int menu;
        List<Widget> inventory = new ArrayList<>();

        // Do while loop until user exits
        try {
            do {
                System.out.printf("\nHello User, Enter a number from the following prompts!\n\n" +
                        "[1] Add new entry\n[2] Remove an entry\n[3] Search by product name\n[4] Calculate total value of inventory\n"
                        + "[5] Print inventory\n[6] Quit\n");
                menu = input.nextInt();

                //Switch structure
                switch (menu) {
                    case 1:
                        //Asks user to add variables onto object
                        System.out.println("Sku? (Integer) ");
                        int sku = input.nextInt();

                        System.out.println("Production Name? (Single Word) ");
                        String prodName = input.next();

                        System.out.println("Size? (Double)");
                        double size = input.nextDouble();

                        System.out.println("Quantity? (Integer)");
                        int quant = input.nextInt();

                        System.out.println("Price? (Double)");
                        double price = input.nextDouble();

                        //Adds all variables obtained from scanner into object
                        inventory.add(new Widget(sku, prodName, size, quant, price));
                        break;

                    case 2:

                        //Prompts user for Sku and removes object with corresponding Sku
                        System.out.println("What is the sku that you wish to remove?");
                        int x = input.nextInt();
                        Iterator<Widget> widgetIterator = inventory.listIterator();

                        //While there is another object, the object is scanned for corresponding Sku
                        while (widgetIterator.hasNext()) {
                            Widget currentInv = widgetIterator.next();
                            if (currentInv.getSku() == x) {
                                widgetIterator.remove();
                            }
                        }
                        break;
                    case 3:

                        boolean loopKey = false;
                        //Searches for object using product name
                        System.out.println("Product name?");
                        String name = input.next();
                        widgetIterator = inventory.listIterator();
                        //While there is another object, it will be scanned for corresponding product name
                        while (widgetIterator.hasNext() && !loopKey) {
                            Widget currentInv = widgetIterator.next();
                            if (currentInv.getProdName().equalsIgnoreCase(name)) {
                                System.out.println(currentInv);
                                loopKey = true;
                            } else {
                                System.out.println("Could not find product name.");
                            }
                        }
                        break;
                    case 4:
                        //Lambda expression used to calculate total value
                        double totalValue = inventory.stream().mapToDouble(Widget -> Widget.getQuant() * Widget.getPrice()).sum();
                        System.out.println(totalValue);

                        break;
                    case 5:
                        //For loop to print out inventory
                        for (Widget c : inventory)
                            System.out.println(c);
                        break;
                    case 6:
                        //Used to escape loop
                        break;
                    default:
                        //Printed to output if a number 1-6 is not picked
                        System.out.println("[Please enter a number 1-6]");

                }
            } while (menu != 6);
            System.out.println("\nThank you for using my program.\n");
        }catch(Exception e){
            //prints exception to console
            System.out.println(e);
        }
    }
}
