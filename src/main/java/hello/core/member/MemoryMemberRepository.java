package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository  implements MemberRepository {

    /** 여러군데에서 접근하면 동시성 이슈가 발생할 수 있기 때문에 ConcurrentHashMap을 써주는게 맞다.
     * static으로 선언한 이유
     *  : MemoryServiceImpl과 OrderServiceImpl 에서 생성하는 MemoryMemberRepository가 singleton이 아니기 때문에 datasource를 static 메모리에 올려 같이 사용하도록 한 것
     *  : Spring을 사용하는 경우, Bean 주입은 싱글톤이기 때문에 Static 없어도 가능함.
     *  : 하지만 MemberServiceImpl, OrderServiceImpl 에서 각각 new로 생성했기 때문에 메모리에는 MemoryMemberRepository가 두 개 올라옴. 대신 static이라 store는 같은 걸 사용.
     **/
    private static final Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
