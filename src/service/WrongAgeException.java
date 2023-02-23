package service;

import java.io.IOException;

public class WrongAgeException extends IOException  {
    @Override
    public String getMessage() {
        return "Wrong input! Try again!";
    }
}
