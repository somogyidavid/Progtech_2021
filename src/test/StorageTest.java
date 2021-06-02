package test;

import com.company.Exceptions.*;
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
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StorageTest {
    static Container warehouse;
    static ProductFactory itProductFactory;
    static ProductFactory clothesProductFactory;
    static ProductFactory accessoriesProductFactory;
    static OrderFactory orderFactory;

    @BeforeClass
    public static void InitializationTest() throws NotExistingFactoryTypeException {
        warehouse = Warehouse.getInstance();
        itProductFactory = AbstractFactory.getProductFactory("IT");
        clothesProductFactory = AbstractFactory.getProductFactory("Clothes");
        accessoriesProductFactory = AbstractFactory.getProductFactory("Accessories");
        orderFactory = new OrderFactoryImpl(warehouse);

        Assert.assertNotNull(warehouse);
        Assert.assertNotNull(itProductFactory);
        Assert.assertNotNull(clothesProductFactory);
        Assert.assertNotNull(accessoriesProductFactory);
        Assert.assertNotNull(orderFactory);
    }

    @Test
    public void isITFactorySingletonTest() {
        ProductFactory expected = itProductFactory;
        ProductFactory actual = ITProductFactory.getInstance();
        boolean isFactoriesEqual = expected.equals(actual);
        Assert.assertTrue(isFactoriesEqual);
    }

    @Test(expected = NotExistingFactoryTypeException.class)
    public void getNotExistingFactoryTypeTest() throws NotExistingFactoryTypeException {
        itProductFactory = AbstractFactory.getProductFactory("Food");
    }

    @Test
    public void createITProductByFactoryTest() throws ProductNotExistException {
        Product expected = new Laptop(180000);
        Product actual = itProductFactory.createProduct("laptop", 180000);
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test(expected = ProductNotExistException.class)
    public void createNotExistingITProductByFactoryTest() throws ProductNotExistException {
        itProductFactory.createProduct("RAM", 90000);
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

        Assert.assertTrue(hasInStorage);
    }

    @Test
    public void packProductTest() throws ProductNotExistException {
        Product expected = new AddressSticker(new PolystyrenePieces(new CardBoardBox(itProductFactory.createProduct("Laptop", 180000))));
        Product actual = new Delivery(itProductFactory.createProduct("Laptop", 180000)).packProduct();

        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test
    public void createOrderTest() throws ProductNotExistException, ContainerFullException, NotExistingTypeOfOrderException, WarehouseIsEmptyException {
        int expected = OrderFactoryImpl.getNumberOfOrders() + 1;
        Product product = itProductFactory.createProduct("Laptop", 190000);
        warehouse.addProduct(product);
        Manager manager = new Manager(orderFactory);
        orderFactory.createOrder("delivery", product).packProduct();
        Assert.assertEquals(expected, manager.getSoldProducts());
    }

    @Test(expected = NotExistingTypeOfOrderException.class)
    public void createNotExistingOrderTest() throws ProductNotExistException, NotExistingTypeOfOrderException, ContainerFullException, WarehouseIsEmptyException {
        Product product = clothesProductFactory.createProduct("Jeans", 3000);
        warehouse.addProduct(product);
        orderFactory.createOrder("personalReceipt", product);
    }

    @Test
    public void getProductsFromWarehouseTest() {
        Iterator iterator = warehouse.createIterator();
        int expectedNumberOfItems = warehouse.getNumberOfItems();
        int numberOfItems = 0;

        System.out.println("---PRODUCTS---");
        while(iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.getDescription() + " - " + product.getPrice() + " Ft");
            numberOfItems++;
        }
        System.out.println("--------------");

        Assert.assertEquals(expectedNumberOfItems, numberOfItems);
    }

    @Test
    public void getOrdersFromCourierCarsTest() {
        int id = 0;
        int expected = OrderFactoryImpl.getNumberOfOrders();
        System.out.println("---COURIER CAR---");
        while (id < OrderFactoryImpl.courierCars.size()) {
            Iterator iterator = OrderFactoryImpl.courierCars.get(id).createIterator();
            System.out.println(id + 1 + ". car:");
            while (iterator.hasNext()) {
                Order order = (Order) iterator.next();
                System.out.println("    -" + order.getDescription() + " - " + order.getPrice() + " Ft");
                id++;
            }
        }
        System.out.println("-----------------");

        Assert.assertEquals(expected, id);
    }
}
