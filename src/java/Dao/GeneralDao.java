
package Dao;

import java.util.List;
import org.hibernate.Session;
import Util.HibernateUtil;


public class GeneralDao <ClassName>{
    private Class<ClassName> type;
    
    public GeneralDao(Class<ClassName> type){
        this.type = type;
    }
    
    Session session = null;
    
    public ClassName create(ClassName cObj){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            session.save(cObj);
            session.getTransaction().commit();
            session.close();
            return  cObj;
        } catch (Exception e) {
            return null;
        }  
    }
    public ClassName update(ClassName cObj){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.update(cObj);
            session.getTransaction().commit();
            session.close();
            return cObj;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean delete(ClassName cObj){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.delete(cObj);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public ClassName findByINT_PK(String pk){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            ClassName  cObj = (ClassName)session.get(type, pk);
            session.getTransaction().commit();
            session.close();
            return cObj;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ClassName findBySTRING_PK(String pk){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
             ClassName cObj = (ClassName)session.get(type, pk);
            session.getTransaction().commit();
            session.close();
            return cObj;
        } catch (Exception e) {
            return null;
        }
    }
    public ClassName findById(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
             ClassName cObj = (ClassName)session.get(type, id);
            session.getTransaction().commit();
            session.close();
            return cObj;
        } catch (Exception e) {
            return null;
        }
    }
    public List<ClassName> listAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
             List<ClassName> list = session.createCriteria(type.getName()).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
    

