package avaliativo2.model;

public class Papel extends Coisa {
    private String tipo = "Papel";

    @Override
    public int verify(Coisa outroTipo){

        if(outroTipo instanceof Pedra){
            return 1;
        }

        else if(outroTipo instanceof Tesoura){
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