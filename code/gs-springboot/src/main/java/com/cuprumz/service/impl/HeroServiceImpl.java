package com.cuprumz.service.impl;

import com.cuprumz.dao.HeroMapper;
import com.cuprumz.pojo.Hero;
import com.cuprumz.service.HeroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Resource
    private HeroMapper heroMapper;
    
    @Override
    public List<Hero> findAll() {
        return heroMapper.findAll();
    }
}
