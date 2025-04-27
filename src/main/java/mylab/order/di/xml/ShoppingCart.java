package mylab.order.di.xml;

import java.util.List;

public class ShoppingCart {
    private List<Product> products; // 장바구니에 담긴 상품들

    // 기본 생성자
    public ShoppingCart() {}

    // Getter, Setter
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // 전체 가격 계산 메서드
    public double getTotalPrice() {
        double total = 0.0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}
