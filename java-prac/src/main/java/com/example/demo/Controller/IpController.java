package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SeungminLee
 * project demo
 * date 2021-02-17
 * description
 */
@Slf4j
@Controller
@RequestMapping("/ip")
public class IpController {

    @PostMapping("/network")
    @ResponseBody
    public Map<String, String> getIp(
            HttpServletRequest request
    ) {
        String loginIp = request.getHeader("X-Real-IP");
        String remoteAddr = request.getRemoteAddr();

        log.info("real-ip :{} , remote-addr: {}", loginIp, remoteAddr);
        return new HashMap<String, String>() {{
            put("real-ip", loginIp);
            put("address-ip", remoteAddr);
        }};
    }
}
