/********************************************
Scanner.java
Hamza Saeed
Date Modified: 04/05/2017
********************************************/
 
import java_cup.runtime.*;
/* import sym; */
 
public class scanner {
  /* single lookahead character */
  protected static int next_char;
 
  /* advance input by one character */
  protected static void advance()
    throws java.io.IOException
    { next_char = System.in.read(); }
 
  /* initialize the scanner */
  public static void init()
    throws java.io.IOException
    { advance(); }
 
  /* recognize and return the next complete token */
  public static Symbol next_token()
    throws java.io.IOException
    {
      for (;;)
        switch (next_char)
          {
            case '0': advance(); return new Symbol(sym.INT, new Integer(0));
            case '1': advance(); return new Symbol(sym.INT, new Integer(1));
            case '?': advance(); return new Symbol(sym.INT, new Integer(2));
            case '&': advance(); return new Symbol(sym.AND);
            case '+': advance(); return new Symbol(sym.OR);
	    case '!': advance(); return new Symbol(sym.NOT);
            case 's': advance(); return new Symbol(sym.ID,"s");
            case 'e': advance(); return new Symbol(sym.ID,"e");
	    case 'w': advance(); advance(); advance(); advance();
                      advance();return new Symbol(sym.PRINT);
	    case 'W': advance(); return new Symbol(sym.ID, "W");
	    case 'P': advance(); return new Symbol(sym.ID,"P");
	    case 'V': advance(); return new Symbol(sym.ID,"V");
	    //case '$': advance(); return new Symbol(sym.ID, "$");
            case '=': advance(); return new Symbol(sym.ASSIGNS);
            case ';': advance(); return new Symbol(sym.SEMI);
            case '(': advance(); return new Symbol(sym.LPAREN);
            case ')': advance(); return new Symbol(sym.RPAREN);
	    case -1: return new Symbol(sym.EOF);
 
            default:
              /* in this simple scanner we just ignore everything else */
              advance();
            break;
          }
    }
};

