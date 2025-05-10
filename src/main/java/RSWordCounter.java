import static java.lang.Character.isLetter;

public class RSWordCounter {

    public int count(String str) {
      /* A */  int words = 0;
      /* A */    char last = ' ';
            /* A */     /* B */     /* F */
        for (int i = 0; i < str.length(); i++) {
        /* C */  if (!isLetter(str.charAt(i)) && (last == 's' || last == 'r'))
        /* D */      words++;
        /* E */    last = str.charAt(i);
                 }

    /* G */ if (last == 'r' || last == 's')
    /* H */    words++;
    /* I */    return words;
    }

}
