package com.training.jc.hw12;

import java.util.Scanner;

public class Calc {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int sumOfPrimesLessThan(int n) {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        boolean isValidInput;

        do {
            System.out.print("Введите простое число (>1): ");
            n = scanner.nextInt();
            
            if (n <= 1) {
                System.out.println("Число должно быть больше 1!");
                isValidInput = false;
            } else if (!isPrime(n)) {
                System.out.println("Число " + n + " не является простым. Попробуйте еще раз.");
                isValidInput = false;
            } else {
                isValidInput = true;
            }
        } while (!isValidInput);

        System.out.println("Число " + n + " является простым.");
        int sum = sumOfPrimesLessThan(n);
        System.out.println("Сумма всех простых чисел, меньших " + n + ", равна " + sum + ".");

        scanner.close();
    }
}