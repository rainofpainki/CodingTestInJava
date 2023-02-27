package org.codingTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SortingNumbers {

    /**
     * 1~1000000 사이의 수인지 체크한다.
     * @param number
     * @return
     */
    public static boolean checkNumberRange(Integer number) {
        if(number < 1 || number > 1000000) {
            System.out.println("1부터 1,000,000 사이의 수를 입력하세요.");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 생성할 List의 크기를 입력받는다.
     * @param scanner
     * @return
     */
    public static Integer inputSize(Scanner scanner) {
        Integer size;
        do {
            System.out.print("입력할 수의 개수를 입력하세요.(1 ~ 100,000) : ");
            size = scanner.nextInt();
            scanner.nextLine();
        } while(checkNumberRange(size));
        return size;
    }

    /**
     * 숫자를 입력받는다.
     * @param scanner
     * @param index
     * @return
     */
    public static Integer inputNumber(Scanner scanner, int index) {
        Integer number;
        do {
            System.out.print(index +"번째 수를 입력하세요. : ");
            number = scanner.nextInt();
            scanner.nextLine();
        } while(checkNumberRange(number));
        return number;
    }

    /**
     * 사이즈와 해당 크기의 숫자 배열을 입력받는다.
     * @return
     */
    public static List<Integer> inputNumbers() {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in) ) {
            Integer size = inputSize(scanner);
            for(int i = 0; i<size; i++) {
                list.add(i, inputNumber(scanner, i+1));
            }

        } catch(InputMismatchException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 버블 정렬
     * @param list
     * @return
     */
    public static List<Integer> bubbleSort(List<Integer> list) {
        int size = list.size();
        for(int i = size-1; i > 0; i--) {

            for(int j = 0; j < i; j++) {
                Integer number = list.get(j);
                Integer target = list.get(j+1);
                if(number > target) {
                    list.set(j+1, number);
                    list.set(j, target);
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {

        List<Integer> list = inputNumbers();
        list = bubbleSort(list);
        list.stream().forEach(number -> System.out.println(number));


    }
}
