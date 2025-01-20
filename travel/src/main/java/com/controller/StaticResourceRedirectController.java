package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StaticResourceRedirectController {

        @RequestMapping(value = "/lvyouwangzhan/**", method = RequestMethod.GET)
    public void redirectToTravel(HttpServletResponse response) throws IOException {
        response.sendRedirect("/travel");  // 重定向到 /travel 路径
    }
}