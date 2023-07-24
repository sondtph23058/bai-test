package com.example.demo;
import java.util.HashMap;
public class Test {


        public static void main(String[] args) {
            String input = "hwfdawhwhcoomddfgwdc"; // Thay đổi chuỗi Latin tại đây
            int count = countVietnameseCharacters(input);
            System.out.println("Số lượng chữ cái Tiếng Việt có thể tạo thành: " + count);
        }

        public static int countVietnameseCharacters(String input) {
            HashMap<String, String> conversions = new HashMap<>();
            conversions.put("aw", "ă");
            conversions.put("aa", "â");
            conversions.put("dd", "đ");
            conversions.put("ee", "ê");
            conversions.put("oo", "ô");
            conversions.put("ow", "ơ");
            conversions.put("w", "ư");

            int count = 0;
            int i = 0;
            while (i < input.length()) {
                int remainingLength = input.length() - i;

                // Kiểm tra xem có thể tạo thành chữ cái 2 ký tự không
                if (remainingLength >= 2) {
                    String twoChars = input.substring(i, i + 2);
                    if (conversions.containsKey(twoChars)) {
                        count++;
                        i += 2;
                        continue;
                    }
                }

                // Kiểm tra xem có thể tạo thành chữ cái 1 ký tự không
                String oneChar = input.substring(i, i + 1);
                if (conversions.containsKey(oneChar)) {
                    count++;
                }

                i++;
            }

            return count;
        }
    }
