package me.leelee3264.springbootgettingstarted;

import me.leelee3264.springbootgettingstarted.component.MyProperties;
import me.leelee3264.springbootgettingstarted.listener.BeforeListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// 루트에 안 두고 사용할 패키지의 최상단 (디폴트)에 어노테이션을 썼다
// 왜냐하면 componentScan 때문이다.
// 이 패키지 밑에서부터 스캔을 한다. 루트였으면 루트부터 스캔을 하지
// 그래서 프로젝트 여러개 만들면 그 안 최상단쪽에 이 어노가 있구나.
@SpringBootApplication
public class SpringBootGettingStartedApplication {

    public static void main(String[] args) {

//        이렇게 그냥 런을 갈겨버리면 스프링어플리케이션을 마음대로 커스텀을 못한다. 그냥 있는 그대로를 쓰는 것
//        SpringApplication.run(SpringBootGettingStartedApplication.class, args);

//
//        editconfiguration (내가 맨날 조정하는 실행옵션 그거) vm 옵션에서 -Ddebug 써주면 디버그모드가 되는데
//                스프링자체의 디버그모드인지 내가 원래 디버그버튼 눌러서 디버깅을 할 때보다 더 상세한 정보들이 올라온다.
//                스프링 자체에 대한 디버깅 인포가 올라오는 것 같다. 뭐가 매핑이 되고 뭔 라이브러리 불러오고 등등 (원래는 기본 로깅은 인포까지라고 한다)

//        SpringApplication application = new SpringApplication(SpringBootGettingStartedApplication.class);
//        application.run(args);

//        이렇게 빌더 패턴으로도 만들 수 있다.
        new SpringApplicationBuilder()
                .sources(SpringBootGettingStartedApplication.class)
                .listeners(new BeforeListener())
                .run(args);
    }

//    @Bean
//    public Food yourFood() {
//        Food food = new Food();
//        food.setName("candy");
//        food.setPrice(10);
//
//        return food;
//    }
//

    // mutiple connector 만들기 --> 진짜 커넥터 하나 더 만들어서 넘겨준다
//    @Bean
//    public ServletWebServerFactory sCtr() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//        return tomcat;
//    }
//
//    private Connector createStandardConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(8080);
//        return connector;
//    }

}

//@SpringBootApplication 은 아래의 세가지를 합친것과 마찬가지다
//@SpringBootConfiguration (얘는 그냥 @Configuration 과 말만 다른 수준)
//@ComponentScan
//@EnableAutoConfiguration
//스프링은 서버를 띄울때 두 번 빈을 읽어들이는데 한 번은 컴포넌트 스캔으로 읽어오고
//그 다음에 오토 컨피그에서 읽어온다. 그래서 오토 컨피그를 안 써도 컴포넌트 스캔으로 띄울 수 있다.
//근데 웹서버로 띄우는 컨피그는 다 오토 컨피그에 있어서 그냥 컴스캔이면 웹서버로 안 뜸.
//그래서 만약에 오토 컨피그 에서 빈을 하나 만들고 내 프로젝트에서도 그냥 오토와이어드가 아니라 오토 컨피그 안에 있는
//객체로 빈을 만들었다 하면 내가 만든건 무시되고 오토 컨피그로 설정된게 나옴
//---> 왜냐하면 내가 만든 건 컴포넌트 스캔으로 먼저 만들어지고, 나중에 오토 컨피그 속 빈을 만드니까 뒤집어 써짐
//해결방법: 오토컨피그해온 패키지 속 빈에 @ConditionalOnMissingBean 을 써준다. 이러면 나중에 오토컨피그 올라올때
//선행된 컴포넌트 스캔에서 그 빈이 없을때만 오토컨피그에서 올라옴. 이런 방식으로 Conditional 들어간 어노들을 써주며 커스텀 하면 된다.



