package avaliativo2.model;

public class Tesoura extends Coisa {
    private String tipo = "Tesoura";

    @Override
    public int verify(Coisa outroTipo){

        if(outroTipo instanceof Papel){
            return 1;
        }

        else if(outroTipo instanceof Pedra){
            return -1;
        }

        else{
            return 0;
        }
    }
    
    @Override
    public String getTipo(){
        return tipo;
    }
}