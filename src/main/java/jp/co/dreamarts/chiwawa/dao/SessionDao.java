package jp.co.dreamarts.chiwawa.dao;

import jp.co.dreamarts.chiwawa.entity.Session;
import ninja.cero.sqltemplate.core.SqlTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionDao {

    @Autowired
    private SqlTemplate sqlTemplate;

    public Session findByPk(String companyId, String userId) {
        return sqlTemplate.forObject("sql/sessionDao/findByPk.sql", Session.class, companyId, userId);
    }

}
