
package Model;

import Dao.GeneralDao;
import Entity.Account;
import Entity.Deposit;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="acc")
@SessionScoped
public class AccountRegistration {
       private  Account acnt = new Account();
       private GeneralDao<Account> daos = new GeneralDao<>(Account.class);
      // private  Deposit dep = new Deposit();
       //private GeneralDao<Deposit> dao = new GeneralDao<>(Deposit.class);
         
    public String registerAccount(){
      
        try {
            
             if(daos.findBySTRING_PK(acnt.getAccountNo())!=null){
                 FacesContext face = FacesContext.getCurrentInstance();
                 face.addMessage("ErrorMessage", new FacesMessage("The Account Already Exit"));
                 return "AccountRegistrationForm";
             }else{
                 
                acnt.setAmount(1000);
                 daos.create(acnt);
                 
             }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Failed to Save"+ e);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            return "AccountRegistrationForm";
        }
       
       
            return "LoginForm";
    }
    
    public String DepositAmount(){
      List<Account> list = getaccList();
      for(Account a:list){
          if(a.getAccountNo().equals(acnt.getAccountNo())){
              a.setAmount(a.getAmount()+acnt.getAmount());
              daos.update(a);
          }else{
           return "MenuForm";

          }
      }
        return null;
    }
    
     public String Withdraw(){
      List<Account> list = getaccList();
      for(Account a:list){
          if(a.getAccountNo().equals(acnt.getAccountNo())){
              a.setAmount(a.getAmount()-acnt.getAmount());
              daos.update(a);
          }
      }
        return "MenuForm";
    }
    
    public String login(){
     List<Account> List = getaccList();
     for(Account a:List){
         if(a.getName().equals(acnt.getName())&&a.getPassword().equals((acnt.getPassword()))){
             return "MenuForm";
         }else{
             return "LoginForm";
             
         }
     }
     return null;
     
    }
    public Account getAcnt() {
        return acnt;
    }

    public List<Account> getaccList() {
        return daos.listAll();
    }

   // public Deposit getDep() {
   //     return dep;
    //}

   // public  List<Deposit> getdepList() {
    //    return dao.listAll();
   // }

   
        
}
