import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Classe que permite fazer leitura de dados do tecladeo */

public class Teclado_AVL{
	
     private String s;
     private InputStreamReader i = new InputStreamReader (System.in);
     private BufferedReader d = new BufferedReader(i);

     /**
        L� um inteiro.
        @return int
     */
     public int leInt ()
     {   int a = 0;
         try
         {
             s = d.readLine();
             a = Integer.parseInt(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser inteiro: "+e );
         }
         return (a);
     }

     /**
        L� um inteiro, com mensagem.
        @return int
     */
     public int leInt (String msg)
     {   int a = 0;
         System.out.println(msg);
         try
         {
             s = d.readLine();
             a = Integer.parseInt(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: "+e );
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser inteiro: "+e );
         }
         return (a);
     }

     /**
        L� um double.
        @return double
     */
     public double leDouble()
     {   double a = 0;
         try
         {
             s = d.readLine();
             a = Double.parseDouble(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser n�mero: "+e );
         }
         return (a);
     }

     /**
        L� um double, com mensagem.
        @return double
     */
     public double leDouble(String msg)
     {   double a = 0;
         System.out.println(msg);
         try
         {
             s = d.readLine();
             a = Double.parseDouble(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser numero: "+e );
         }
         return (a);
     }

     /**
        L� um string.
        @return String
     */
     public String leString()
     {   s = "";
         try
         {
            s = d.readLine();
         }
         catch (IOException e)
         {
            System.out.println ("Erro de I/O: " + e);
         }
         return (s);
     }

     /**
        L� um string. com mensagem.
        @return String
     */
     public String leString(String msg)
     {   s = "";
         System.out.println(msg);
         try
         {
            s = d.readLine();
         }
         catch (IOException e)
         {
            System.out.println ("Erro de I/O: " + e);
         }
         return (s);
     }
     
     public char leChar()
     {   char a = ' ';
         try
         {
             s = d.readLine();
             a = s.charAt(0);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser char: "+e );
         }
         return (a);
     }

     /**
        L� um char, com mensagem.
        @return char
     */
     public char leChar(String msg)
     {   char a = ' ';
         System.out.println(msg);
         try
         {
             s = d.readLine();
             a = s.charAt(0);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser um char: "+e );
         }
         return (a);
     }
}
