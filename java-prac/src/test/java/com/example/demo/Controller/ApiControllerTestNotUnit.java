package com.example.demo.Controller;

import com.example.demo.DB.DAO.UsersVO;
import com.example.demo.tempInf.BeanValid.MessageDTO;
import org.graalvm.compiler.lir.LIRInstruction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
public class ApiControllerTestNotUnit extends ControllerTestFrame {

    @Autowired
    private ApiController apiController;

    @Override
    protected Object controller() {
        return apiController;
    }

    /**
     *  mvc test with post param POJO
     * @throws Exception
     */
    @Test
    public void beanValid() throws Exception {

        MessageDTO user = new MessageDTO(1, "", "434", "r3r3r");

        jsonMock.perform(post("/api/bean/valid")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(user)));
    }

    /**
     * test get page with param
     * 이 형태는 아무래도 실제로 spring application 을 띄운게 아니라서 modelandview 정보만 찍어주고 실제는 파악이 힘든 듯
     */
    @Test
    public void getByJpa() throws Exception {

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("name", "Sam");

        jsonMock.perform(get("/api/jpa/get").params(param))
                .andExpect(view().name("mockTest"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    /**
     * 이래 놓으면 실제로 db에 저장이 되어버린다. 망함.. 방법은 db 분리하기다. 선택에 따라서 test 환경에서는 h2 같은 db를 쓸 수 잆다고 함
     * @throws Exception
     */
    @Test
    public void saveByJpa() throws Exception {

        UsersVO jpaEntity = UsersVO.builder()
                .name("noinDB")
                .salary(2000)
                .build();

        jsonMock.perform(post("/api/jpa/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(jpaEntity)));
    }

}
