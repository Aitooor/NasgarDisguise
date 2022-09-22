package online.nasgar.disguise.menu;

import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class MenuHandler {
    public static boolean clickedTopInventory(InventoryDragEvent event) {
        InventoryView view = event.getView();
        Inventory topInventory = view.getTopInventory();
        if (topInventory == null) {
            return false;
        }
        boolean result = false;
        int size = topInventory.getSize();
        for (Integer entry : event.getNewItems().keySet()) {
            if (entry >= size) continue;
            result = true;
            break;
        }
        return result;
    }
}
