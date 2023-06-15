package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class PaChinKoService {

    private static int fee = 100;
    private static Integer wallet = 0;
    private static String item;
    private static SimpleDateFormat dnt = new SimpleDateFormat("yyyy/MM/dd");
    private static Date today = new Date();
    private static Date expiredTerm;

    public PaChinKoService(String item, Date expiredTerm) {
        this.item = item;
        this.expiredTerm = expiredTerm;
    }

    private static Integer charge = 10000;
    private static int bCount = 0;

    public static void main(String[] args) throws ParseException {
        // 테스트 데이터
        List<PaChinKoService> example = new ArrayList<>();
        try {
            example.add(new PaChinKoService("A", dnt.parse("2023/06/01")));
            example.add(new PaChinKoService("A", dnt.parse("2023/06/01")));
            example.add(new PaChinKoService("A", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("A", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("B", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("A", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("A", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("B", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("A", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("A", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("A", dnt.parse("2023/07/07")));
            example.add(new PaChinKoService("B", dnt.parse("2023/07/07")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(dnt.format(today));
        System.out.println("Let's start PachinKoService");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String command = input.toLowerCase();
            // DRAW
            if (command.equals("draw")) {
                // 금액이 없을 때
                if (wallet <= 0) {
                    System.out.println("please re-fill money");
                } else {
                    // 금액이 있을 때 -> 몇번
                    System.out.println("How many times do you want to try? : ");
                    Integer attemptTime = scanner.nextInt();
                    for (int i = 1; i <= attemptTime; i++) {
                        if (wallet - (fee * (attemptTime - i)) >= 0) {
                            // A, B, 꽝 상품 경우, 유통기한 확인
//                            // 테스트케이스 반복(무제한)
//                             PaChinKoService paChinKoService = example.get(1% example.size());
                            // 테스트케이스 개수 만큼만
                            try {
                                PaChinKoService paChinKoService = example.get(i - 1);
                                boolean expired = paChinKoService.checkExpiredTime();
                                String result = draw();
                                if (expired) {
                                    System.out.println("You Got Prize!! : " + result);
                                } else {
                                    System.out.println("The ExpiredDate is out of Limit");
                                    attemptTime--;
                                }
                            } catch (Exception e){
                                System.out.println("boom");
                            }
                        } else {
                            // 시도가 오버되었을 때
                            System.out.println("check your wallet");
                        }
                    }
                }
            } else if (command.equals("charge")) {
                // 충전
                wallet += charge;
                System.out.println(wallet);
            } else if (command.equals("wallet")) {
                // 잔액 확인
                System.out.println(wallet);
            } else {
                System.out.println("Please Type Right Command");
            }
        }
    }

    private static String draw() {
        wallet -= fee;
        Random random = new Random();
        double probability = random.nextDouble();
        // A등급 (90%) B등급(10%, 최대 3번)
        // A -> B -> 꽝
        if (probability < 0.9) {
            return "A";
        } else if (bCount < 3) {
            bCount++;
            return "B";
        } else {
            return "boom";
        }
    }

    // 유효기간 검증
    private static boolean checkExpiredTime() {
        if (expiredTerm.before(today)) {
            return false;
        }
        return true;
    }
}
