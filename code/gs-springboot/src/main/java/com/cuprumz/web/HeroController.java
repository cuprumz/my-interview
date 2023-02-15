package com.cuprumz.web;

import com.cuprumz.pojo.Hero;
import com.cuprumz.service.HeroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {

    @Resource
    private HeroService heroService;
    
    @RequestMapping("/all")
    public List<Hero> findAll() {
        return heroService.findAll();
    }
}
