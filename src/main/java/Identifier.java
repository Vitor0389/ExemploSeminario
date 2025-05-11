public class Identifier {

    public Identifier(){

    }


    public boolean isValidIdentifier(String identificador) {

        /* A */

        /* B */
        if(identificador == null){
            /* c */
            return false;
        }
            /* D */                     /* E */
        if (identificador.isEmpty() || identificador.length() > 6) {
            /* F */
            return false;
        }

        /* G */
        if (!Character.isLetter(identificador.charAt(0))) {

            /* H */
            return false;
        }

            /* I */     /* J */
        for (int i = 0; i < identificador.length(); i++) {
            /* K */
            char c = identificador.charAt(i);
            /* L */
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
