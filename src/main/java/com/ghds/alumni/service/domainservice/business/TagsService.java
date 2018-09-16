package com.ghds.alumni.service.domainservice.business;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.domain.tkmapper.entity.business.TagsEntity;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.stereotype.Service;

@Service
public class TagsService extends CrudService<TagsEntity> {


    @Override
    public TagsEntity create(TagsEntity tagsEntity) throws TipsException {
        if(tagsEntity.getText()!=null
                && tagsEntity.getText().length()>4){
            throw new TipsException("标签名不能超过4个字");
        }
        return super.create(tagsEntity);
    }
}
