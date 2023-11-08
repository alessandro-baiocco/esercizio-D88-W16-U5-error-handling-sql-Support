package application.U5D8.services;

import application.U5D8.entities.Blog;
import application.U5D8.exceptions.NotBlogFoundException;
import application.U5D8.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;




@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepo;


    public Blog save(Blog body){
        body.setCover("https://picsum.photos/200/300");
        blogRepo.save(body);
        return body;
    }


    public List<Blog> getAllBlogs(){
        return blogRepo.findAll();
    }



    public Blog findById(int id) throws NotBlogFoundException{
      return blogRepo.findById(id).orElseThrow(() -> new NotBlogFoundException(id));
    }
    public void findByIdAndDelete(int id) throws NotBlogFoundException{
        Blog found = findById(id);
        blogRepo.delete(found);
    }


    public Blog findByIdAndUpdate(int id , Blog body) throws NotBlogFoundException{
         Blog found = findById(id);
                found.setBlogCategory(body.getBlogCategory());
                found.setCover(body.getCover());
                found.setContenuto(body.getContenuto());
                found.setTitolo(body.getTitolo());
                found.setTempoDiLettura(body.getTempoDiLettura());
                found.setUtente(found.getUtente());
                return blogRepo.save(found);

    }



}
