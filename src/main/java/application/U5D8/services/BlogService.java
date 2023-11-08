package application.U5D8.services;

import application.U5D8.entities.Blog;
import application.U5D8.exceptions.NotUserFoundException;
import application.U5D8.repositories.BlogRepository;
import application.U5D8.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;



@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepo;


    public Blog save(Blog body){
        Random rnd = new Random();
        body.setId(rnd.nextInt(1 , 1000));
        this.blogs.add(body);
        return body;
    }


    public List<Blog> getAllBlogs(){
        return this.blogs;
    }



    public Blog findById(int id){
        Blog found = null;
        for(Blog blog : this.blogs){
            if(blog.getId() == id){
                found = blog;
            }
        }
        if (found == null){
            throw new NotUserFoundException(id);
        }else {
            return found;
        }
    }
    public void findByIdAndDelete(int id){

        ListIterator<Blog> iterator = this.blogs.listIterator();
        while (iterator.hasNext()){
            Blog current = iterator.next();
            if (current.getId() == id){
                iterator.remove();
                System.out.println("il blog con id " + id + " è stato rimosso");
            }

        }


    }


    public Blog findByIdAndUpdate(int id , Blog body){
        Blog found = null;
        for(Blog blog:this.blogs){
            if(blog.getId() == id){
                found = blog;
                found.setBlogCategory(body.getBlogCategory());
                found.setCover(body.getCover());
                found.setContenuto(body.getContenuto());
                found.setTitolo(body.getTitolo());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if(found == null){
            throw new NotUserFoundException(id);
        }else {
            System.out.println("blog modificato corretamente");
            return found;
        }

    }



}
