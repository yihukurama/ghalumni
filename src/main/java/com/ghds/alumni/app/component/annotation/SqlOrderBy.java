package com.ghds.alumni.app.component.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface SqlOrderBy {

    SqlOrderByValue value();
    String proprtityName();


    public static enum SqlOrderByValue{
        DESC(" DESC "),
        ASC(" ASC ")
        ;
        private  String value;


        public String getValue() {
            return value;
        }

        private SqlOrderByValue(String value){
            this.value = value;
        }
    }
}


