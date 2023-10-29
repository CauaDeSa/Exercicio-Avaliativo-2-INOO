package avaliativo2.model;
import java.util.*;

public class Jogador{
    private String nome;

    public Jogador(){
        this.nome = "Computador";
    }

    public Jogador(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public Coisa humanoJogada(){
        Scanner scan = new Scanner(System.in);
        Coisa elemento;
        int choice;

            System.out.println("\n" + nome + " selecione seu elemento: ");
            System.out.println("(1 - Pedra) - (2 - Papel) - (3 - Tesoura)");

            choice = scan.nextInt();

            while(choice < 0 || choice > 3)
                choice = scan.nextInt();
    
            if(choice == 1){
                elemento = new Pedra();
            }
    
            else if(choice == 2){
                elemento = new Papel();
            }
    
            else{
                elemento = new Tesoura();
            }

        return elemento;
    }

    public Coisa computadorJogada(){
        Random rng = new Random();
        Coisa elemento;
        int choice;

        choice = rng.nextInt(3);

        if(choice == 1){
            elemento = new Pedra();
        }

        else if(choice == 2){
            elemento = new Papel();
        }

        else{
            elemento = new Tesoura();
        }

        return elemento;
    }
}