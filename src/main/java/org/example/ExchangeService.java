package org.example;

import java.util.*;

public class ExchangeService {

    public static void main(String[] args) {

        Map<String, Integer> productMap = new HashMap<>();
        Map<String, List<String>> storeMap = new HashMap<>();
        Integer stock = 0;
        try {
            storeMap.put("aaaaaa", Arrays.asList("012345678", "012345677"));
            storeMap.put("aaaaab", Arrays.asList("012345678", "012345677", "012345676"));
            storeMap.put("aaaaaf", Arrays.asList("012345678"));
            storeMap.put("aaaaag", Arrays.asList("012345678"));
            storeMap.put("aaaaah", Arrays.asList("012345678"));
            storeMap.put("aaaaai", Arrays.asList("012345678"));
            storeMap.put("aaaaaj", Arrays.asList("012345678"));
            storeMap.put("aaaaaA", Arrays.asList("012345678"));

            productMap.put("012345678", 10);
            productMap.put("012345677", 0);
            productMap.put("012345676", 20);
        } catch (Exception e) {

        }

        System.out.println("=====ExchangeService=====");

        // 고객 입력
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();
            String[] action = input.split(" ");
            String command = action[0].toUpperCase();

            if (command.equals("CHECK")) {
                // check : 현재 재고량 확인
                // check + [상품 코드]
                if (verifyProductCode(action)) {
                    String productCode = action[1];
                    // 재고확인
                    stock = productMap.get(productCode);
                    System.out.println("Products remained : " + stock);
                } else {
                    displayHelp();
                }
            } else if (command.equals("CLAIM")) {
                // claim : 상품 교환
                // claim + [상점 코드] + [상품 코드]
                String productCode = action[2];
                String storeCode = action[1];
                if (verifyStoreCode(action)) {
                    // 상점 재고 확인
                    stock = productMap.get(productCode);
                    if (verifyStoreCode(action)) {
                        // 재고확인
                        System.out.println("Products remained : " + stock);
                        // case 1 : 차감
                        if (stock > 0) {
                            productMap.put(productCode, stock - 1);
                            System.out.println("Products remained : " + (stock - 1));
                        } else if (stock <= 0) {
                            // case 2 : 불가 안내
                            System.out.println("There is no stock here.");
                        } else {
                            displayHelp();
                        }
                    } else {
                        displayHelp();
                    }
                } else {
                    displayHelp();
                }
            } else {
                displayHelp();
            }
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
        System.out.println("  EX2 ) CLAIM qwer12 123i1 => wrong");
    }

    // 상품 코드 유효성 검사
    public static boolean verifyProductCode(String[] action) {
        if (action.length < 2) {
            return false;
        }
        String productCode = action[1];
        if (productCode.length() != 9) {
            return false;
        }
        try {
            Long.parseLong(productCode);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // 상점 코드 유효성 검사
    public static boolean verifyStoreCode(String[] action) {
        if (action.length < 3) {
            return false;
        }
        String storeCode = action[1];
        if (storeCode.length() != 6) {
            return false;
        }
        for (int i = 0; i < storeCode.length(); i++) {
            char c = storeCode.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        String productCode = action[2];
        if (productCode.length() != 9) {
            return false;
        }
        try {
            Long.parseLong(productCode);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

