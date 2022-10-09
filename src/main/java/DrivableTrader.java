/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

class DrivableTrader extends Trader<Drivable> {
    /**
     * Constructors.
     *
     * @param inventory
     * @param wishlist
     * @param money
     */
    public DrivableTrader(List<Drivable> inventory,
                          List<Drivable> wishlist,
                          int money) {
        super(inventory, wishlist, money);
    }

    //!!! Should the body of constructor be this instead: super(money);
    public DrivableTrader(int money) {
        super(new ArrayList<Drivable>(), new ArrayList<Drivable>(), money);
    }

    /**
     * Overriding the getSellingPrice method from the Super class
     * by modifying it according to the specifications.
     *
     * @param item
     * @return
     */
    @Override
    public int getSellingPrice(Drivable item) {
        if (item instanceof Tradable) {
            return ((Tradable) item).getPrice() + item.getMaxSpeed();
        }
        return Tradable.MISSING_PRICE;
    }
}
