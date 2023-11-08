package application.U5D8.exceptions;

public class NotBlogFoundException extends RuntimeException {
    public NotBlogFoundException(int id){
        super("il blog con id " + id + " non è stato trovato");}
    }
