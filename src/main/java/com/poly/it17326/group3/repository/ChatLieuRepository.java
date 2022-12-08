
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.ChatLieu;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ChatLieuRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM ChatLieu"; 
    
    public List<ChatLieu> getAll(){
        Query query = session.createQuery(fromTable,ChatLieu.class);
        return query.getResultList();
    }
    
    public Boolean add(ChatLieu chatLieu){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(chatLieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean update(ChatLieu chatLieu){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(chatLieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean delete(ChatLieu chatLieu){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(chatLieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
        public ChatLieu getOne(int id) {
        String sql = fromTable + " where id=:id";
        Query query = session.createQuery(sql, ChatLieu.class);
        query.setParameter("id", id);
        return (ChatLieu) query.getSingleResult();
        
    }
//     public static void main(String[] args) {
//        List<ChatLieu> chatLieus = new ChatLieuRepository().getAll();
//        for(ChatLieu chatLieu : chatLieus){
//            System.out.println(chatLieus.toString());
//        }
//    }
}
