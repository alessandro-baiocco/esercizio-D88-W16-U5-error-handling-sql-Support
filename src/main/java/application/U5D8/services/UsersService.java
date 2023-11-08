package application.U5D8.services;

import application.U5D8.entities.User;
import application.U5D8.exceptions.NotUserFoundException;
import application.U5D8.repositories.BlogRepository;
import application.U5D8.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.ListIterator;


@Service
public class UsersService {

    @Autowired
    private UserRepository userRepo;


    public User save(User body){
        userRepo.save(body);
        return body;
    }



    public User findById(int id) throws NotUserFoundException{
        return userRepo.findById(id).orElseThrow(() -> new NotUserFoundException(id));
    }




    public List<User> getAllUser(){
        return userRepo.findAll();
    }




    public void findByIdAndDelete(int id){

        ListIterator<User> iterator = this.users.listIterator();
        while (iterator.hasNext()){
            User current = iterator.next();
            if (current.getId() == id){
                iterator.remove();
                System.out.println("utente con id " + id + " è stato rimosso");
            }

        }


    }


    public User findByIdAndUpdate(int id , User body){
        User found = null;
        for(User user:this.users){
            if(user.getId() == id){
                found = user;
                found.setNome(body.getNome() != null ? body.getNome() : found.getNome());
                found.setCognome(body.getCognome()  != null ? body.getCognome() : found.getCognome());
                found.setUserPicture("https://ui-avatars.com/api/?name=" + body.getNome() + "&surname=" + body.getCognome() );
                found.setEmail(body.getEmail()  != null ? body.getEmail() : found.getEmail());
                found.setDataDiNascita(body.getDataDiNascita() != null ? body.getDataDiNascita() : found.getDataDiNascita());
            }
        }
        if(found == null){
            throw new NotUserFoundException(id);
        }else {
            System.out.println("utente modificato corretamente");
            return found;
        }

    }


}
