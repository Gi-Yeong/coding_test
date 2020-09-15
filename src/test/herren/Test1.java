package test.herren;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test1 {
    /*1. 랜덤한 숫자를 n개를 받아서 정렬(내림차순)해주세요.
    input(첫번째 입력은 숫자의 갯수, 두번째는 정렬할 데이터)
    5
        1,8,3,6,5
    output
        8,6,5,3,1
    */
    public static void main(String[] args) {
        System.out.print("첫번째 입력은 숫자의 갯수, 두번째는 정렬할 데이터");

        Scanner scanner = new Scanner(System.in);

        System.out.print("갯수를 입력 하세요: ");
        int firstNum = scanner.nextInt();

        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < firstNum; i++) {
            System.out.print("정렬할 데이터를 입력해주세요: ");
            int data = scanner.nextInt();
            inputList.add(data);
        }

        System.out.println("input: " + inputList);

        List<Integer> resultList = inputList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("output: " + resultList);
    }
}
