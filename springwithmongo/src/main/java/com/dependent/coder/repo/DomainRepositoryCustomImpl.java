package com.dependent.coder.repo;


import com.dependent.coder.model.Domain;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

//Impl postfix of the name on it compared to the core repository interface
public class DomainRepositoryCustomImpl implements DomainRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int updateDomain(String domain, boolean displayAds) {

        Query query = new Query(Criteria.where("domain").is(domain));
        Update update = new Update();
        update.set("displayAds", displayAds);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Domain.class);

        if(result!=null)
            return 1;
        else
            return 0;

    }
}

