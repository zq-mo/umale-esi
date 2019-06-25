package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileInfoDao {

    int insertSelective(@Param("pojo") FileInfo pojo);

    int insertList(@Param("pojos") List<FileInfo> pojo);
}
