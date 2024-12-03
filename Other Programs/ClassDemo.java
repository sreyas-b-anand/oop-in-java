import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
class ItemList{
    int itemNumber;
    String name;
    double price;
    int quantity;
    ItemList(int n , String name , double  p , int q){
        this.itemNumber = n;
        this.name = name;
        this.price = p;
        this.quantity = q;
    }
}
class ItemStock{
    ArrayList<ItemList> itm;
    ItemStock(){
        itm = new ArrayList<>();
    }
    void addItem(ItemList item){
        itm.add(item);
    }
    void deleteItem(int itemNumber){
        Iterator<ItemList> it = itm.iterator();
        ItemList i;
        while(it.hasNext()){
            
            i = it.next();
            if(itemNumber == i.itemNumber ){
                it.remove();
            }
        }
    }
    void display(){
        Iterator<ItemList> it = itm.iterator();
        Collections.sort(itm , Collections.reverseOrder(Comparator.comparingDouble(item -> item.price)));
        while(it.hasNext()){
            ItemList n = it.next();
            System.out.println("ID : " + n.itemNumber);
            System.out.println("Name : " + n.name);
            System.out.println("Price : + " + n.price);
            System.out.println("Quantity : " + n.quantity);
        }    
    }
}
public class ClassDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemStock itemStock = new ItemStock();
        int choice;

        do {
            System.out.println("\n--- Inventory System Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Delete Item");
            System.out.println("3. Calculate Stock Value");
            System.out.println("4. Display Items in Descending Order of Price");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item number: ");
                    int itemNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    itemStock.addItem(new ItemList(itemNumber, name, price, quantity));
                    break;

                case 2:
                    System.out.print("Enter item number to delete: ");
                    int deleteItemNumber = scanner.nextInt();
                    itemStock.deleteItem(deleteItemNumber);
                    break;

               

                case 4:
                    itemStock.display();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
