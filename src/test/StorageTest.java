package test;

import com.company.Manager;
import com.company.Order.Delivery;
import com.company.Order.Order;
import com.company.Order.OrderFactory;
import com.company.Order.OrderFactoryImpl;
import com.company.Packing.AddressSticker;
import com.company.Packing.CardBoardBox;
import com.company.Packing.PolystyrenePieces;
import com.company.Products.AbstractFactory;
import com.company.Products.IT.ITProductFactory;
import com.company.Products.IT.Laptop;
import com.company.Products.Product;
import com.company.Products.ProductFactory;
import com.company.Storage.Container;
import com.company.Storage.Iterator;
import com.company.Storage.Warehouse;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class StorageTest extends TestCase {
    Container warehouse;
    ProductFactory itProductFactory;
    ProductFactory clothesProductFactory;
    ProductFactory accessoriesProductFactory;

    @Test
    public void InitializationTest() {
        warehouse = Warehouse.getInstance();
        itProductFactory = AbstractFactory.getProductFactory("IT");
        clothesProductFactory = AbstractFactory.getProductFactory("Clothes");
        accessoriesProductFactory = AbstractFactory.getProductFactory("Accessories");

        assertNotNull(warehouse);
        assertNotNull(itProductFactory);
        assertNotNull(clothesProductFactory);
        assertNotNull(accessoriesProductFactory);
    }

    @Test
    public void isITFactorySingletonTest() {
        ProductFactory expected = itProductFactory;
        ProductFactory actual = ITProductFactory.getInstance();
        boolean isFactoriesEqual = expected.equals(actual);
        assertTrue(isFactoriesEqual);
    }

    @Test
    public void createITProductByFactoryTest() {
        Product expected = new Laptop(180000);
        Product actual = itProductFactory.createProduct("laptop", 180000);
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test
    public void addITProductToWarehouseTest() {
        Product actual = itProductFactory.createProduct("laptop", 180000);
        warehouse.addProduct(actual);
        boolean hasInStorage = false;

        Iterator iterator = warehouse.createIterator();
        while(iterator.hasNext()) {
            Product product = (Product) iterator.next();
            if(actual.equals(product)) {
                hasInStorage = true;
                break;
            }
        }

        assertTrue(hasInStorage);
    }

    @Test
    public void packProductTest() {
        Product expected = new AddressSticker(new PolystyrenePieces(new CardBoardBox(itProductFactory.createProduct("Laptop", 180000))));
        Product actual = new Delivery(itProductFactory.createProduct("Laptop", 180000)).packProduct();

        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test
    public void createOrderTest(){
        Product product = itProductFactory.createProduct("Laptop", 180000);
        OrderFactory orderFactory = new OrderFactoryImpl();
        Manager manager = new Manager(orderFactory);
        orderFactory.createOrder("delivery", product);
        assertEquals(1, manager.getSoldProducts());
    }
}
