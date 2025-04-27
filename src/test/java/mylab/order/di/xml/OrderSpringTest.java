package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderSpringTest {

    @Test
    public void testShoppingCart() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-order-di.xml");
        ShoppingCart cart = (ShoppingCart) context.getBean("shoppingCart");

        assertNotNull(cart, "ShoppingCart 빈이 주입되지 않았습니다.");
        
        List<Product> products = cart.getProducts();
        assertNotNull(products, "Product 리스트가 비어있습니다.");
        assertEquals(2, products.size(), "Product 리스트 크기가 다릅니다.");
        
        double totalPrice = cart.getTotalPrice();
        assertEquals(3000.0, totalPrice, 0.01, "총 가격 계산이 다릅니다.");
    }

    @Test
    public void testOrderService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-order-di.xml");
        OrderService service = (OrderService) context.getBean("orderService");

        assertNotNull(service, "OrderService 빈이 주입되지 않았습니다.");
        assertNotNull(service.getShoppingCart(), "OrderService의 ShoppingCart가 주입되지 않았습니다.");

        double orderTotal = service.calculateOrderTotal();
        assertEquals(3000.0, orderTotal, 0.01, "주문 총액 계산이 다릅니다.");
    }
}
