package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
/**
 * AutoAppConfigTest 같은 경우, 테스트 케이스에서 실행하기 때문에 둘 다 컴포넌트 스캔의 대상이 된다
 * (src/main/java, src/test/java)
 * 반면, src/main/java에서 실행하면 test는 적용되지 않음.
 * */
public class AutoAppConfig {

/*    @Bean(name = "memoryMemberRepository")
    MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }
*/
}
