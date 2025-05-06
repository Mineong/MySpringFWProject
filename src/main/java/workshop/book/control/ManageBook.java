package workshop.book.control;

import workshop.book.entity.*;

public class ManageBook {
    public static void main(String[] args) {
        Publication[] books = new Publication[] {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i+1) + ". " + books[i]);
        }

        Publication target = books[6];
        int before = target.getPrice();
        modifyPrice(target);
        int after = target.getPrice();
        System.out.println("\n==== 가격 변경 ====");
        System.out.printf("%s 변경 전 가격: %,d원\n", target.getTitle(), before);
        System.out.printf("%s 변경 후 가격: %,d원\n", target.getTitle(), after);
        System.out.printf("차액: %,d원\n", before - after);

        StatisticsAnalyzer sa = new StatisticsAnalyzer();
        sa.printStatistics(books);
    }

    private static void modifyPrice(Publication pub) {
        if (pub instanceof Magazine) pub.setPrice((int)(pub.getPrice() * 0.6));
        else if (pub instanceof Novel) pub.setPrice((int)(pub.getPrice() * 0.8));
        else if (pub instanceof ReferenceBook) pub.setPrice((int)(pub.getPrice() * 0.9));
    }
}