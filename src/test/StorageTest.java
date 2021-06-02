package test;

import com.company.Exceptions.ContainerFullException;
import com.company.Exceptions.NotExistingFactoryTypeException;
import com.company.Exceptions.NotExistingTypeOfOrderException;
import com.company.Exceptions.ProductNotExistException;
import com.company.Manager;
import com.company.Order.Delivery;
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
    OrderFactory orderFactory;

    @Test
    public void InitializationTest() throws NotExistingFactoryTypeException {
        warehouse = Warehouse.getInstance();
        itProductFactory = AbstractFactory.getProductFactory("IT");
        clothesProductFactory = AbstractFactory.getProductFactory("Clothes");
        accessoriesProductFactory = AbstractFactory.getProductFactory("Accessories");
        orderFactory = new OrderFactoryImpl();

        assertNotNull(warehouse);
        assertNotNull(itProductFactory);
        assertNotNull(clothesProductFactory);
        assertNotNull(accessoriesProductFactory);
        assertNotNull(orderFactory);
    }

    @Test
    public void isITFactorySingletonTest() {
        ProductFactory expected = itProductFactory;
        ProductFactory actual = ITProductFactory.getInstance();
        boolean isFactoriesEqual = expected.equals(actual);
        assertTrue(isFactoriesEqual);
    }

    @Test(expectedExceptions = NotExistingFactoryTypeException.class)
    public void getNotExistingFactoryTypeTest() throws NotExistingFactoryTypeException {
        itProductFactory = AbstractFactory.getProductFactory("Food");
    }

    @Test
    public void createITProductByFactoryTest() throws ProductNotExistException {
        Product expected = new Laptop(180000);
        Product actual = itProductFactory.createProduct("laptop", 180000);
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test(expectedExceptions = ProductNotExistException.class)
    public void createNotExistingITProductByFactoryTest() throws ProductNotExistException {
        Product product = itProductFactory.createProduct("RAM", 90000);
    }

    @Test
    public void addITProductToWarehouseTest() throws ProductNotExistException, ContainerFullException {
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
    public void packProductTest() throws ProductNotExistException {
        Product expected = new AddressSticker(new PolystyrenePieces(new CardBoardBox(itProductFactory.createProduct("Laptop", 180000))));
        Product actual = new Delivery(itProductFactory.createProduct("Laptop", 180000)).packProduct();

        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test
    public void createOrderTest() throws ProductNotExistException, ContainerFullException, NotExistingTypeOfOrderException {
        Product product = itProductFactory.createProduct("Laptop", 180000);
        Manager manager = new Manager(orderFactory);
        orderFactory.createOrder("delivery", product);
        assertEquals(1, manager.getSoldProducts());
    }

    @Test(expectedExceptions = NotExistingTypeOfOrderException.class)
    public void createNotExistingOrderTest() throws ProductNotExistException, NotExistingTypeOfOrderException, ContainerFullException {
        Product product = clothesProductFactory.createProduct("Jeans", 3000);
        orderFactory.createOrder("personalReceipt", product);
    }

    @Test(expectedExceptions = ContainerFullException.class)
    public void containerFullTest() throws ProductNotExistException, ContainerFullException {
        for (int i = 0; i <= 20; i++) {
            if(i % 2 == 0) {
                warehouse.addProduct(itProductFactory.createProduct("Laptop", (int) (Math.random() * 150000) + 100000));
            }
            else {
                warehouse.addProduct(itProductFactory.createProduct("Processor", (int) (Math.random() * 90000) + 40000));
            }
        }
    }
}
