package application.U5D8.exceptions;

public class NotUserFoundException extends RuntimeException {
    public NotUserFoundException(int id){
        super("l'utente con id " + id + " non è stato trovato");
    }
}
