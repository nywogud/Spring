package HelloSpring;

import com.example.helloSpring.repository.MemberRepository;
import com.example.helloSpring.repository.MemoryMemberRepository;
import com.example.helloSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());}

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