//@ComponentScan
//@Configuration @Repository @Service @Controller @RestController @Component
//이 어노테이션 달고 있는 애들을 다 스캔해서 빈으로 주입을 한다.
//조건은 이 클래스(스프링부트 어플리케이션 어노가 있는 클래스)가 들어있는 패키지부터 하위를 훑어와서
//이 패키지보다 상위에 있는 애들은 읽어올 수 없다.

//@EnableAutoConfiguration
//그럼 얘는 뭘 읽어오나? enableautoconfiguration lib를 까보면 meta-inf 밑에 spring.factories가 있다.
//여기에는 해당 lib가 jar로 가지고 있는 스프링을 띄우기위한 무수한 자동 설정들 (웹서버로 띄우기 등등) 이 들어가 있다.
//@Configuration 붙어있는 자바 클래스들이 드글드글하게 들어있다는 얘기.
//인에이블오토는 이 빈들을 다 읽어오는데 그냥 읽는 건 아니고 클래스들 안에 Condition 어쩌고 하는 어노들이 되게 많아서
//내가 준 설정이나 상태에 따라서 빈을 읽어오고 안 읽어오고를 정한다.
//한가지 얘로는 WebMvcAutoConfiguration class 가 있다.


//모듈 네임 컨밴션
//기술-spring-boot-autoconfigure : 자동으로 정의가 되는 모듈들
//기술-spring-boot-starter : 필요할 때 따로 정의를 해야 하는 모듈듈

//이제 autoconfiguration 파일을 만들어 볼 것인데 (1)클래스와 (2)그 클래스를 빈으로 등록해서 가져오는 configuration은
//보통 서로 다른 프로젝트들에 있는 경우가 많다. (예를 들어 인크립트어쩌구 가져올떄도 그 인크립트 클래스 자체는 다른 외부 라이브러리에 들어있었는데
//        내가 가져다 쓰려고 내 프로젝트에 configuration 파일을 만들었으니까)


//그동안 나도 모르게 오토컨피그를 써왔지만 사실 스프링에서 처음부터 주는 오토컨피그도, 내가 필요해서 디펜던시 추가한
//라이브러리도 그냥 재정의해서 쓸때도 있지만 재정의 까지는 안 하고 변수를 넣어서 고쳐서 쓸 때 가 있다. 대표적인 예가 JBDC에서 연결할때 그냥 연결 안 하고
//application.properties에서 내 DB 정보값 넘겨서 연결하는 것처럼 이렇게 살짝씩 바꿔서 쓰고 있었음. 이걸 하려면 오토컨피그 될
//빈 만들때 뭘 해야 하나
//1. 빈클래스에 대한 프로퍼티스 클래스 만들기 ex) Holoman -> HolomanProperties
//2. 프로퍼티스 클래스에 @ConfigurationProperties("holoman") 어노 추가. 인자는 프로퍼티즈 프리픽스임
//3. 빈클래스에 @EnableConfigurationProperties(HolomanProperties.class) 추가 하고 빈 만들때 해당 프로퍼티즈 클래스 인자로 주기
//4. howLong 처럼 분절이 있는 필드는 프로퍼티즈에서 holoman.how-long 이런 식으로 들어간다.
//Conditional 어노테이션이 끝도 없이 많다. 이제 정의해 온 디펜던시 까보고 어떤 conditional 썼는지도 보고 프로퍼티즈 클래스 보고
//어떻게 커스터마이징 할 수 있는지 알 수 있다.




