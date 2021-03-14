package javaInAction.partTwo.chapter5.dotSix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-03-14
 * description
 */
public class DotSixCaller {

    private static List<Transaction> transactions;

    static {
        Trader raoul = Trader.of("Raoul", "Cambridge");
        Trader mario = Trader.of("Mario", "Milan");
        Trader alan = Trader.of("Alan", "Cambridge");
        Trader brian = Trader.of("Brian", "Cambridge");

        transactions = new ArrayList<>();
        transactions.add(Transaction.of(brian, 2011, 300));
        transactions.add(Transaction.of(raoul, 2012, 1000));
        transactions.add(Transaction.of(raoul, 2011, 400));
        transactions.add(Transaction.of(mario, 2012, 710));
        transactions.add(Transaction.of(mario, 2012, 700));
        transactions.add(Transaction.of(alan, 2012, 950));
    }

    public static void main(String[] args) {

        // answer 1
        int targetYear = 2011;
        List<Integer> answer1 = transactions.stream()
                .filter(t -> t.getYear() == targetYear)
                .map(Transaction::getValue)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(answer1);

        // answer 2
        List<String> answer2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        // answer 2 from author
        // 한 번 에 값 꺼내오기
        List<String> answer2Plus = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(answer2);

        // answer 3
        String targetCity = "Cambridge";
        List<String> answer3 = transactions.stream()
                .filter(t -> {
                    return t.getTrader().getCity().equals(targetCity);
                })
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        // answer3 from author
        // sort 좀 제대로 하기
        List<String> answer3Plus = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals(targetCity))
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(answer3);

        // answer 4
        String answer4 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.joining(","));

        System.out.println(answer4);

        // answer 5
        String targetCity2 = "Milan";
        boolean answer5 = transactions.stream()
                        .anyMatch( t-> {
                            return t.getTrader().getCity().equals(targetCity2);
                        });

        System.out.println(answer5);

        // answer 6
        String targetCity3 = "Cambridge";
        int answer6 = transactions.stream()
                .filter(t -> {
                    return t.getTrader().getCity().equals(targetCity3);
                })
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);

        System.out.println(answer6);

        // answer 7
        int answer7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);

        System.out.println(answer7);

        // answer 8
        int answer8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .orElse(0);

        System.out.println(answer8);

    }
}
