package mylab.order.di.xml;

public class OrderService {
    private ShoppingCart shoppingCart; // 의존성 주입 대상

    // 기본 생성자
    public OrderService() {}

    // Getter, Setter
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // 총 주문 금액 계산
    public double calculateOrderTotal() {
        return shoppingCart.getTotalPrice();
    }
}
