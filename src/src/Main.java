import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static int score = 0;
    public static String regra_urgencia(String mensagem) {

        return mensagem;
    }
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Digite sua mensagem:");
        String mensagem = scanner.nextLine();
        String lowerCase = mensagem.toLowerCase();
        System.out.println(lowerCase);
    }
}