package com.dijitalmarketim.dijitalmarketimservice.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

   /* private ExceptionMessages(){

    }*/

    public static final String USER_NOT_FOUND = "customer bulunamadı!";
}
