/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gym;

import com.data.connection;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * Name: marwan moataz
 * ID: 19107708
 */
public class admin_Details {
 Connection con =connection.connect();
    PreparedStatement ps =null;
    ResultSet rs=null;
    String name= "";
    int flag =0;
    
    ArrayList<String> listWithoutDuplicates ;
 Object data[]=new Object[]{""};
    int get_Total_Users_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `users` WHERE status = 2";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
     int get_Total_Coaches_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `users` WHERE status = 1";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
     int get_Total_Exms_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `users` WHERE expired = 1";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
      int get_Total_Banusers_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `users` WHERE banned = 1";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
       int get_Total_Notification_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `notification`";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
         int get_Completed_Payments_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `Payments` WHERE status = 'completed'";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
         int get_Pending_Payments_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `Payments` WHERE status = 'pending'";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
           int get_all_Total_Payments_count(){
              int i=0;
        try {
         String get_all_users = "SELECT * FROM `Payments`";
         ps = con.prepareStatement(get_all_users);
         rs = ps.executeQuery();
         while(rs.next()){
             i++;
         }
     } catch (SQLException ex) {
         Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
    }
         
          void add_newCoach(String name,String pw , String address , String pn,String usersex, String age){
         String insert_newUser = "INSERT INTO users (name, password, address, pn, sex, age, status, banned, expired) VALUES('"+name+"','"+pw+"','"+address+"','"+pn+"','"+usersex+"','"+age+"','1','0','0');";
          try {
                      PreparedStatement stmt = con.prepareStatement(insert_newUser);
stmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "New Coach Added");

               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "This UserName Is Exsist");
                    Logger.getLogger(User_Details.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
         
   Object[] get_notification(){
       try{
        ArrayList<String> m_names = new ArrayList<String>();
       String table_id="";
       String senter_name="";
        String m_name="";
       String msg="";
       String time = "";
          if (flag==0){
       
         String get_schedule = "SELECT * FROM `notification`";
        
      ps = con.prepareStatement(get_schedule);
                    rs = ps.executeQuery();
          flag=1;}
          rs.next();
          table_id = rs.getString("id");
        senter_name= rs.getString("senter_name");
        m_name = rs.getString("m_name");
        m_names.add(rs.getString("m_name"));
        msg = rs.getString("msg");
        time = rs.getString("time");
               LinkedHashSet<String> hashSet = new LinkedHashSet<>(m_names);
            listWithoutDuplicates   = new ArrayList<>(hashSet);
data = new Object[] {table_id,senter_name,m_name,msg,time};
                       return data;

             } catch (SQLException ex) {
                 Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
             }
       return null;
       }
    
         Object[] get_Payments(){
       try{
        String Table_id="";
        String m_id="";
        String c_id="";
        String price = "";
        String status = "";
        String cardNum = "";
        String TransactionId = "";
        String Type_membership = "";
                if (flag==1){
       
         String get_schedule = "SELECT * FROM `payments`";
        
      ps = con.prepareStatement(get_schedule);
                    rs = ps.executeQuery();
          flag=0;}
          rs.next();
          Table_id = rs.getString("id");
          m_id = rs.getString("m_id");
          c_id = rs.getString("c_id");
          price = rs.getString("price");
          status = rs.getString("status");
          cardNum = rs.getString("cardNum");
          TransactionId = rs.getString("TransactionId");
          Type_membership = rs.getString("Type_membership");
          
data = new Object[] {Table_id,m_id,c_id,price,status,cardNum,TransactionId,Type_membership};
                       return data;

             } catch (SQLException ex) {
                 Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
             }
       return null;
       }
           Object[] refresh_get_Payments(){
       try{
        String Table_id="";
        String m_id="";
        String c_id="";
        String price = "";
        String status = "";
        String cardNum = "";
        String TransactionId = "";
        String Type_membership = "";
                if (flag==0){
       
         String get_schedule = "SELECT * FROM `payments`";
        
      ps = con.prepareStatement(get_schedule);
                    rs = ps.executeQuery();
          flag=1;}
          rs.next();
          Table_id = rs.getString("id");
          m_id = rs.getString("m_id");
          c_id = rs.getString("c_id");
          price = rs.getString("price");
          status = rs.getString("status");
          cardNum = rs.getString("cardNum");
          TransactionId = rs.getString("TransactionId");
          Type_membership = rs.getString("Type_membership");
          
data = new Object[] {Table_id,m_id,c_id,price,status,cardNum,TransactionId,Type_membership};
                       return data;

             } catch (SQLException ex) {
                 Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
             }
       return null;
       }
         Object[] get_Completed_Payments(){
       try{
        String Table_id="";
        String m_id="";
        String c_id="";
        String price = "";
        String status = "";
        String cardNum = "";
        String TransactionId = "";
        String Type_membership = "";
                if (flag==0){
       
         String get_schedule = "SELECT * FROM `payments` WHERE status = 'completed'";
        
      ps = con.prepareStatement(get_schedule);
                    rs = ps.executeQuery();
          flag=1;}
          rs.next();
          Table_id = rs.getString("id");
          m_id = rs.getString("m_id");
          c_id = rs.getString("c_id");
          price = rs.getString("price");
          status = rs.getString("status");
          cardNum = rs.getString("cardNum");
          TransactionId = rs.getString("TransactionId");
          Type_membership = rs.getString("Type_membership");
          
data = new Object[] {Table_id,m_id,c_id,price,status,cardNum,TransactionId,Type_membership};
                       return data;

             } catch (SQLException ex) {
                 Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
             }
       return null;
       }
         Object[] get_Pending_Payments(){
       try{
        String Table_id="";
        String m_id="";
        String c_id="";
        String price = "";
        String status = "";
        String cardNum = "";
        String TransactionId = "";
        String Type_membership = "";
                if (flag==0){
       
         String get_schedule = "SELECT * FROM `payments` WHERE status = 'pending'";
        
      ps = con.prepareStatement(get_schedule);
                    rs = ps.executeQuery();
          flag=1;}
          rs.next();
          Table_id = rs.getString("id");
          m_id = rs.getString("m_id");
          c_id = rs.getString("c_id");
          price = rs.getString("price");
          status = rs.getString("status");
          cardNum = rs.getString("cardNum");
          TransactionId = rs.getString("TransactionId");
          Type_membership = rs.getString("Type_membership");
          
data = new Object[] {Table_id,m_id,c_id,price,status,cardNum,TransactionId,Type_membership};
                       return data;

             } catch (SQLException ex) {
                 Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
             }
       return null;
       }
         Object[] get_members_data(){
       try{
        String Table_id="";
        String name="";
        String pass="";
        String address = "";
        String pn = "";
        String sex = "";
        String age = "";
        String status = "";
        String banned = "";
        String rdate = "";
        String enddate = "";
        String expired = "";
        String m_type = "";


                if (flag==0){
       
         String get_schedule = "SELECT * FROM `users` WHERE status = 2";
        
      ps = con.prepareStatement(get_schedule);
                    rs = ps.executeQuery();
          flag=1;}
          rs.next();
          Table_id = rs.getString("id");
          name = rs.getString("name");
          pass = rs.getString("password");
          address = rs.getString("address");
          pn = rs.getString("pn");
          sex = rs.getString("sex");
          age = rs.getString("age");
          status = rs.getString("status");
          banned = rs.getString("banned");
          rdate = rs.getString("rdate");
          enddate = rs.getString("enddate");
          expired = rs.getString("expired");
          m_type = rs.getString("memb_type");

data = new Object[] {Table_id,name,pass,address,pn,sex,age,status,banned,rdate,enddate,expired,m_type};
                       return data;

             } catch (SQLException ex) {
                 Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
             }
       return null;
       }
          Object[] get_couches_data(){
       try{
        String Table_id="";
        String name="";
        String pass="";
        String address = "";
        String pn = "";
        String sex = "";
        String age = "";
        String status = "";
        String banned = "";
        String rdate = "";
        String enddate = "";
        String expired = "";
        String m_type = "";


                if (flag==1){
       
         String get_schedule = "SELECT * FROM `users` WHERE status = 1";
        
      ps = con.prepareStatement(get_schedule);
                    rs = ps.executeQuery();
          flag=0;}
          rs.next();
          Table_id = rs.getString("id");
          name = rs.getString("name");
          pass = rs.getString("password");
          address = rs.getString("address");
          pn = rs.getString("pn");
          sex = rs.getString("sex");
          age = rs.getString("age");
          status = rs.getString("status");
          banned = rs.getString("banned");
          rdate = rs.getString("rdate");
          enddate = rs.getString("enddate");
          expired = rs.getString("expired");

data = new Object[] {Table_id,name,pass,address,pn,sex,age,status,banned,rdate,enddate,expired};
                       return data;

             } catch (SQLException ex) {
                 Logger.getLogger(admin_Details.class.getName()).log(Level.SEVERE, null, ex);
             }
       return null;
       }
          void auto_restart(){
      try {
            final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            final File currentJar = new File(userF.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            
            /* is it a jar file? */
            if(!currentJar.getName().endsWith(".jar"))
                return;
            
            /* Build command: java -jar application.jar */
            final ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());
            
            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (URISyntaxException ex) {
            Logger.getLogger(userF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(userF.class.getName()).log(Level.SEVERE, null, ex);
        }
}
          void update_Notification(String id,String m_name,String m_id,String msg){
        try {
            String updated = "UPDATE notification SET m_name = ? , m_id = ? , msg = ? WHERE id = "+id;
             ps = con.prepareStatement(updated);
            ps.setString(1, m_name);
            ps.setString(2, m_id);
            ps.setString(3, msg);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your Information Updated");
        } catch (SQLException ex) {
            Logger.getLogger(User_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
           String get_idByName(String name){
       try{
        String get_uname = "SELECT * FROM `users` WHERE name = '"+name+"'";
            ps = con.prepareStatement(get_uname);
            rs= ps.executeQuery();
            String user_id = rs.getString("id");
            return user_id;
       }catch(SQLException ex) {
}
       return "";
    }

    void insert_Notification(String senter_name,String m_name,String c_id,String m_id,String msg,String time){
         String insert_newNotification = "INSERT INTO notification (senter_name, m_name, c_id, m_id, msg, time) VALUES('"+senter_name+"','"+m_name+"','"+c_id+"','"+m_id+"','"+msg+"','"+time+"');";
          try {
                      PreparedStatement stmt = con.prepareStatement(insert_newNotification);
stmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "Notification Sent.");
      } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Error In add Notification");
                    Logger.getLogger(User_Details.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
         void ban_User(String name,String ban){
     try {
         String updated = "UPDATE users SET banned = ? WHERE name = '"+name+"'";
         ps = con.prepareStatement(updated);
         if(ban.equals("0")){
         ps.setString(1, ban);
          ps.executeUpdate();
    JOptionPane.showMessageDialog(null, "UnBaned User Done");
         }
         else{
             ps.setString(1, ban);
             ps.executeUpdate();
    JOptionPane.showMessageDialog(null, "Banned User Done");
         }
        
     } catch (SQLException ex) {
         Logger.getLogger(coach_details.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
          void conclose(){
       try{
       con.close();
       }
       catch(Exception x){
           
       }
          }
          
          
//coded with ❤ by marwaneldesouki
}
