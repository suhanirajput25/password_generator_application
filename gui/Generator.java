package gui_package;

public class Generator{
    Alphabet alphabet;
    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }
    
	public Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }
   public static void requestPassword(boolean uc, boolean lc, boolean num, boolean sp, int len) {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;
        int length=8;
        
        IncludeUpper = uc;
        IncludeLower = lc;
        IncludeNum = num;
        IncludeSym = sp;
        length=len;
        if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
             System.out.println("error");
             main_gui.tp.setText("No character included");
        }
        if(length==0) {
        	main_gui.tp.setText("zero length");
        }
        Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
        Password password = generator.GeneratePassword(length);

        //System.out.println("Your generated password -> " + password);
        main_gui.tp.setText(password.toString());
        
    }

    public void checkPassword() {
        String input;
        System.out.print("\nEnter your password:");
        input = "password inputed";
        final Password p = new Password(input);
        System.out.println(p.calculateScore());
    }

    

    
}
