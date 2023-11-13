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
            Department department1 = new Department("기계공학과", "01", "mecheng", (byte) 1, "https://mecheng.inhatc.ac.kr/sites/mecheng/atchmnfl_mngr/imageSlide/43/temp_1633402901508101.jpg", "기계공학과에서는 4차 산업혁명 시대를 이끌어 나갈 기계기술인 양성을 위해 기초부터 응용기술에 이르는 현장감 있는 강의와 실습을 진행한다. 본과에서는 이론과 실습교육을 바탕으로 각종 기계의 작동원리, 기계부품의 설계, 제작기술 및 기계장비의 운전과 정비를 교육하고, 빠르게 디지털화되는 기계장비를 다룰 수 있도록 디지털전기ㆍ전자관련 융복합 교육을 실시한다.");
            Department department2 = new Department("기계설계공학과", "02", "md", (byte) 1, "https://md.inhatc.ac.kr/sites/md/atchmnfl_mngr/imageSlide/46/temp_1630207045794100.jpg", "기계설계공학과는 융합기술 기반의 제품설계, 제어, 생산 분야 이론 및 실습 교육을 통해 실제 산업현장에서 설계 및 생산 효율을 향상 시킬 수 있는 전문 기술인 양성을 목표로 하고 있다. 또한 폭 넓은 응용능력 향상을 위하여 공학설계, 생산가공, 계측제어, 응용설계 등 다양한 전공영역의 연계를 바탕으로 한 IT 기반의 기계설계 분야 이론과 실무 교육의 실시로 취업 영역을 확대해 나가고 있다.");
            Department department3 = new Department("메카트로닉스공학과", "03", "mecha", (byte) 1, "https://mecha.inhatc.ac.kr/sites/mecha/atchmnfl_mngr/imageSlide/49/temp_1631145656106100.jpg", "산업 자동화를 위해 메카트로닉스공학과에서는 집중화 된 메카트로닉스 분야의 이론과 실습을 산업체 현장에 맞추어 교육을 실시하며, 생산설비 자동화를 위한 로봇 및 자동화시스템 설비기술, 제어시스템 설계기술, 기계/ 전자가 융합된 기술을 습득한 전문기술인을 양성한다.");
            Department department4 = new Department("조선기계공학과", "04", "sos", (byte) 1, "https://sos.inhatc.ac.kr/sites/sos/atchmnfl_mngr/imageSlide/52/temp_1630208390710100.jpg", "조선기계공학과는 우리나라 국가산업의 근간이 되는 조선산업과 기계산업 분야의 전문기술인 양성을 위한 선박설계, 캐드실습 교육뿐 아니라 최근 신산업으로 부상하고 있는 해양레저분야 전문가 양성을 위하여 요트설계 및 수리정비 등 체계적인 이론 및 실습 교육을 실시하고 있다. 더불어 해군과의 협약에 따라 해군 기술부사관 전공반을 운영하고 있어 졸업 후 직업군인으로써의 길도 열려 있다.");
            Department department5 = new Department("항공기계공학과", "05", "ame", (byte) 1, "https://ame.inhatc.ac.kr/sites/ame/atchmnfl_mngr/imageSlide/55/temp_1633423419225100.jpg", "항공기계공학과는 1976년 국내 최초로 설립되어 국내 항공정비분야를 선도하고 있는 Top Frontier 학과로 항공기술 이론과 실무를 겸비한 전문 항공기술인을 양성하고 있다. 이를 위해 복잡한 항공기 기체 및 엔진부터 항공기 운용에 필수적인 각종 계통은 물론, 최첨단 항공기에서 중요도가 높아지는 항공전자 분야의 정비 능력까지 갖출 수 있도록 다양한 이론과 실무교육 및 운항사의 현장실습을 통한 최고의 All-in-One 교육 커리큘럼을 제공하고 있다.");
            Department department6 = new Department("자동차공학과", "06", "auto", (byte) 1, "https://auto.inhatc.ac.kr/sites/auto/atchmnfl_mngr/imageSlide/58/temp_1633066739624101.jpg", "고도의 첨단화된 자동차산업에 필요한 인재를 육성하고자 이에 적합한 전공이론을 교육하고, 이와 관련된 실험실습을 통하여 자동차 생산, 자동차 부품 시험 및 개발, 자동차 정비 관련 업무등을 수행할 수 있는 이론과 실무를 겸비한 자동차분야 전문기술인을 양성.");
            Department department7 = new Department("전기공학과", "07", "ee", (byte) 1, "https://ee.inhatc.ac.kr/sites/ee/atchmnfl_mngr/imageSlide/61/temp_1630211046802100.jpg", "전기공학과는 전통적인 전기분야, 미래성장산업인 지능형 전력망과 신재생에너지 분야에 필요한 전력, 전기기기, 전기설비, 전기/전자 부품 등에 대한 실무 중심의 이론과 실습교육을 하고 있으며, 다양한 산업체와의 산학협동을 통하여 우수 전문기술인을 양성하고 있다.");
            Department department8 = new Department("전자공학과", "08", "er", (byte) 1, "https://er.inhatc.ac.kr/sites/er/atchmnfl_mngr/imageSlide/141/temp_1630211370846100.jpg", "『가전기기 하드웨어 · 반도체· 로봇 소프트웨어 개발 기술자』라는 인재양성유형 목표달성을 위해, 1) 모듈식 반도체 및 임베디드시스템 교육과 실무 중심인 현장실습을 통한 현장 중심 기술배양능력, 2) 인성교육과 영어능력 향상 프로그램을 통한 국제적인 역량배양능력, 3) SK하이닉스 주문식 교육 트랙을 통한 실무기술능력 배양 등을 배움으로써, 4차산업 혁명 시대에 맞는 기술변화에 능동적이고, 개방적인 교육시스템을 구축하여 첨단 전자산업 분야를 이끌어 갈 전문 공학인 인재를 양성한다.");
            Department department9 = new Department("정보통신공학과", "09", "inc", (byte) 1, "https://inc.inhatc.ac.kr/sites/inc/atchmnfl_mngr/imageSlide/67/temp_1630212842453100.jpg", "정보통신공학과는 4차산업혁명에 대비하여 정보통신기기 하드웨어개발, 임베디드 소프트웨어 엔지니어링 직무분야의 국가직무능력표준(NCS)을 적용하여 현장중심의 정보통신 중급전문가 인재를 양성하는 것이다. 이러한 목표를 달성하기 위해 기초적인 코딩이론부터 IoT실무를 적용할 수 있는 신규 교과과정을 개발하여 S/W 및 H/W 개발 엔지니어 양성 교육을 실시하고 있다.");
            Department department10 = new Department("컴퓨터정보과", "10", "cs", (byte) 1, "https://cs.inhatc.ac.kr/sites/cs/atchmnfl_mngr/imageSlide/70/temp_1631490427003100.jpg", "컴퓨터정보과는 4차 산업혁명시대를 이끄는 소프트웨어 전문인력을 양성하기 위하여 웹(Web) 프로그래머, 앱(App) 개발자, SI/SM 프로그래머, 빅데이터 개발자, IoT 개발자, 클라우드 운영 및 관리자 등의 세부 교육과정을 운영하고 있다. 컴퓨팅적 사고능력 함양을 위한 기본 교육부터 수요형 인재양성을 위해 프로젝트 중심으로 자신만의 소프트웨어를 만들어보며, 문제 해결 능력을 키우는 것에 중점을 둔 교육을 실시하고 있다. 또한 전공심화과정을 개설하여 고도화된 소프트웨어 기술들을 교육하고 있다.");
            Department department11 = new Department("컴퓨터시스템과", "11", "cse", (byte) 1, "https://cse.inhatc.ac.kr/sites/cse/atchmnfl_mngr/imageSlide/73/temp_1632729916069100.jpg", "컴퓨터시스템과는 4차 산업혁명시대에 대비한 HW와 SW 산업의 신기술과 고도화 기술을 학습할 수 있는 실무 지향 중심의 교육과정을 통해 산업 현장에 빠르게 적응할 수 있도록 하며, 창의적인 문제 해결 능력을 갖춰 경쟁력 있는 정보기술 능력을 보유한 인재를 양성한다.");
            Department department12 = new Department("건설환경공학과", "12", "civil", (byte) 1, "https://civil.inhatc.ac.kr/sites/civil/atchmnfl_mngr/imageSlide/76/temp_1630213812611100.jpg", "건설환경 전 분야에 걸쳐 필요한 구조, 토질, 수리, 건설재료, 측량, 환경 분야에 대한 이론 및 실습 교육을 통해 건설환경 분야의 특성을 이해하고, 토목구조물을 설계 하여 국내외의 건설 산업에서 설계, 시공, 관리, 운영, 환경 등 전 분야에 걸쳐 활동할 수 있는 전문 인력을 양성한다.");
            Department department13 = new Department("공간정보빅데이터과", "13", "qisup", (byte) 1, "https://gisup.inhatc.ac.kr/sites/gisup/atchmnfl_mngr/imageSlide/79/temp_1630214103728100.jpg", "국내 최초로 GIS 전문인력 양성을 위해 설립된 특성화 학과로서 4차산업 혁명시대에 핵심적인 분야로 떠오르고 있는 공간빅데이터 전문가 양성을 교육목표로 하고 있다. 공간빅데이터 기반 ICT 융합을 통해 IoT, 디지털가상공간, 자동차 자율주행용 3차원 Map 제작과 관련한 교육을 시행하고 있다. 2017년 국토교통부 공간정보 인재양성 사업인 공간정보 특성화 전문대학에 선정되어 최고의 공간정보산업 교육체계 기반의 현장중심 실무교육을 실시해 오고 있다. 2022학년부터는 3년제 학과로서 새롭게 빅데이터 분석 및 GIS시스템 개발자 교육을 강화할 예정이다. 이 외에도 3D모델링 전문가, 드론공간정보처리 등과 관련된 직무 교육에 역점을 둠으로써 우리나라 최고의 공간정보 빅데이터 전문가를 양성해 나갈 것이다.");
            Department department14 = new Department("건축학과", "14", "archi", (byte) 1, "https://archi.inhatc.ac.kr/sites/archi/atchmnfl_mngr/imageSlide/82/temp_1631149236819100.jpg", "창의성을 기반으로 하는 설계 교육 및 BIM 교육, 현장 에서 필요로 하는 관련 법규와 계획, 구조, 설비, 시공 등 다양한 디지털 매체를 활용한 입체적이고 최신의 공법과 실무 교육을 통해 산업 현장에서 필요로 하는 능력을 갖춘 전문 건축 전문기술인을 양성한다.");
            Department department15 = new Department("실내건축과", "15", "interior", (byte) 1, "https://interior.inhatc.ac.kr/sites/interior/atchmnfl_mngr/imageSlide/85/temp_1630214790569100.jpg", "실내건축학과는 종합적이고 균형 잡힌 실내건축인 양성 을 목표로 설계와 시공에 중점을 둔 교육을 실시하며 창 의적인 공간 설계와 완벽한 시공 실무의 적용에 중점을 두고 있다. 또한 이를 가능케 하기 위한 다양한 컴퓨터 프 로그램의 활용 교육, 일대일 스튜디오 방식의 디자인 교 육, 현장감 있는 시공 실습 교육을 통해 21세기를 선도할 수 있는 실내건축인을 양성하고 있다.");
            Department department16 = new Department("화학생명공학과", "16", "ch", (byte) 1, "https://chem.inhatc.ac.kr/sites/chem/atchmnfl_mngr/imageSlide/88/temp_1633065553428100.jpg", "화학생명공학과는 화학과 생명/바이오 산업에 관련된 기초화학, 화학공학, 공업화학, 생명공학 및 환경 분야의 이론교육과 첨단 실험설비를 활용한 다양한 실험 실습을 통하여 화학물질분석, 화학공정 관리, 화학제품 생산, 바이오화학제품 제조, 생명 및 바이오공정 관리, 환경분석 등의 기술을 습득하여 산업 현장에서 요구하는 직무에 곧바로 적응할 수 있는 전문기술인을 양성한다.");
            Department department17 = new Department("재료공학과", "17", "mse", (byte) 1, "https://mse.inhatc.ac.kr/sites/mse/atchmnfl_mngr/imageSlide/91/temp_1632793933473100.jpg", "각종 신소재 개발과 재료 응용 분야의 확대에 따라 전문 지식과 기술을 갖춘 인력 요구에 맞춰 전공 기초 능력함양을 기본으로, 금속을 비롯한 다양한 재료의 기초 이론과 체계적인 실무중심의 실습과 현장 실무형 교육 체계를 바탕으로 산업체에서 요구하는 유능한 전문기술인을 양성한다.");
            Department department18 = new Department("항공운항과", "18", "cbncrew", (byte) 1, "https://cbncrew.inhatc.ac.kr/sites/cbncrew/atchmnfl_mngr/imageSlide/94/temp_1636610659146100.jpg", "인하공업전문대학 항공운항과는 1977년 국내 최초 항공객실승무원 전문인 양성 목적으로 설립되어 고객과 산업체 니즈에 맞는 인재를 지속적으로 육성하고 있습니다.");
            Department department19 = new Department("항공경영학과", "19", "asm", (byte) 1, "https://asm.inhatc.ac.kr/sites/asm/atchmnfl_mngr/imageSlide/97/temp_1634607707499100.jpg", "항공경영학과는 항공운송 및 유관산업에서 필요로 하는 전문인 양성을 목표로 한다. 대한항공과 연결된 컴퓨터 예약시스템과 항공화물시스템을 활용하여 예약, 발권, 운송, 화물업무를 현장감 있게 교육하고, 영어, 일어, 중국어 등의 외국어 교육은 물론 서비스 마인드와 사무 자동화 등의 다양한 실습을 통해 지식과 능력을 겸비한 전문 인력을 양성한다.");
            Department department20 = new Department("관광경영학과", "20", "tour", (byte) 1, "https://tour.inhatc.ac.kr/sites/tour/atchmnfl_mngr/imageSlide/100/temp_1630217218814100.jpg", "관광경영학과는 1983년도 개설되어 관광 및 여행관련 산업분야에서 중추적 역할을 담당하고 있으며, 국제적 수준의 관광서비스 전문인력을 양성하는 것을 목표로 한다 이를 위해, 관광기업에서 요구하는 다양한 전공 교과목을 비롯하여 서비스 마인드 실무, 외국어 교육 등 현장실무 중심의 교육을 실시하고 있다. 현재 수 많은 졸업생들이 최고의 관광기업에서 역량을 발휘하고 있다.");
            Department department21 = new Department("비서학과", "21", "secretary", (byte) 1, "https://secretary.inhatc.ac.kr/sites/secretary/atchmnfl_mngr/imageSlide/103/temp_1630217604575100.jpg", "비서학과는 4차 산업혁명 시대에 맞추어 현대 지식사회에서 요구하는 정보화 능력, 사무기술 능력, 외국어 능력을 종합적으로 갖춘 전문 비서인력을 육성하고 있다. 또한 인성교육을 통해 기업조직에서의 화합과 조화로운 인간관계 능력을 발휘하고 기업의 최고 경영진을 지혜롭게 보좌할 수 있는 기술과 인품을 겸비한 전문인력을 양성해오고 있다.");
            Department department22 = new Department("호텔경영학관", "22", "hotel", (byte) 1, "https://hotel.inhatc.ac.kr/sites/hotel/atchmnfl_mngr/imageSlide/106/temp_1630217878710100.jpg", "호텔경영학과는 호텔산업에 필요한 전문인력양성을 위해 국제적인 감각과 투철한 서비스 마인드를 갖춘 호텔리어(Hotelier) 양성을 목표로 한다. 이를 위해 국제화되고 차별화된 교육프로그램을 통해 호텔 객실 및 식음료 실무를 포함하는 호텔경영 전반에 대한 교육과 카지노 및 외식산업에서 운영 및 대고객 서비스를 담당할 전문서비스인 양성을 위해 실무중심의 교육을 수행한다");
            Department department23 = new Department("산업디자인학과", "23", "industrydesign", (byte) 1, "https://industrydesign.inhatc.ac.kr/sites/industrydesign/atchmnfl_mngr/imageSlide/109/temp_1630218179093100.jpg", "산업디자인 분야의 다양한 교육과정과 실무 프로그램을 통하여 산업현장에서 요구하는 창의적인 사고력과 디자인 기술 및 마케팅 능력을 향상시켜 제품·세라믹디자인, 시각디자인, 웹디자인 등의 분야에서 디자인의 산업적 가치를 충족시킬 수 있는 유능한 중견 디자이너를 양성한다.");
            Department department24 = new Department("패션디자인학과", "24", "fashion", (byte) 1, "https://fashion.inhatc.ac.kr/sites/fashion/atchmnfl_mngr/imageSlide/112/temp_1630218416058100.jpg", "패션디자인학과는 실무지향, 패션지향, 패션전문 교육과정을 바탕으로 2004년 3월에 신설되어 패션디자이너 및 패션머천다이저 등 패션 산업 각 분야에 전문 인력을 배출하고 있다. 또한 실제적 산학연계 마스터플랜을 토대로 40여개의 패션산업체와의 산학협력 결연을 맺어 산업체 맞춤형 교육과정을 통한 우수인력 배출은 물론 산업체에 필요한 다양한 패션자원으로서의 면모를 갖추고 21세기 전문교육기관으로서의 역할을 다하기 위해 노력하고 있다.");
            Department department25 = new Department("교무팀", "25", "affairs", (byte) 1, "https://localhost:8080", "교무팀");
            Department department26 = new Department("학생지원팀", "26", "sst", (byte) 1, "https://localhost:8080", "학생지원팀");
            Department department27 = new Department("전산지원팀", "27", "cst", (byte) 1, "https://localhost:8080", "전산지원팀");

            save(department1, department2, department3, department4, department5, department6, department7, department8, department9, department10, department11, department12, department13, department14, department15, department16, department17, department18, department19, department20, department21, department22, department23, department24,
                    department25, department26, department27);

            dbInit2(department1, department2, department25, department26, department27, department10);
        }

        public void dbInit2(Department department1, Department department2, Department department25, Department department26, Department department27, Department department10) {
            /**
             * memberStatus :
             * 1. 관리자
             * 2. 학생
             * 3. 교수
             * 4. 직원
             */

            Member member1 = new Member(202347023L, 991121L, 12345678L, "서찬원", "scw31421@#", (byte) 1, department27);
            Member member2 = new Member(202347024L, 991121L, 12345678L, "서찬투", "scw314210@#", (byte) 2, department25);
            Member member3 = new Member(2023101111L, 991121L, 12345678L, "컴정조교", "scw31421@#", (byte) 2, department10);
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

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