// ---------------------------------------------- 내장서버
//스프맅부트 자체는 서버가 아니다. 서버를 띄우는 툴임. 스프링부트에 코딩을 하며 이것저것 설정을 해줘야 서버로 뜨는 것임
//스프링부트 없이 그냥 서버를 만들려면
//1) 톰캣 객체 만들기
//2) 포트 설정해주기
//3) 톰캣에 컨텍스트 추가
//4) 서블릿 만들기
//5) 톰캣에 서블릿 추가 + 컨텍스트에서 서블릿 매핑
//이 과정을 해주는데 우리가 직접 할 일은 한 번 도 없었다. 스프링부트가 알아서 해주기 때문에 -> 이것도 springboot autoconfig에 다 있다.
//
//1. ServeletWebServerFactoryAutoConfiguration (서블릿 웹서버  aka 서블릿 컨테이너 만듬. 톰캣이 될 수 있고 제티도 될 수 있다. )
//2. DispatcherServeletAutoConfig (서블릿을 만들고 등록한다)
//서버와 서블릿을 다른 클래스에서 만드는 이유는 서버는 바뀔 수 있기 때문에 서버에 상관없이 서블릿을 넣어주기 위해서
//스프링부트가 기본적으로 불러오는 서버는 톰캣임. 제티나 언더토 같이 다른 걸 쓰려면 톰캣 의존성을 빼고 원하는 의존성 넣어야 한다



// --------------------------------------------------- https http2
//    왜 nginx에서가 아니라 spring에서 직접 https를 쓸까?? 이건 고민해봐야할듯, 심지어 http2도 엔진엑스에서 가능한데 ㅠ
//내장 톰캣 서버에는 커넥터가 하나다. 그래서 그 하나를 https로 바꿔버리면 http 요청을 할 수 없게 된다. http 벋을 커넥터가 없으니까
//이럴때 multiple tomcat connector 을 써야 하는 것
//진짜로 그냥 간단하게 커넥터를 하나 더 만들어서 넘겨주면 된다. 커넥터로 받는게 두개니까 포트도 두개가 된다. 당연한게 http랑 http2 포트 넘버 자체도 다르니까.
//
//http2
//spring에서 이거 쓰기 참 까다로운듯. 설정은 프로퍼티에 하나만 추가해주면 되는거지만 서버 컨테이너마다 http2 쓸 수 있는 조건들이 조금씩 다르다.
//톰캣은 톰캣 자체랑 자바 버전을 손을 봐야하고 언더토우는 그냥 써도 된다.
//근데 실행해보니까 커넥터 빈으로 등록해서 하나 더 넘겨주는거 (http https) 는 언더토우를 쓸 수 없다.
//당연한게 커넥터 빈이 생성해서 넘겨주는 서버가 톰캣이니까 언더토우 쓸 때 못 쓰지...



// --------------------------------------------------- jar
//java + tar
//jar 하나만 있으면 어플리케이션 실행이 가능하다.
//jar를 만들면 BOOT-INFO에 내가 만든 클래스들이 들어가 있고 내가 쓰는 라이브러리들도 들어가 있다.
//근데 원래 자바는 jar 안에 있는 클래스들을 읽는 공용적인 방법이 없다고 함.
//그래서 옛날에는 그냥 라이브러리들을 한 jar로 묶어서 압축했는데 이럼 내가 무슨 라이브를 썻는지도 모르겠지만 이름이 같은 클래스들을 부를때 문제가 발생함 (어느거 나가요?)
//
//Boot에서는 jar안에 그냥 라이브러리 jar들을 고대로 넣어준다
//jar 해체하면 BOOT-INFO/META-INFO/org 디렉들이 만들어진다
//거기서 org에서 springframework 에서 boot를 까보면 클래스들이 몇개 있다.
//
//부트는 아까 말한것처럼 라이브러리들을 jar로 고대로 남겨놓는데 그럼 읽는 방법도 남겨놨겠지..? -> 바로 org 디렉까서 나오는
//클래스 중에 loder에 해당하는 JarFile 클래스가 라이브 jar 클래스들을 읽어와서 올려준다 (load 해준다)
//그리고 boot는 main 클래스에서 어플리케이션을 실행하는데 ㅓjar 형태일때는 어떻게 main을 찾아서 어플리케이션을 실행하나?
//그것도 loader 와 마찬가지로 부트가 launcher 라고 만들어놨다. 얘가 main 찾아서 실행을 해줌.
//jar로 만들었으면 JarLauncher, war로 만들었으면 WarLuncher 가 실행이 된다.

