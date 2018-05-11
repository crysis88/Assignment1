package com.assignment.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class DatabaseUtility {

    private static final Logger log = LogManager.getLogger(DatabaseUtility.class);

    private static SqlSessionFactory sessionFactory;

    private static final String MYBATISCONFIG = "mybatis-config.xml";

    public static SqlSessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (DatabaseUtility.class) {
                if (sessionFactory == null) {
                    try {
                        InputStream inputStream = Resources.getResourceAsStream(MYBATISCONFIG);
                        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    } catch (IOException exception) {
                        log.error(exception.getMessage(), exception);
                    }
                }
            }
        }
        return sessionFactory;
    }
}

