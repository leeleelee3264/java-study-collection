package me.leelee3264.springbootgettingstarted.byfunc.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-22
 * description
 */
@Controller
public class MyExceptionController {

    // 스프링부트의 mvc가 기본적으로 사용하는 error handler는 BasicErrorController 다 여기서 확장을 해 나가는 것임
    @GetMapping("/exception")
    public String exception() {
        throw new MyException();
    }

    // 오 신기하다. 스프링에서 예외처리는 아예 이렇게 어노테이션으로 해서 하네
//    @ExceptionHandler(MyException.class)
//    @ResponseBody
//    public ResponseEntity<AppErrPOJO> myError(MyException e) {
//        AppErrPOJO app = new AppErrPOJO();
//        app.setMessage("error.app.key");
//        app.setReason(e.getMessage());
//
//
//        return ResponseEntity.ok(app);
//    }
}