//    # 여기는 jar 실제로 까서 보기
//원래 자바 스펙(컨벤션)이 jar 실행을 할 때 Manifest 파일을 찾는다.
//거기에 main 클래스가 써있어서 그 main을 실행한다! --> 여기까지는 모든 java 프로그램들이 동일하게 작동해야 함. 규칙이다.
//boot도 거기까지 동일하게 하고 뒤를 추가한 것
//Manifest에서 Main-class를 그냥 main class 안 쓰고 런처를 써놨다. 어차피 런처가 main 찾아올 테니까
//그리고 그 뒤에 start-class라고 내가 만든 main class를 표기해놨음


//------------------------------------------ application event listener
//어플리케이션이 이벤트가 생길때마다 실행해주는 리스너. POJO에서 컴포넌트 어떻게 우회해서 쓸까 고민했을떄 찾아봤던 그 리스너 맞음
//        리스너를 만들고 컴포넌트로 등록을 한다. 한마디로 빈이라는 말이다.
//근데 어플리케이션이 다 뜨고 실행되는 이벤트들은 상관이 없는데 어플리케이션이 뜰때나 그 이전의 이벤트는 어쩜?
//왜냐하면 어플리케이션의 스프링 컨테이너가 빈을 관리하기 때문에 불러오고 그러는 건데 어플리케이션이 들 떠서 빈을 관리도 못하는 그
//시점에 빈으로 등록된 이벤트를 실행하려고 하는거니까...
//이때는 어플리케이션에 직접 addListener써서 리스너 객체를 넘겨줘서 실행시킨다 (어플리케이션이 모르니 아에 새겨버리는 수준...)
//    그래서 어차피 객체를 만들어줘서 넘겼기 때문에 컴포넌트 어노가 크게 의미가 없음 뺴주세요

//WebApplicationType.NONE
//        WebApplicationType.SERVLET
//        WebApplicationType.REACTIVE
//스프링 mvc가 있으면 서블릿 타입으로 돌고 스프링 플럭스가 있으면 리액티브 타입으로 돈다. 둘 다 있으면 서블릿으로 돈다.
//리액티브로 돌리고 싶으면          WebApplicationType.REACTIVE 직접 써줘야 된다

//아규먼트
//vm option에 -D 로 시작해서 넘기면 vm 옵션이고 프로그램 아규먼트 항목에 -- 로 시작해서 넘기면 아규먼트임
//


//----------------------------------properties 우선순위
//        15. 파일에다가 직접 작성한 것 (순위가 많이 낮은 편)
//4. 커맨드 라인에서 직접 넘겨주기
//3. SpringbootTest어노에 properties라고 attr주기
//2. 테스트에서 testpropertySource 어노 사용하기 (properties도 되고 location으로 파일 지정도 됨)
//
//properties에서 ${random.*} 이라고 내장된 랜덤 생성도 사용 가능

//테스트하면서 리소스 쓰는 중 신기한 부분
//보통 테스트를 컴파일 하면 소스를 먼저 빌드하고 테스트 디렉토리에 있는 소스를 빌드를 한다.
//그래서 그냥 단순하게 프로퍼티를 본소스에 하나, 테스트에 하나 만들면 오버라이딩이 안된다. 그냥 본소스에 있는 걸 덮어써버리기 때문에
//만약 본소스에서 본소스 프로퍼티에만 있는 프로를 썼으면 테스트 돌릴때 서버가 안 뜨는 에러가 생긴다. 결국 테스트용 프로퍼티도 본소스에 쓰고있는 인자들을 다 생성해줘야 에러 안 생기고 테스트가 돌아감
//프로퍼티 오버라이딩은 같은 디렉토리 안에 있는 프로퍼티들끼리 가능한 것 같음. 테스트에 application.properties를 만들고 test.properties를 만들면
//test.properties가 application.properties에 있는 설정들을 오버라이딩해서 사용하네. 근데 본소스에 있는 application.properties를 오버라이딩 해오지는 않음
//SpringBootTest에 attr로 properties를 줘도 되고 TestPropertySource를 사용해도 된다. 이걸 어디가 쓸까 싶었는데
//activeprofile 잡고 세부로 값 하나씩 바꿔주고 싶을 떄 쓰겠네
//아 지금 생각해보니까 본소스에 어플리케이션 프로퍼티 만들고 테스트에는 그 이름 말고 다른 이름의 프로퍼티 파일
//만들면 컴파일 할 때 본소스 컴파일하고 테스트 컴파일 할 때 어플리케이션 프로퍼티를 안 덮어쓰니까 본소스에만 있는 프로퍼티있어도 오류가 안 나겠다

