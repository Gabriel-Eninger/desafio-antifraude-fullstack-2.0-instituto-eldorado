import java.text.Normalizer;
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    static Scanner scanner= new Scanner(System.in);
    // VARIAVEIS
    public static boolean remetente;
    public static int score = 0;
    public static String mensagem;
    // FUNCOES

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static void  inputMensagem(){
        System.out.println("Digite sua mensagem:");
        mensagem = scanner.nextLine();
        mensagem = mensagem.toLowerCase().replaceAll("[!.,?;-]", "");
        mensagem = removerAcentos(mensagem);
    }
    public static void regra_urgencia(String mensagem) {
        String[] flags = {"urgente", "urgencia", "emergencia", "urgentemente"};
        if (Arrays.stream(flags).anyMatch(mensagem::contains)) {
            score += 1;
        }
        System.out.println("Você conhece o remetente desta mensagem? (responda com sim ou nao)");
        String resposta = scanner.nextLine().trim().toLowerCase();
        boolean remetente = resposta.equals("sim");
        if (!remetente) {score += 1;}
    }
    // SAIDA
    public static void main(String[] args){
        System.out.println("Bem vindo ao autenticador de segurança");
        inputMensagem();
        regra_urgencia(mensagem);
        System.out.println(score);

    }
}