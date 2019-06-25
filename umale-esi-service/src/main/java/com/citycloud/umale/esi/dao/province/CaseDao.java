package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.Case;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseDao {

    int insertSelective(@Param("pojo") Case pojo);
    int insertList(@Param("pojos") List<Case> pojo);
}
