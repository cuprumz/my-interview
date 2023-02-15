package com.cuprumz.dao;

import com.cuprumz.pojo.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HeroMapper {
    
    List<Hero> findAll();

    Hero selectHero(int number);
}
