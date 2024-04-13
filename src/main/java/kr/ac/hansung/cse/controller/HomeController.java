package kr.ac.hansung.cse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    //private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final Logger logger = LoggerFactory.getLogger("kr.ac.hansung.cse.controller.HomeController");


    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/") // 윗줄하고 똑같음
    public String home(HttpServletRequest request) {

//        String url = request.getRequestURL().toString();
//        String clientIPaddr = request.getRemoteAddr();
//
//        logger.info("Request URL: {}, Client IP: {}", url, clientIPaddr);

        return "home";
    }
}

