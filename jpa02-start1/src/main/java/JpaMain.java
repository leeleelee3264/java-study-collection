import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-08
 * Description:
 */

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            logic(em);
            tx.commit();
;        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void logic(EntityManager em) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("이승민");
        member.setAge(27);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(30);

        // 조회
        Member findMember = em.find(Member.class, id);
        System.out.println(new StringBuilder().append(member.getId()).append(": ").append(member.getUsername()).append(": ").append(member.getAge()).toString());


        // multi 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("Member size=" + members.size());

        // 삭제
        em.remove(member);

    }
}
