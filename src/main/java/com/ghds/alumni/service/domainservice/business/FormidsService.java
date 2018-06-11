package com.ghds.alumni.service.domainservice.business;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.YstUtils;
import com.ghds.alumni.domain.business.Formids;
import com.ghds.alumni.domain.tkmapper.entity.business.FormidsEntity;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明： Formids的领域服务
 * @author: ouyaokun
 * @date: Created in 9:44 2018/5/7
 * @modified: by autor in 9:44 2018/5/7
 */
@Service
public class FormidsService extends CrudService<FormidsEntity> {

    @Override
    public FormidsEntity create(FormidsEntity formidsEntity) throws TipsException {
        Formids formids = YstUtils.transferEntity2Domain(formidsEntity, Formids.class);
        if(EmptyUtil.isEmpty(formids.getFormId())){
            throw new TipsException("formId不能为空");
        }

        //查询formId是否存在，存在则不能创建
        FormidsEntity search = new FormidsEntity();
        search.setFormId(formids.getFormId());
        FormidsEntity oldFormidsEntity = loadOneByCondition(search);
        if(oldFormidsEntity != null){
            throw new TipsException("formId已存在");
        }
        formidsEntity.setStatus(Formids.STATUS_1);
        return super.create(formidsEntity);
    }

    /**
     * 说明： 获取可使用的formId
     * @author: dengshuai
     * @date: Created in 16:05 2018/2/11
     * @modified: by autor in 16:05 2018/2/11
     */
    public String doGetFormId(FormidsEntity formidsEntity) throws TipsException {
        if(EmptyUtil.isEmpty(formidsEntity.getOpenId())){
            return "";
        }
        formidsEntity.setStatus(Formids.STATUS_1);
        List<FormidsEntity> resultList = list(formidsEntity);

        if(!EmptyUtil.isEmpty(resultList)){
            return resultList.get(0).getFormId();
        }
        return "";
    }
}
