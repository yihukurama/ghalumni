package com.ghds.alumni.app.component.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface SqlWhere {

    SqlWhereValue value();
    String proprtityName();


    public static enum SqlWhereValue{
        GT(" > "),
        LT(" < "),
        GTE(" >= "),
        LTE(" <= "),
        LIKE(" like "),
        IN(" in ");
        private  String value;

        public String getValue() {
            return value;
        }

        private SqlWhereValue(String value){
            this.value = value;
        }
    }
}


