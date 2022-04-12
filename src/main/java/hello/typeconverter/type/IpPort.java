package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// "127.0.0.1:8080" 문자 -> IpPort 객체 변환
// IpPort 객체 -> "127.0.0.1:8080" 문자 변환
@Getter
@EqualsAndHashCode // 모든 필드를 사용해서 equals(), hashcode() 를 생성
public class IpPort {

    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
