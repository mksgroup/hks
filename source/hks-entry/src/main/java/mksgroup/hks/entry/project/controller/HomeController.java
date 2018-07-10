/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.hks.entry.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This controller processes request /
 * @author ThachLN
 */
@Controller
public class HomeController {

    /**
     * Goto the index page.
     * @return
     */
    @RequestMapping({"/", "/index"})
    public String login() {
        return "login";
    }
    
    @RequestMapping("/findJob")
    public String findJob() {
        return "items/findJob";
    }
    @RequestMapping("/seeking")
    public String seeking() {
        return "items/seeking";
    }
    @RequestMapping("/detailFile")
    public String detail() {
        return "items/detail_file";
    }
    @RequestMapping("recruit")
    public String recruit() {
        return "items/recruit";
    }
}
