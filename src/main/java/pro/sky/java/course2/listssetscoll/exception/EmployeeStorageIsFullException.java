package pro.sky.java.course2.listssetscoll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class EmployeeStorageIsFullException extends RuntimeException{

}
