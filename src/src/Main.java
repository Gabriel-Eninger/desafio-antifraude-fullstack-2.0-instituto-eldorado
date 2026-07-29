import java.text.Normalizer;
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static int score = 0;
    public static void  inputMensagem(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Digite sua mensagem:");
        String mensagem = scanner.nextLine();
        mensagem = mensagem.toLowerCase();
        mensagem = mensagem.replaceAll("[!.,?;-]", "");
        mensagem = removerAcentos(mensagem);
    }
    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
    public static void regra_urgencia(String mensagem) {
        String[] flags = {"urgente", "urgencia", "emergencia", "urgentemente"};
        if (Arrays.stream(flags).anyMatch(mensagem::contains)) {
            score += 1;
        }
    }
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println(score);



    }
}