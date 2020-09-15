package test.herren;

public class Test2 {
    /*2. 입력된 한글 문장에서 초성만 출력하세요.
    input
        우리나라 만세
    output
        ㅇㄹㄴㄹ ㅁㅅ*/

    private static final char[] firstSounds = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ',
            'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ',
            'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    public static void main(String[] args) {
        String text = "우리나라 만세";

        for (int i = 0; i < text.length(); i++) {
            System.out.print(getFirstElement(text.charAt(i)));
        }
    }

    public static char getFirstElement(char character) {
        /*초성의 인덱스 : (문자 - 0xAC00) / 21 * 28
        중성의 인덱스 : (문자 - 0xAC00 - (초성 인덱스 * 21 * 28)) / 28
        종성의 인덱스 : (문자 - 0xAC00 - (초성 인덱스 * 21 * 28) - (중성 인덱스 * 28))*/
        if (character == 32) {
            return ' ';
        } else {
            return firstSounds[(character - 0xAC00) / (21 * 28)];
        }
    }
}
