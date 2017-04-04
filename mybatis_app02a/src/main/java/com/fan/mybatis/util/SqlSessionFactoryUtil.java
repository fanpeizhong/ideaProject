package com.fan.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 范培忠 on 2017/3/9.
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    //类线程锁
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    //单例模式：私有化构造函数
    private SqlSessionFactoryUtil() {
    }

    public static SqlSessionFactory initSqlSessionFactory() {
        String resource = "Configuration.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName())
                    .log(Level.SEVERE, "建立Configuration.xml输入流失败！", e);
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }//synchronized

        return sqlSessionFactory;
    }//initSqlSessionFactory()

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
