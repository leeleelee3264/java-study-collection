package me.leelee3264.springbootgettingstarted.byfunc.Hateoas;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-23
 * description
 */
@RestController
public class HateoasAndCorsController {

    // 너무 귀찮아서 hateoas랑 cors랑 같이 실습했다.
//    @CrossOrigin(
//            // 내 리소스를 가져갈 수 있는 애들을 써줌
//            // 이렇게 메소드 하나하나에 만들기 힘들면 아예 webconfig 하나 만들어서 거기다 때려 넣어도 되는 것 같음
//            origins = "http://localhost:18080"
//    )
    @GetMapping("/hey")
    public HttpEntity<Greeting> getGreeting() {

        Greeting g = new Greeting("hello, ", "seungmin" );

        // hateoas info
        g.add(linkTo(methodOn(HateoasAndCorsController.class).getGreeting()).withSelfRel());
//        지금 여기에 있는 controller link 말고 다른 애들 링크는 어떻게 주는거지 혼란스럽
//        g.add(linkTo(methodOn(HateoasController.class).getAnother()).withSelfRel());

        return new ResponseEntity<>(g, HttpStatus.OK);
    }


    @GetMapping("/hey/another")
    public String getAnother() {
        return "another hey";
    }
}
