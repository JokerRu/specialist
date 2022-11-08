package com.company;

public class Main {

    public static void main(String[] args) {
	// Конвертор целых чисел в двоичную систему
        int[] arr = {-2, 2, 127, 32456,  -53672};
        for (int num : arr) {
            System.out.println("Number = " + num + "; binary = " + Binary.getBinary(num) + ";");
        }
    }
}

class Binary {
    static String getBinary(int number) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index <= 31; index++) {
            sb.append(number & 1);
            number >>= 1;
            if (index == 7 || index == 15 || index == 23) {
                sb.append(" ");
            }
        }
        return sb.reverse().toString();
    }
}
