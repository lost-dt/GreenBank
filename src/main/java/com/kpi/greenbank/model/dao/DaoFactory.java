package com.kpi.greenbank.model.dao;

import com.kpi.greenbank.model.dao.implementation.JDBCDaoFactory;
import com.kpi.greenbank.model.dao.interfase.AmountTransactionDao;
import com.kpi.greenbank.model.dao.interfase.UserDao;

public abstract class DaoFactory {

    private volatile static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract AmountTransactionDao createAmountTransactionDao();


    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    daoFactory = (DaoFactory) new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
