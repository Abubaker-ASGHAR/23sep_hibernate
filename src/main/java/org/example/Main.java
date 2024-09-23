package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;



public class Main {
    public static void main(String[] args) {

      Session session =HibernateUtil.getSeesionFactory().openSession();
       Transaction transaction = null;

       try {

           transaction = session.beginTransaction();

           User user = new User();
           user.setName("ABUBAKER1");
           user.setEmail("abubaker@gmail1.com");

           Address address = new Address();
           address.setCity("222 xyx1");
           address.setStreet("technosoft1");


           user.setAddress(address);
           address.setUser(user);

           session.save(user);

           transaction.commit();


           session=HibernateUtil.getSeesionFactory().openSession();
           String hql="from User";
           Query query=session.createQuery(hql,User.class);
           List<User> list=query.list();
           for(User u:list){
               System.out.println("User: " + u.getName() + ", Email: " + u.getEmail());
               if (u.getAddress() != null) {
                   System.out.println("Address: " + u.getAddress().getStreet() + ", " + u.getAddress().getCity());
               }
           }




       }
       catch (Exception e) {

           if(transaction != null) transaction.rollback();
           e.printStackTrace();
       }
       finally {
           session.close();
           HibernateUtil.getSeesionFactory().close();
       }



    }
}