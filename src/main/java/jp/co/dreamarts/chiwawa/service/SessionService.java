package jp.co.dreamarts.chiwawa.service;

import jp.co.dreamarts.chiwawa.dao.SessionDao;
import jp.co.dreamarts.chiwawa.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SessionService {

    @Autowired
    private SessionDao sessionDao;

    public Session getSession(String companyId, String loginId) {
        return sessionDao.findByPk(companyId, loginId);
    }
}
