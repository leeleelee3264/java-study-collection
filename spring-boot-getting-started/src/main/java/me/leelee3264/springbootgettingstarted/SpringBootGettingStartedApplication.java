package me.leelee3264.springbootgettingstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

// 루트에 안 두고 사용할 패키지의 최상단 (디폴트)에 어노테이션을 썼다
// 왜냐하면 componentScan 때문이다.
// 이 패키지 밑에서부터 스캔을 한다. 루트였으면 루트부터 스캔을 하지
// 그래서 프로젝트 여러개 만들면 그 안 최상단쪽에 이 어노가 있구나.
@SpringBootApplication
public class SpringBootGettingStartedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGettingStartedApplication.class, args);
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