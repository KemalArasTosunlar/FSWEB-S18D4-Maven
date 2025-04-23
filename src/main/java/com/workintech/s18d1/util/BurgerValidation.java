package com.workintech.s18d1.util;

import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void checkName(String name) {
        if(name==null || name.isEmpty() ){
            throw new BurgerException("name is null or empthy", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdValid(Long id)
    {
        if(id <= 0)
        {
            throw new BurgerException("Id is wrong", HttpStatus.BAD_REQUEST);
        }
    }
}