package application.U5D8.services;

import application.U5D8.entities.Blog;
import application.U5D8.entities.PostBlog;
import application.U5D8.entities.User;
import application.U5D8.exceptions.NotBlogFoundException;
import application.U5D8.exceptions.NotUserFoundException;
import application.U5D8.repositories.BlogRepository;
import application.U5D8.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepo;
    @Autowired
    private UserRepository userRepository;


    public Blog save(PostBlog body){
        body.setCover("https://picsum.photos/200/300");
        User autorPost = userRepository.findById(body.getUtente_id()).orElseThrow(() -> new NotUserFoundException(body.getUtente_id()));
            Blog newBlog = new Blog().builder()
                    .blogCategory(body.getBlogCategory())
                    .cover(body.getCover())
                    .contenuto(body.getContenuto())
                    .titolo(body.getTitolo()).utente(autorPost)
                    .tempoDiLettura(body.getTempoDiLettura())
                    .build();




        blogRepo.save(newBlog);
        return newBlog;
    }


    public Page<Blog> getAllBlogs(int page , int size){
        Pageable pageable = PageRequest.of(page, size);
        return blogRepo.findAll(pageable);
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
