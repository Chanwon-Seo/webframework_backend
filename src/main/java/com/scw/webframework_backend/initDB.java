package com.scw.webframework_backend;


import com.scw.webframework_backend.domain.Board;
import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.domain.DepartmentBoard;
import com.scw.webframework_backend.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Month;

@Component
@RequiredArgsConstructor
public class initDB {

    private final InitService initService;


    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Department department1 = new Department("기계공학과", "mecheng", (byte) 1, "https://mecheng.inhatc.ac.kr/sites/mecheng/atchmnfl_mngr/imageSlide/43/tp_1633402919736100.jpg");
            Department department2 = new Department("기계설계공학과", "md", (byte) 1, "https://md.inhatc.ac.kr/sites/md/atchmnfl_mngr/imageSlide/46/tp_1630207231249100.jpg");
            Department department3 = new Department("메카트로닉스공학과", "mecha", (byte) 1, "https://mecha.inhatc.ac.kr/sites/mecha/atchmnfl_mngr/imageSlide/49/tp_1631145656106100.jpg");
            Department department4 = new Department("조선기계공학과", "sos", (byte) 1, "https://sos.inhatc.ac.kr/sites/sos/atchmnfl_mngr/imageSlide/52/tp_1630208390710100.jpg");
            Department department5 = new Department("항공기계공학과", "ame", (byte) 1, "https://ame.inhatc.ac.kr/sites/ame/atchmnfl_mngr/imageSlide/55/tp_1633423704453100.jpg");
            Department department6 = new Department("자동차공학과", "auto", (byte) 1, "https://auto.inhatc.ac.kr/sites/auto/atchmnfl_mngr/imageSlide/58/tp_1631148687994100.jpg");
            Department department7 = new Department("전기공학과", "ee", (byte) 1, "https://ee.inhatc.ac.kr/sites/ee/atchmnfl_mngr/imageSlide/61/tp_1630211046802100.jpg");
            Department department8 = new Department("전자공학과", "er", (byte) 1, "https://er.inhatc.ac.kr/sites/er/atchmnfl_mngr/imageSlide/141/tp_1630211370846100.jpg");
            Department department9 = new Department("정보통신공학과", "inc", (byte) 1, "https://inc.inhatc.ac.kr/sites/inc/atchmnfl_mngr/imageSlide/67/tp_1630212842453100.jpg");
            Department department10 = new Department("컴퓨터정보과", "cs", (byte) 1, "https://cs.inhatc.ac.kr/sites/cs/atchmnfl_mngr/imageSlide/70/tp_1631490445894100.jpg");
            Department department11 = new Department("컴퓨터시스템과", "cse", (byte) 1, "https://cse.inhatc.ac.kr/sites/cse/atchmnfl_mngr/imageSlide/73/tp_1632729936507100.jpg");
            Department department12 = new Department("건설환경공학과", "civil", (byte) 1, "https://civil.inhatc.ac.kr/sites/civil/atchmnfl_mngr/imageSlide/76/tp_1630213812611100.jpg");
            Department department13 = new Department("공간정보빅데이터과", "qisup", (byte) 1, "https://gisup.inhatc.ac.kr/sites/gisup/atchmnfl_mngr/imageSlide/79/tp_1630214122545100.jpg");
            Department department14 = new Department("건축학과", "archi", (byte) 1, "https://archi.inhatc.ac.kr/sites/archi/atchmnfl_mngr/imageSlide/82/tp_1631149236819100.jpg");
            Department department15 = new Department("실내건축과", "interior", (byte) 1, "https://interior.inhatc.ac.kr/sites/interior/atchmnfl_mngr/imageSlide/85/tp_1630214790569100.jpg");
            Department department16 = new Department("화학생명공학과", "ch", (byte) 1, "https://ch.inhatc.ac.kr/sites/ch/atchmnfl_mngr/imageSlide/88/tp_1630215129637100.jpg");
            Department department17 = new Department("재료공학과", "mse", (byte) 1, "https://mse.inhatc.ac.kr/sites/mse/atchmnfl_mngr/imageSlide/91/tp_1633673721676100.jpg");
            Department department18 = new Department("항공운항과", "cbncrew", (byte) 1, "https://cbncrew.inhatc.ac.kr/sites/cbncrew/atchmnfl_mngr/imageSlide/94/tp_1636610886774100.jpg");
            Department department19 = new Department("항공경영학과", "asm", (byte) 1, "https://asm.inhatc.ac.kr/sites/asm/atchmnfl_mngr/imageSlide/97/tp_1631150520404100.jpg");
            Department department20 = new Department("관광경영학과", "tour", (byte) 1, "https://tour.inhatc.ac.kr/sites/tour/atchmnfl_mngr/imageSlide/100/tp_1630217218814100.jpg");
            Department department21 = new Department("비서학과", "secretary", (byte) 1, "https://secretary.inhatc.ac.kr/sites/secretary/atchmnfl_mngr/imageSlide/103/tp_1631144930599100.jpg");
            Department department22 = new Department("호텔경영학관", "hotel", (byte) 1, "https://hotel.inhatc.ac.kr/sites/hotel/atchmnfl_mngr/imageSlide/106/tp_1630217899025100.jpg");
            Department department23 = new Department("산업디자인학과", "industrydesign", (byte) 1, "https://industrydesign.inhatc.ac.kr/sites/industrydesign/atchmnfl_mngr/imageSlide/109/tp_1630218195213100.jpg");
            Department department24 = new Department("패션디자인학과", "fashion", (byte) 1, "https://fashion.inhatc.ac.kr/sites/fashion/atchmnfl_mngr/imageSlide/112/tp_1630218416058100.jpg");
            Department department25 = new Department("교무팀", "affairs", (byte) 1, "https://localhost:8080");
            Department department26 = new Department("학생지원팀", "sst", (byte) 1, "https://localhost:8080");

