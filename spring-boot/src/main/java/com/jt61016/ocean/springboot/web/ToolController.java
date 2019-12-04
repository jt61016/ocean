package com.jt61016.ocean.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangtao
 * @date 2019-12-03 15:42.
 */
@RestController
@RequestMapping("/tools/")
public class ToolController {

    /**
     * ping
     *
     * @return ok
     */
    @GetMapping("ping")
    public String ping() {
        return "ok";
    }
}
