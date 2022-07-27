import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();
    private List<Item> selectedItemsFromMenu = new ArrayList<>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime currentTime = LocalTime.now();
        if(currentTime.isAfter(closingTime) || currentTime.isBefore(openingTime)){
            return false;
        }
        return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public List<Item> getMenu() {
        if(menu.isEmpty()){
            return null;
        }
        return menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
/*

    //to generate a list of selected items from the menu
    public void selectItemsFromMenu(String name){
        selectedItemsFromMenu.add(findItemByName(name));
    }

    //to get the total amount of items selected
    public int getTotal(){
        int total = 0;
        for(Item item : selectedItemsFromMenu){
            total = total + item.getPrice();
        }
        return total;
    }
*/

}
