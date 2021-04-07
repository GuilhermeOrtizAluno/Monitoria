
package app;

import crud.UserDAO;
import dice.User;

/**
 *
 * @author Guilherme Ortiz
 */
public class Main {
    
    public static void main(String[] args) {
        UserDAO userDao = new UserDAO();
    
        User userCreate = new User();
        userCreate.setUsuario("admin");
        userCreate.setNome("admin");
        userCreate.setSenha("123");
        userCreate.setIs_monitor(false);
        userCreate.setIs_admin(true);
        
        userDao.create(userCreate);
        
        for(User u : userDao.read()){
            System.out.println("Nome: "+u.getNome());
        }
    }
    
}
