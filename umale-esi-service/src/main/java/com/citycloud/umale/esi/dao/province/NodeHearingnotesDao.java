package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.NodeHearingnotes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NodeHearingnotesDao {


    int insertSelective(@Param("pojo") NodeHearingnotes pojo);

    int insertList(@Param("pojos") List<NodeHearingnotes> pojo);

}
