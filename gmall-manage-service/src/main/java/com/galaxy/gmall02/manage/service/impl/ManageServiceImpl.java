package com.galaxy.gmall02.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.galaxy.gmall02.bean.*;
import com.galaxy.gmall02.manage.IManageService;
import com.galaxy.gmall02.manage.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 裴一飞
 * @date 2020/11/25 - 10:36
 */
@Service
@Transactional
public class ManageServiceImpl implements IManageService {
    @Autowired
    private BaseCatalog1Mapper catalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper catalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper catalog3Mapper;
    @Autowired
    private BaseAttrInfoMapper attrInfoMapper;
    @Autowired
    private BaseAttrValueMapper attrValueMapper;

    @Override
    public List<BaseCatalog1> getCatalog1s() {
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getCatalog2s(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        return catalog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> getCatalog3s(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        return catalog3Mapper.select(baseCatalog3);
    }

    @Override
    public List<BaseAttrInfo> getAttrInfos(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        return attrInfoMapper.select(baseAttrInfo);
    }

    @Override
    public BaseAttrInfo getAttrInfo(String attrId) {
        //1.根据attrId查询出attrInfo
        BaseAttrInfo baseAttrInfo = attrInfoMapper.selectByPrimaryKey(attrId);
        //2.再根据attrId查询出attrValueList
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        List<BaseAttrValue> baseAttrValues = attrValueMapper.select(baseAttrValue);
        //3.封装到attrInfo属性中
        baseAttrInfo.setAttrValueList(baseAttrValues);
        //4.返回attrInfo对象
        return baseAttrInfo;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo attrInfo) {
        //-----------对attrInfo的操作
        //有id就保存
        if (StringUtils.isBlank(attrInfo.getId())){
            attrInfoMapper.insertSelective(attrInfo);
        }else{
            //没id就修改
            attrInfoMapper.updateByPrimaryKeySelective(attrInfo);
        }
        //---------对attrValue操作
        //删除attrId对应的attrvalue表中的数据
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrInfo.getId());
        attrValueMapper.delete(baseAttrValue);
        //插入attrvalue 即是更新和新增都有了
        List<BaseAttrValue> attrValueList = attrInfo.getAttrValueList();
        for (BaseAttrValue attrValue : attrValueList) {
            //设置外键列
            attrValue.setId(null);
            attrValue.setAttrId(attrInfo.getId());
            attrValueMapper.insert(attrValue);
        }
    }
}
