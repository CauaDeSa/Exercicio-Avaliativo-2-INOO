import java.util.*;
import avaliativo2.model.*;

public class Main {

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        //Instancia os objetos jogador1 e jogador2
        Jogador jogador1;
        Jogador jogador2;

        //Variaveis que armazenam elementos do tipo Coisa
        Coisa escolha_jogador1;
        Coisa escolha_jogador2;
        
        //Marcador que definirá o vencedor
        int win[] = {0, 0};

        //Variaveis de controle do sistema
        int playersChoose;
        int gameMode;
        int command;
    
        do{
            //Define quem serão os jogadores em looping até que a escolha seja válida
            do{
                System.out.printf("\tJokenpo!\n\nQuem irá jogar? (1 - Jogador vs Jogador) ou (2 - Jogador vs Computador)\nEscolha: ");
                playersChoose = scan.nextInt();

            }while(playersChoose != 1 && playersChoose != 2);

            //Define qual será o modo de jogo em looping até que a escolha seja válida
            do{
                System.out.printf("\nSelecione o modo de jogo (1 - Confronto único) ou (2 - Melhor de três)\nEscolha: ");
                gameMode = scan.nextInt();

            }while(gameMode < 0 && gameMode > 2);   

            //Se o modo de jogo for melhor de três, atualiza a variavel gameMode para 3, que servirá para contar os loopings dos rounds
            if(gameMode == 2){
                gameMode = 3;
            }
            
            //Define o nome do jogador 1 e passa para o método construtor de "jogador1"
            System.out.printf("\nNome do Jogador 1: ");
            scan.nextLine();
            String nome = scan.nextLine();
            jogador1 = new Jogador(nome);

            //Se playerChoose == 1, então o segundo jogador será um humano também
            if(playersChoose == 1){

                //Define o nome do jogador 2 e passa para o método construtor de "jogador2"
                System.out.printf("Nome do Jogador 2: ");
                String nome2 = scan.nextLine();
                jogador2 = new Jogador(nome2);

                //Se gameMode == 1, então será apenas uma jogada, se gameMode > 1 então serão feitas 3 jogadas
                while(gameMode > 0){
                    
                    //Chama método da classe Jogador que pede para cada jogador sua jogada
                    escolha_jogador1 = jogador1.humanoJogada();
                    escolha_jogador2 = jogador2.humanoJogada();

                    //Mostra as jogadas de ambos os jogadores
                    System.out.println("\n" + jogador1.getNome() + " jogou: " + escolha_jogador1.getTipo() + "\n" + jogador2.getNome() + " jogou: " + escolha_jogador2.getTipo() + "\n");

                    //Recebe resultado do jogo
                    int result = escolha_jogador1.verify(escolha_jogador2);

                    //Define o vencedor de acordo com o resultado do jogo e armazen a vitoria
                    switch(result){
                        case 1:
                            System.out.println(jogador1.getNome() + " venceu!");
                            win[0]++;
                            gameMode--;
                            break;
                        
                        case 0:
                            System.out.println("Empate!");
                            break;

                        case -1:
                            System.out.println(jogador2.getNome() + " venceu!");
                            win[1]++;
                            gameMode--;
                            break;

                        default:
                            System.out.println("Erro!");
                            break;
                    }
                }
            }

            //Jogador2 == máquina
            else{

                jogador2 = new Jogador();

                while(gameMode > 0){
                    
                    //Metodo que pede a jogada do jogador especifico
                    escolha_jogador1 = jogador1.humanoJogada();

                    //Chama método randomico que definirá a jogada do computador
                    escolha_jogador2 = jogador2.computadorJogada();

                    //Mostra as jogadas de ambos os jogadores
                    System.out.println("\n" + jogador1.getNome() + " jogou: " + escolha_jogador1.getTipo() + "\n" + jogador2.getNome() + " jogou: " + escolha_jogador2.getTipo() + "\n");

                    //Recebe resultado do jogo
                    int result = escolha_jogador1.verify(escolha_jogador2);

                    //Define o vencedor de acordo com o resultado do jogo e armazen a vitoria
                    switch(result){
                        case 1:
                            System.out.println(jogador1.getNome() + " venceu!");
                            win[0]++;
                            gameMode--;
                            break;
                        
                        case 0:
                            System.out.println("Empate!");
                            break;

                        case -1:
                            System.out.println("Maquina venceu!");
                            win[1]++;
                            gameMode--;
                            break;

                        default:
                            System.out.println("Erro!");
                            break;
                    }
                }
            }

            if(win[0] > win[1]){
                System.out.println("\n" + jogador1.getNome() + " venceu a série!");
            }

            else if(win[0] == win[1]){
                System.out.println("\nHouve um empate na série!");
            }

            else{
                System.out.println("\n" + jogador2.getNome() + " venceu a série!");
            }

            System.out.println("\nDeseja jogar novamente? (0 - Não) - (1 - Sim) ");
            command = scan.nextInt();

            win[0] = win[1] = 0;
        }while(command == 1);

        scan.close();
    }
}