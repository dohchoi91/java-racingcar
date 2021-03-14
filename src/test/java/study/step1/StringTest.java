package study.step1;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현")
    void splitExactlyContains() {
        String[] result = "1,".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현")
    void substring() {
        String testStr = "(1,2)";
        String result = testStr.substring(1, testStr.length() - 1);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현")
    void charAt() {
        String testStr = "abc";
        assertAll(() -> assertThat(testStr.charAt(0)).isEqualTo('a'),
                  () -> assertThat(testStr.charAt(1)).isEqualTo('b'),
                  () -> assertThat(testStr.charAt(2)).isEqualTo('c'));
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현")
    void charAt_StringIndexOutOfBoundsException() {
        String testStr = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> testStr.charAt(7))
            .withMessageMatching("String index out of range: \\d+");
    }
}