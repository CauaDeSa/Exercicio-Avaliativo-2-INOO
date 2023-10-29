package avaliativo2.model;

public class Pedra extends Coisa {
    private String tipo = "Pedra";
    
    @Override
    public int verify(Coisa outroTipo){

        if(outroTipo instanceof Tesoura){
            return 1;
        }

        else if(outroTipo instanceof Papel){
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