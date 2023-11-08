package application.U5D8.services;

import application.U5D8.entities.User;
import application.U5D8.exceptions.NotUserFoundException;
import application.U5D8.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UsersService {

    @Autowired
    private UserRepository userRepo;


    public User save(User body){
        body.setUserPicture("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        userRepo.save(body);
        return body;
    }



    public User findById(int id) throws NotUserFoundException{
        return userRepo.findById(id).orElseThrow(() -> new NotUserFoundException(id));
    }




    public List<User> getAllUser(){
        return userRepo.findAll();
    }




    public void findByIdAndDelete(int id) throws NotUserFoundException{
        User found = findById(id);
        userRepo.delete(found);
    }


    public User findByIdAndUpdate(int id , User body) throws NotUserFoundException{
        User found = findById(id);
                found.setNome(body.getNome() != null ? body.getNome() : found.getNome());
                found.setCognome(body.getCognome()  != null ? body.getCognome() : found.getCognome());
                found.setUserPicture("https://ui-avatars.com/api/?name=" + body.getNome() + "&surname=" + body.getCognome() );
                found.setEmail(body.getEmail()  != null ? body.getEmail() : found.getEmail());
                found.setDataDiNascita(body.getDataDiNascita() != null ? body.getDataDiNascita() : found.getDataDiNascita());
                found.setBlogs(found.getBlogs());
                userRepo.save(found);
                return found;
    }


}
