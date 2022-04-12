package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    /**
     * 문자 -> 숫자 변환 테스트
     */
    @Test
    void StringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();

        // 문자를 변환
        Integer result = converter.convert("10");

        // 문자를 변환한 값이 숫자 10과 같은지 비교
        assertThat(result).isEqualTo(10);
    }

    /**
     * 숫자 -> 문자 변환 테스트
     */
    @Test
    void IntegerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();

        // 숫자를 변환
        String result = converter.convert(10);

        // 숫자를 변환한 값이 문자 10과 같은지 비교
        assertThat(result).isEqualTo("10");
    }

    /**
     * 문자 -> IpPort 객체 변환 테스트
     */
    @Test
    void stringToIpPort() {
        StringToIpPortConverter converter = new StringToIpPortConverter();

        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);

        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    /**
     * IpPort 객체 -> 문자 변환 테스트
     */
    @Test
    void ipPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();

        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);

        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}
