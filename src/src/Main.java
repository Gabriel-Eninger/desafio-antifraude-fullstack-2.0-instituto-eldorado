import java.text.Normalizer;
import java.util.Scanner;
import java.util.Arrays;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main{
    static Scanner scanner= new Scanner(System.in);
    // VARIAVEIS
    public static int score = 0;
    public static String mensagem;

    // FUNCOES
    public static boolean isCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");
        // Verifica se tem 11 dígitos ou é uma sequência repetida inválida
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        try {
            char dig10, dig11;
            int sm, i, r, num, peso;
            // Calculo do 1º Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
            // Calculo do 2º Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }
            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (Exception erro) {
            return false;
        }
    }
    public static String classificacao(int score){
        if (score == 0){
            return ("Mensagem Legítima!");
        } else if (score == 1) {
            return("Mensagem Suspeita!");
        } else {
            return("Esta mensagem é um golpe!!");
        }
    }
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
        System.out.println(classificacao(score));
    }
}