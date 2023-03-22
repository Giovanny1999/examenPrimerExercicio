//Aplicacion que elige una contraseña de acuerdo a su numero de caracteres y su numero de letras pares
//Autor: Giovanny Angel Hernandez Aleman
//Fecha 22/03/2023
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String entrada2 = entrada.nextLine();
        StringTokenizer palabras = new StringTokenizer(entrada2, " ");
        int nDatos = palabras.countTokens();
        String palabrasArray[] = new String[nDatos];
        int count = 0;
        int resta = 0;
        boolean isBig = false;
        int palabraGrande = 0;
        int contadorletra = 0;
        int espacios = 0;
        int contraseñaIdeal = 0;
        while(palabras.hasMoreTokens()) {
            String str = palabras.nextToken();
            palabrasArray[count] = str;
            if(Pattern.matches("[a-zA-Z]*", palabrasArray[count].toString())){
               resta ++;
            }else {
                for(int i = 0; i<nDatos; i++){
                    if(str.length()>palabraGrande){
                        isBig = true;
                    }
                }
                for(int i = 0; i< entrada2.length(); i++){
                    if(entrada2.charAt(i) == ' '){
                        espacios++;
                    }
                }
                if(palabrasArray[count].length() % 2 != 0 && isBig ){
                    char [] letra = palabrasArray[count].toCharArray();
                    for (int i = 0; i< letra.length; i++){
                        if(Character.isLetter(letra[i])){
                            ++contadorletra;
                        }
                    }
                    if(contadorletra % 2 == 0){
                        contraseñaIdeal++;
                        System.out.println("Espacios: " + espacios + " Contraseña: " + contraseñaIdeal);
                    }
                }else {
                    contraseñaIdeal = -1;

                }
            }
            count++;
        }
    }
}