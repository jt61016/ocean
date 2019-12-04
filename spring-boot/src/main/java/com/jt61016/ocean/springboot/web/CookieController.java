package com.jt61016.ocean.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author jiangtao
 * @date 2019-12-03 15:47.
 */
@RestController
@RequestMapping("/cookies/")
public class CookieController {

    @GetMapping("addCookie")
    public String addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        // 可以指定path
        //cookie.setPath("/springboot");
        response.addCookie(cookie);
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>add cookie</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>add cookie ok</h1>\n" +
                "\t<td><a href=\"/springboot/cookies/showCookies\">返回列表</a></td>\n" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping("showCookies")
    public String showCookies(HttpServletRequest request) {
        if (Objects.isNull(request.getCookies())) {
            return "no cookies";
        }
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>show cookies</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>cookies info:</h1>\n" +
                "\t<table border=\"1\">\n" +
                "\t<tr>\n" +
                "\t\t<th>name</th>\n" +
                "\t\t<th>value</th>\n" +
                // 因为Cookie是保存在浏览器端，浏览器请求的时候不会带入这些值
                /*"\t\t<th>version</th>\n" +
                "\t\t<th>comment</th>\n" +
                "\t\t<th>domain</th>\n" +
                "\t\t<th>maxAge</th>\n" +
                "\t\t<th>path</th>\n" +
                "\t\t<th>secure</th>\n" +
                "\t\t<th>httpOnly</th>\n" +*/
                "\t\t<th>operate</th>\n" +
                "\t</tr>");
        for (Cookie cookie : request.getCookies()) {
            sb.append("<tr>")
                    .append("<td>" + cookie.getName() + "</td>")
                    .append("<td>" + cookie.getValue() + "</td>")
                    /*.append("<td>" + cookie.getVersion() + "</td>")
                    .append("<td>" + cookie.getComment() + "</td>")
                    .append("<td>" + cookie.getDomain() + "</td>")
                    .append("<td>" + cookie.getMaxAge() + "</td>")
                    .append("<td>" + cookie.getPath() + "</td>")
                    .append("<td>" + cookie.getSecure() + "</td>")
                    .append("<td>" + cookie.isHttpOnly() + "</td>")*/
                    .append("<td><a href=\"/springboot/cookies/deleteCookie?cookieName=" + cookie.getName() + "&cookieValue=" + cookie.getValue() + "\">删除</a></td>")
                    .append("<tr/>");
        }
        sb.append("</table>\n" +
                "</body>\n" +
                "</html>");
        return sb.toString();
    }

    @GetMapping("deleteCookie")
    public String deleteCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        // 必须和添加的cookie.path值保持一致，否则无法删除
        //cookie.setPath("/springboot");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>delete cookie</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>delete cookie ok</h1>\n" +
                "\t<td><a href=\"/springboot/cookies/showCookies\">返回列表</a></td>\n" +
                "</body>\n" +
                "</html>";
    }
}
