public class Identifier {

    public Identifier(){

    }


    public boolean isValidIdentifier(String identificador) {

        if(identificador == null){
            return false;
        }

        if (identificador.isEmpty() || identificador.length() > 6) {
            return false;
        }

        if (!Character.isLetter(identificador.charAt(0))) {
            return false;
        }


        for (int i = 0; i < identificador.length(); i++) {
            char c = identificador.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
