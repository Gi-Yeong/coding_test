package test.herren;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {
    /*4. 입력된 문자열 중에 더해서 10이 되는 숫자의 조합의 갯수를 출력하시오.
    숫자는 모두 한자리 숫자만 사용, 같은 조합은 1번으로 판단, 각 숫자는 한번씩만 사용해야 합니다.

    input apdkf35k47n1t2
    ouput 5

    ( 1,2,3,4 / 1,2,7 / 1,4,5 / 2,3,5 / 3,7 )*/
    static final int COMBINATION_NUMBER = 10;
    static int COUNT = 0;

    public static void main(String[] args) {
        String inputString = "apdkf35k47n1t2";

        extractNumber(inputString.trim());
    }

    private static void extractNumber(String inputString) {
        System.out.println("입력된 문자열: " + inputString);
        System.out.println(inputString.length());

        List<Integer> intArr = Stream.of(inputString.replaceAll("[^0-9]", "").split(""))
                .mapToInt(Integer::parseInt)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        System.out.println(intArr);
        System.out.println();

        boolean[] check = new boolean[intArr.size()];
        makeCombination(intArr, check, 0, intArr.size());
        System.out.println(COUNT);
    }

    public static void makeCombination(List<Integer> intArr, boolean[] check, int index, int end) {
        if (index >= end) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < end; i++) {
                if (check[i]) {
                    temp.add(intArr.get(i));
                    sum += intArr.get(i);
                }
            }
            if (sum == COMBINATION_NUMBER) {
                COUNT++;
                System.out.println(temp + " = " + sum);
            }
            return;
        }

        // "내가 없을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
        check[index] = false;
        makeCombination(intArr, check, index + 1, end);

        // "내가 있을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
        check[index] = true;
        makeCombination(intArr, check, index + 1, end);
    }
}