            save(department1, department2, department3, department4, department5, department6, department7, department8, department9, department10, department11, department12, department13, department14, department15, department16, department17, department18, department19, department20, department21, department22, department23, department24,
                    department25, department26);

            dbInit2(department1, department2, department25, department26);
        }

        public void dbInit2(Department department1, Department department2, Department department25, Department department26) {
            /**
             * memberStatus :
             * 1. 관리자
             * 2. 학생
             * 3. 교수
             * 4. 직원
             */

            Member member1 = new Member(202347023L, "서찬원", "scw31421@#", (byte) 1);
            Member member2 = new Member(202347024L, "서찬투", "scw314210@#", (byte) 2);
            em.persist(member1);
            em.persist(member2);

            LocalDateTime registrationDate = LocalDateTime.of(2023, Month.OCTOBER, 1, 0, 0);
            LocalDateTime modificationDate = LocalDateTime.of(2023, Month.OCTOBER, 1, 0, 0);

            for (int i = 0; i < 100; i++) {
                String boardTitle = "[교무] 제목 " + (i + 1);
                String boardDetail = "상세 내용 " + (i + 1);

                Board board = new Board(boardTitle, member1, department25, boardDetail, registrationDate, modificationDate);

                // 다음 데이터의 등록 및 수정일을 설정
                registrationDate = registrationDate.plusDays(1);
                modificationDate = modificationDate.plusDays(1);
                save(board);
            }
            for (int i = 0; i < 100; i++) {
                String boardTitle = "[장학] 제목 " + (i + 1);
                String boardDetail = "상세 내용 " + (i + 1);

                Board board = new Board(boardTitle, member1, department26, boardDetail, registrationDate, modificationDate);

                // 다음 데이터의 등록 및 수정일을 설정
                registrationDate = registrationDate.plusDays(1);
                modificationDate = modificationDate.plusDays(1);
                save(board);
            }

            for (int i = 0; i < 100; i++) {
                String boardTitle = "[기계공학과] 제목 " + (i + 1);
                String boardDetail = "상세 내용 " + (i + 1);

                DepartmentBoard DepartmentBoard1 = new DepartmentBoard(boardTitle, member1, department1, boardDetail, registrationDate, modificationDate);

                // 다음 데이터의 등록 및 수정일을 설정
                registrationDate = registrationDate.plusDays(1);
                modificationDate = modificationDate.plusDays(1);
                save(DepartmentBoard1);
            }
            for (int i = 101; i < 200; i++) {
                String boardTitle = "[기계설계공학과] 제목 " + (i + 1);
                String boardDetail = "상세 내용 " + (i + 1);

                DepartmentBoard DepartmentBoard2 = new DepartmentBoard(boardTitle, member1, department2, boardDetail, registrationDate, modificationDate);

                // 다음 데이터의 등록 및 수정일을 설정
                registrationDate = registrationDate.plusDays(1);
                modificationDate = modificationDate.plusDays(1);
                save(DepartmentBoard2);
            }
        }

        public void save(Object... objects) {
            for (Object object : objects) {
                em.persist(object);
            }
        }
    }
}
