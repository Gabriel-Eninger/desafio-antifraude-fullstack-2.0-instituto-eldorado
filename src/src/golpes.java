import java.util.Scanner;

    public class golpes {

        static String[] palavrasSuspeitas = {
                "urgente","clique aqui","você ganhou","senha","confirme seus dados","conta bloqueada",
                "prêmio","última chance","link","gratis","Urgente","Última chance","ação imediata necessária",
                "sua conta será bloqueada","prazo expira hoje","não perca tempo","departamento de segurança",
                "central de atendimento oficial","órgão do governo","receita federal","seu banco informa",
                "suporte técnico","você ganhou","prêmio exclusivo","restituição disponível","cashback",
                "investimento garantido","lucro fácil ","rapido","renda extra","confirme seus dados","atualize seu cadastro",
                "verifique sua identidade","digite sua senha/código","clique no link para validar",
                "ajuda urgente","preciso de dinheiro agora","não conte pra ninguém","emergência médica",
                "clique aqui","acesse o link","baixe o aplicativo","regularize sua situação"
        };
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a mensagem:");
            String mensagem = scanner.nextLine().toLowerCase();
            int pontos = 0;
            for (String palavra : palavrasSuspeitas) {
                if (mensagem.contains(palavra)) {
                    pontos++;
                    System.out.println("Encontrado termo suspeito: " + palavra);
                }
            }
            String grau;
            if (pontos == 0) {
                grau = "Sem suspeita";
            } else if (pontos <= 2) {
                grau = "Suspeita baixa";
            } else if (pontos <= 4) {
                grau = "Suspeita média (tome cuidado)";
            } else {
                grau = "Suspeita alta (provavel golpe)";
            }
            System.out.println("Pontos: " + pontos);
            System.out.println("Grau de suspeita: " + grau);
            scanner.close();
        }
    }


