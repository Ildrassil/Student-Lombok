public class StudentNotFoundException extends Exception {

    StudentNotFoundException(String message){
     super(message);
    }
    StudentNotFoundException(String message, Exception e){
        super(message,e);
    }
}
