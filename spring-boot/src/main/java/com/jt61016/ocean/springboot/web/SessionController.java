package com.jt61016.ocean.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author jiangtao
 * @date 2019-12-03 17:13.
 */
@RestController
@RequestMapping("/session/")
public class SessionController {

    @GetMapping("addSession")
    public String addSession(HttpSession session, String sessionName, String sessionValue) {
        session.setAttribute(sessionName, sessionValue);
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>add session</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>add session ok</h1>\n" +
                "\t<td><a href=\"/springboot/session/showSession\">返回列表</a></td>\n" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping("showSession")
    public String showSession(HttpSession session) {
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>show session</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>session info:</h1>\n" +
                "\t<tr>sessionId:</tr>\n" +
                "\t<tr>" + session.getId() + "</tr>\n" +
                "\t<br/>\n" +
                "\t<span>attributes:</span>\n" +
                "\t<table border=\"1\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>key</th>\n" +
                "\t\t\t<th>value</th>\n" +
                "\t\t\t<th>operate</th>\n" +
                "\t\t</tr>");
        // Attention : session.getAttributeNames() 每次都是返回一个新的Enumeration对象
        Enumeration<String> attributeNameEnumeration = session.getAttributeNames();
        while (attributeNameEnumeration.hasMoreElements()) {
            String key = attributeNameEnumeration.nextElement();
            Object value = session.getAttribute(key);
            sb.append("<tr>")
                    .append("<td>" + key + "</td>")
                    .append("<td>" + value + "</td>")
                    .append("<td><a href=\"/springboot/session/deleteSession?sessionName=" + key + "\">删除</a></td>")
                    .append("<tr/>");
        }
        sb.append("</table>\n" +
                "</body>\n" +
                "</html>");
        return sb.toString();
    }

    @GetMapping("deleteSession")
    public String deleteSession(HttpSession session, String sessionName) {
        session.removeAttribute(sessionName);
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>delete session</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>delete session ok</h1>\n" +
                "\t<td><a href=\"/springboot/session/showSession\">返回列表</a></td>\n" +
                "</body>\n" +
                "</html>";
    }
}