//프로퍼티즈를 프로젝트 여러 위치에 만들 수 있는데 만드는 위치에 따라서도 우선순위가 달라진다. 우선순위 높은 애가 낮은 애걸 덮어씀
//1. root/config (file)
//2. root
//3. classpath (내가 맨날 두는 거기)


//properties as bean
//비슷한 성격들의 프로퍼티를 앞에 같은 prefix로 계속 만들어야 한다면(my.name, my.age) 해당 Properties를 빈으로 만들어서 쓰는 방법이 있음
//클래스 하나 만들고 @ConfigurationProperties("my") 이런식으로 써주면 된다. 근데 컴포넌트 어노테이션 써서 빈으로 만들어줘야지 안그럼 스프링에서 못
//찾는다고 하나 하나 써달라고 @EnableConfigurationProperties(MyProperties.class) 이렇게 해달라고함 (auto configure은 이런식으로 되어있었던듯)
//
//이렇게 하면 장점
//1. 문자열로 되어있는 타입세이프 하지 않은 프로퍼티들이 클래스 필드에 맞춰 들어가서 타입 세이프해짐
//2. Value 에노 쓸때도 이름 굉장히 정확히 입력해야 하고 지저분한데 얘는 클래스 하나로 깔끔하게 관리가 된다
//3. 프로퍼티 카멜,스네일, 언더스코어 다 되어서 어떤 형태로든 이름만 제대로 쓰면 맵핑이 된다
//4. validated (hibernated 구현체) 써서 값을 검증을 할 수 있음 (이거 내 controller에서 값검증할때 써도 될듯..)


//#----------------프로파일
//configuration이나 component에 @Profile 어노테이션을 둬서 서버 올릴때 올라올 빈과 올라오지 말아야 할 빈을 관리할 수 있다.

//#------------------로깅
//스프링은 아무튼 SLF4J (심플 로그 파사드 for 자바) 를 쓰고 실제 로그 구현체는 logback을 쓴다고 한다
//원래는 Commons Loggings 이라는 로그 파사드가 있다는데 문제가 많아서 안 쓰는 레거시라고.
//로그 파사드는 한마디로 로그 인터페이스들임. 인터페이스를 쓰는 장점인 구현체를 골라 쓸 수 있는 편리함. 그래서 로그 파사드를 쓰면 로거 구현체를 선택할 수 있는데 어차피 로그백 쓴다고 한다.

//
//로그를 상세하게 커스텀하고 싶으면 logback-spring.xml을 만들어줘야 한다 --> 약간 이렇게 쿼리랑 구분을 하겠네 --> 쉽게 할 것 같음. db 라이브러리에서 나온 애들만 다른 파일에 ㄸ찍어준다고 생각하면 되니까.
// 근데 나는 디비 로그를 콘솔에도 남기고 파일에도 남기고 싶은데 --> 테스트말고 프로드 환경에서는 분리해도 괜찮을듯
//구현체가 logback으로 되어있는데 이게 싫으면 log4j2 로 바꿀 수 있다. 라이브러리 제외하고 log4j 추가만 하면 된다



//#####------------------------- dev tools
//dev-tool를 넣는 순간 스프링에서 사용하고 있던 캐시를 몇개 꺼버린다.--> 바뀐게 바로바로 보여야 하니까 캐쉬 꺼버리는 것
//지금 보니까 코드 바꿨을 때 다시 run을 하는 것보다 build를 하는게 훨씬 빠르게 올라간다.
//뭐 바꾸면 냅다 쉬프트 + f9 갈기지 말고 컨트롤 + f9를 써보자!!



