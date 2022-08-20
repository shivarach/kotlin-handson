package org.shiva.kotlin.basics.function;

import org.shiva.kotlin.ConstantsKt;
import org.shiva.kotlin.oops.BookingService;

public class FunctionJavaClient {
    public static void main(String[] args) {
//      To refer kotlin methods or fields append 'Kt' to kotlin file
        FunctionDefinitionKt.displayCharacter();
        FunctionDefinitionKt.displayCharacter('$');
        FunctionDefinitionKt.displayCharacter('&', 3);
        FunctionDefinitionKt.displayMax(3, 4);

//        Util.displayCharacter();  // Refer kotlin method like if you '@file:JvmName("Util")' in kotlin

        BookingService service = ConstantsKt.service; // Refers field in a kotlin file Constants.kt
    }


}
