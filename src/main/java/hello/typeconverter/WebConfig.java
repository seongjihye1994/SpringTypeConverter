package hello.typeconverter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * WebMvcConfigurer 가 제공하는
     * addFormatters() 를 사용해서
     * 추가하고 싶은 컨버터를 등록
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {

        // 우선순위 주석처리
        // registry.addConverter(new StringToIntegerConverter());
        // registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        // 포메터 추가
        registry.addFormatter(new MyNumberFormatter());

    }
}
