package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {

    @Test
    void conversionService() {

        /**
         * 컨버터 등록
         */
        DefaultConversionService conversionService = new DefaultConversionService();

        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        /**
         * 컨버터 사용
         */
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        // 문자 10 -> integer 로 반환

        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        // 숫자 10 -> String 로 반환

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        // 문자 -> IpPort 객체로 변환

        String ipPortToString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortToString).isEqualTo("127.0.0.1:8080");
        // IpPort 객체 -> 문자로 변환

    }
}
