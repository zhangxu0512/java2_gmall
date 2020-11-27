package com.galaxy.gmall02.manage;

import com.galaxy.gmall02.bean.BaseAttrInfo;
import com.galaxy.gmall02.bean.BaseCatalog1;
import com.galaxy.gmall02.bean.BaseCatalog2;
import com.galaxy.gmall02.bean.BaseCatalog3;

import java.util.List;

/**
 * @author 裴一飞
 * @date 2020/11/25 - 10:31
 */
public interface IManageService {
    //查询所有一级分类
    List<BaseCatalog1> getCatalog1s();
    //根据一级分类的id查询二级分类
    List<BaseCatalog2> getCatalog2s(String catalog1Id);
    //根据二级分类的id查询三级分类
    List<BaseCatalog3> getCatalog3s(String catalog2Id);
    //根据三级分类的id查询平台属性
    List<BaseAttrInfo> getAttrInfos(String catalog3Id);

    BaseAttrInfo getAttrInfo(String attrId);

    /**
     * 即保存attrInfo
     * 又修改attrValue
     * 二合一
     * @param attrInfo
     */
    void saveAttrInfo(BaseAttrInfo attrInfo);
}
