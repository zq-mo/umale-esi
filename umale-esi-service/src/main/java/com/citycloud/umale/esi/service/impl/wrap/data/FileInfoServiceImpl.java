/**
 * Project Name:umale
 * File Name:FileInfoServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/17 18:08
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.service.externalwrit.ExternalWritService;
import com.citycloud.umale.cases.vo.externalwrit.ExternalMaterialVO;
import com.citycloud.umale.cases.vo.externalwrit.ExternalWritVO;
import com.citycloud.umale.commons.util.StringUtils;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.FileInfo;
import com.citycloud.umale.esi.service.impl.commons.ListSplitUtil;
import com.citycloud.umale.esi.service.province.FdsFileInfoV2Service;
import com.citycloud.umale.esi.service.wrap.data.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bridge
 * @className FileInfoServiceImpl
 * @description
 * @date 2019/5/17 18:08
 * @since JDK 1.8
 */
@Service(interfaceClass = FileInfoService.class)
@Slf4j
public class FileInfoServiceImpl implements FileInfoService {

    private final int n = 10;

    @Reference
    private ExternalWritService externalWritService;

    @Autowired
    private FdsFileInfoV2Service fdsFileInfoV2Service;

    @Override
    public int insertList(List<String> caseNumList) {

        int count = 0;
        List<FileInfo> fileInfoList = getFileInfoList(caseNumList);
        int size = fileInfoList.size();
        if (size == 0) {
            return 0;
        }
        if (size > n) {
            List<List<FileInfo>> splitList = ListSplitUtil.averageAssign(fileInfoList, n);
            for (List<FileInfo> item : splitList) {
                int count1 = fdsFileInfoV2Service.insertList(item);
                count = count + count1;
            }
        } else {
            count = fdsFileInfoV2Service.insertList(fileInfoList);
        }
        return count;
    }


    private List<FileInfo> getFileInfoList(List<String> caseNumList) {


        //todo 新增接口
        List<ExternalWritVO> externalWritVOList = externalWritService.listByCaseNos(caseNumList);

        List<FileInfo> fileInfoList = new ArrayList<>();

        for (ExternalWritVO item : externalWritVOList) {
            for (ExternalMaterialVO item1 : item.getMaterials()) {
                FileInfo temp = new FileInfo();
                dataWrap(temp, item1, item.getUserName(), item.getNodeCode());
                fileInfoList.add(temp);
            }
        }
        return fileInfoList;
    }

    private void dataWrap(FileInfo vo, ExternalMaterialVO po, String userName, String nodeCode) {

        if (StringUtils.isEmpty(po.getMaterialNo())) {
            vo.setFileinfoid("undefine");
        }else {
            vo.setFileinfoid(po.getMaterialNo());
        }
        if(StringUtils.isEmpty(po.getCaseNo())){
            vo.setCaseid("undefine");
        }else{
            vo.setCaseid(po.getCaseNo());
        }
        if(StringUtils.isEmpty(po.getMaterialName())){
            vo.setName("undefine");
        }else{
            vo.setName(po.getMaterialName());
        }
        if(StringUtils.isEmpty(po.getMaterialPath())){
            vo.setFilepath("undefine");
        }else{
            vo.setFilepath(po.getMaterialPath());
        }

        vo.setCreatetime(po.getCreateTime());
        if(StringUtils.isEmpty(userName)){
            vo.setOperatorname("undefine");
        }else{

            vo.setOperatorname(userName);
        }
        if(StringUtils.isEmpty(nodeCode)){
            vo.setNodecode("undefine");
        }else{

            vo.setNodecode(nodeCode);
        }
        vo.setFlag(CaseV2.flag);
        vo.setAreacode(CaseV2.areacode);
        vo.setDatavervison(CaseV2.datavervison);
        vo.setBelongtosystem(CaseV2.belongtosystem);
        vo.setSync_status(CaseV2.sync_status);
        vo.setCf_sjly(CaseV2.cf_sjly);
        vo.setCf_sjlydm(CaseV2.cf_sjlydm);

    }
}
