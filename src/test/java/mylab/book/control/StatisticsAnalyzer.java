package mylab.book.control;

import java.text.DecimalFormat;
import java.util.*;

import mylab.book.entity.*;

public class StatisticsAnalyzer {
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");

        System.out.println("===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        avgPrice.forEach((k,v) -> System.out.println("   - " + k + ": " + df.format(v) + "원"));
        System.out.println("\n2. 출판물 유형 분포:");
        dist.forEach((k,v) -> System.out.println("   - " + k + ": " + String.format("%.2f", v) + "%"));
        System.out.printf("\n3. 2007년에 출판된 출판물 비율: %.2f%%\n", ratio2007);
        System.out.println("=============================");
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] pubs) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (Publication p : pubs) {
            String t = getType(p);
            sum.put(t, sum.getOrDefault(t, 0) + p.getPrice());
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Map<String, Double> result = new HashMap<>();
        sum.forEach((k, v) -> result.put(k, v / (double) count.get(k)));
        return result;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] pubs) {
        Map<String, Integer> count = new HashMap<>();
        for (Publication p : pubs) {
            String t = getType(p);
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Map<String, Double> result = new HashMap<>();
        for (String key : count.keySet()) {
            result.put(key, 100.0 * count.get(key) / pubs.length);
        }
        return result;
    }

    public double calculatePublicationRatioByYear(Publication[] pubs, String year) {
        long match = Arrays.stream(pubs)
            .filter(p -> p.getPublishDate().startsWith(year))
            .count();
        return 100.0 * match / pubs.length;
    }

    private String getType(Publication p) {
        if (p instanceof Magazine) return "잡지";
        if (p instanceof Novel) return "소설";
        if (p instanceof ReferenceBook) return "참고서";
        return "기타";
    }
}