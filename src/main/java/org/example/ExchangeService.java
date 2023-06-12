package org.example;

import java.util.*;

public class ExchangeService {

    private static Map<String, Integer> productMap = new HashMap<>();
    private static String productCode;
    private static String storeCode;
    private static Integer stock = 0;

    // 고객 입력
    private static Scanner scanner = new Scanner(System.in);
    private static String input = scanner.nextLine();
    private static final String[] action = input.split(" ");
    private static String command = action[0].toUpperCase();

    public static void main(String[] args) {
        if (command.equals("CHECK")) {
            // check : 현재 재고량 확인
            // check + [상품 코드]
            if (verifyProductCode()) {
                // 재고확인
                stock = productMap.get(productCode);
                System.out.println("Products remained : " + stock);
            }
            displayHelp();
        } else if (command.equals("CLAIM")) {
            // claim : 상품 교환
            // claim + [상점 코드] + [상품 코드]
            if (verifyStoreCode()) {
                // 상점 재고 확인
                if (verifyProductCode()) {
                    // 재고확인
                    stock = productMap.get(productCode);
                    System.out.println("Products remained : " + stock);
                }
                // case 1 : 차감
                stock = productMap.get(productCode);
                productMap.put(productCode, stock - 1);
                // case 2 : 불가 안내
                if (stock <= 0) {
                    System.out.println("There is no stock here.");
                }
            }
            displayHelp();
        } else {
            displayHelp();
        }
    }


    // help : 사용법 안내
    public static void displayHelp() {
        System.out.println("===Please Re-Check How To Use This Program.===");
        System.out.println("===CHECK : CHECK + [Product Code]===");
        System.out.println("If you wanna to check stock, you should use 'CHECK' command.");
        System.out.println(
                "1. You should use write 'CHECK' and 'Product Code' and there is  one space between two of them.");
        System.out.println("2. Product Code has to combine only NUMBERS(0~9) and it is only 9.");
        System.out.println("  EX1 ) CHECK 123456 => right");
        System.out.println("  EX2 ) CHECK123i1 => wrong");
        System.out.println("===HELP : HELP , Introduce How To Use This Program.===");
        System.out.println("===CLAIM : CLAIM + [Store Code] + [Product Code]===");
        System.out.println("1. If you wanna to get product, you should use 'CLAIM' command.");
        System.out.println(
                "2. You should use write 'CLAIM', 'Store Code' and 'Product Code' and there is one space between each of them.");
        System.out.println("3. Product Code has to combine only NUMBERS.");
        System.out.println("  EX1 ) CLAIM asdfgh 123456 => right");
        System.out.println("  EX2 ) CHECK qwer12 123i1 => wrong");
    }

    // 상품 코드 유효성 검사
    public static boolean verifyProductCode() {
        if (command.equals("CHECK")) {
            String productCode = action[1];
            if (productCode.length() != 9) {
                return false;
            }
            for (int i = 0; i < productCode.length(); i++) {
                try {
                    int parsedNumber = Integer.parseInt(productCode);

                    if (parsedNumber <= 0) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }

    // 상점 코드 유효성 검사
    public static boolean verifyStoreCode() {
        if (command.equals("CLAIM")) {
            String storeCode = action[1];
            if (storeCode.length() != 6) {
                return false;
            }
            for (int i = 0; i < storeCode.length(); i++) {
                try {
                    if (storeCode.charAt(i) <= 'a' || storeCode.charAt(i) >= 'z') {
                        return false;
                    } else if (storeCode.charAt(i) <= 'A' || storeCode.charAt(i) >= 'Z') {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
            String productCode = action[2];
            if (productCode.length() != 9) {
                return false;
            }
            for (int i = 0; i < productCode.length(); i++) {
                try {
                    int parsedNumber = Integer.parseInt(productCode);

                    if (parsedNumber <= 0) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }
}
