package com.portfolio.catalogservice.error;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<?> invalid(MethodArgumentNotValidException e) { var fields=new LinkedHashMap<String,String>(); e.getBindingResult().getFieldErrors().forEach(x->fields.putIfAbsent(x.getField(),x.getDefaultMessage())); return ResponseEntity.badRequest().body(Map.of("error","Validation failed","fields",fields)); }
 @ExceptionHandler(Exception.class) ResponseEntity<?> unexpected(Exception e) { return ResponseEntity.status(500).body(Map.of("error","Unexpected server error")); }
}
