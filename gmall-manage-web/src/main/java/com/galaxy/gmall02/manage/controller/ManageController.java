package com.galaxy.gmall02.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.galaxy.gmall02.bean.*;
import com.galaxy.gmall02.manage.IManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 裴一飞
 * @date 2020/11/24 - 16:48
 */
@RestController
@CrossOrigin
public class ManageController {
    @Reference
    private IManageService manageService;

    @PostMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getCatalog1s();
    }
    @PostMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return manageService.getCatalog2s(catalog1Id);
    }
    @PostMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getCatalog3s(catalog2Id);
    }
    @GetMapping("attrInfoList")
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return manageService.getAttrInfos(catalog3Id);
    }
    @PostMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId){
        BaseAttrInfo attrInfo = manageService.getAttrInfo(attrId);
        return attrInfo.getAttrValueList();
    }
    @PostMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo attrInfo){
        manageService.saveAttrInfo(attrInfo);
    }
}