//################## ------------------- springboot webmvc
//생각해보면 참 편하게 웹서버를 띄우고 mvc를 이용하고 있는데 이게 어떻게 가능한걸까?
//저번에 배웠던 auto configure에서 띄우는 팩토리에 webmvc 에 관련된 프리 세팅이 이미 다 되어있다.
//예를 들어 HiddenHttpMethodFilter는 클라이언트가 보내는 post get 메소드등을 받아서 알맞은 컨트롤러에 전달을 해주고
//FormContentFilter는 put/delete/patch를 post에서 그러는 것처럼 파라메터를 뺴올 수 있게 해준다.
//스프링 mvc가 일반 웹 컨벤션에서 확장해서 몇개 부가기능도 들어있음
//mvc 설정을 내가 좀 추가하고 싶다, 수정하고 싶다 하면 configuration을 만들면 됨.(implements WebMvcConfigurer)
//근데 만약 여기서 @Configuration 과 @EnableWebMvc 를 같이 사용하면 이전에 스프링 mvc가 지정한 프리셋이 다 날아가고 정말 하나하나 내가 다 세팅을 해줘야 한다.



//################## ------------------- httpmessagconverters
//메세지 컨버터는 무엇인가? 내가 맨날 @RequestBody @ResponseBody 쓰면서 클라이언트에게서 값을 받아오거나 클라이언트에게 값을
//보내주는데 신기하게도 클래스로 값을 보내고 받아도 스프링이 알아서 변환을 잘 해서 착착 받아온다. --> 여태 아 신기하다 했던게 결국 스프링이 제공해주는 메세지컨버터가 일하고 있었음
//그래서 정확한 정의는 Http 요청 본문을 객체로 변경하거나, 객체를 Http 응답 본문으로 변경할때 사용이다.
//그냥 string이나 int 같은 하나의 값을 보낼때는 그냥 string 컨버터가 쓰인다.
//그리고 값이 여러개인 클래스 같은 애들 경우에는 제일 많이 쓰는 데이터 형태인 제이슨으로 왔다갔다 해서 제이슨 메세지 컨버터가 쓰인다.
//근데 객체들 다 게터세터 있어야 한다. 자바 규약에 따라서 게터세터를 이용해서 바인딩을 해준다 함

//ContentNegotiationgViewResolver
//서버가 클라이언트한테 응답을 내보낼때 내보낼 수 있는 타입들을 다 뒤져서 적당한 형태를 찾아 내보낸다.
//클라이언트가 accept를 명시해뒀으면 그거 보고 찾으면 되니까 쉬운데 항상 그렇게 accept를 써주지는 않음. 아무튼 스프링이 만들어둔 컨텐츠네고티에이팅뷰리졸버가 일을 다 한다.
//그래서 서버 코딩을 할 때 그냥 별다른 작업 없이 클라이언트가 json으로 응답을 원해도, xml로 응답을 원해도 보내줄 수 있다. (요즘은 당연 다 json으로 한다)


//mvc 정적 리소스
//controller로 뷰를 리턴해주는게 아니라 그냥 쌩으로 static 파일 경로 치고 들어와서 찾아가는 그런 케이스를 말하는 것
//기본 리소스 위치는 classpath:/static, classpath:/resources 등등 몇개 있는데 기본이 static 아닐지.. 다른데에다 만들어도 static에서 만든게 리턴이 된다. 기본주소 localhost:8080/hello.html 막 이렇게 했을 떄
//그리고 스프링에서 static 파일이 변경이 없는 경우는 request의 if-modified 항목이랑 response의 last-modificated 로 보고 변
//변경이 있는지 없는지 조절을 한다. 없으면 304 코드 보내고 실제 리소스는 보내지도 않음