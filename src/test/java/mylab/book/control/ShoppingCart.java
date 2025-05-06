package mylab.book.control;

import java.util.*;

import mylab.book.entity.*;

public class ShoppingCart {
    private List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println("추가됨: " + item.getTitle());
    }

    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println("제거됨: " + title);
                return true;
            }
        }
        System.out.println("제거 실패: " + title);
        return false;
    }

    public void displayCart() {
        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();
        System.out.println("==== 장바구니 ====");
        for (Publication item : items) {
            System.out.println(item);
        }
        System.out.printf("총 가격: %,d원\n", total);
        System.out.printf("할인 적용 가격: %,d원\n", discounted);
    }

    public int calculateTotalPrice() {
        return items.stream().mapToInt(Publication::getPrice).sum();
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication p : items) {
            double rate = 1.0;
            if (p instanceof Magazine) rate = 0.9;
            else if (p instanceof Novel) rate = 0.85;
            else if (p instanceof ReferenceBook) rate = 0.8;
            total += (int)(p.getPrice() * rate);
        }
        return total;
    }

    public void printStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        for (Publication p : items) {
            String type = (p instanceof Magazine) ? "잡지" :
                          (p instanceof Novel) ? "소설" :
                          (p instanceof ReferenceBook) ? "참고서" : "기타";
            stats.put(type, stats.getOrDefault(type, 0) + 1);
        }
        System.out.println("=== 장바구니 통계 ===");
        stats.forEach((k, v) -> System.out.println(k + ": " + v + "개"));
    }
}