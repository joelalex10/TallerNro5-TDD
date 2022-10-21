package edu.ucb.prueba;

public class Ascensor {


    private Character[] ubicacionAscensor = {'1','0','0'};

    private final int limInf = 1;
    private final int limSup = 3;
    private final int numeroPisos = ubicacionAscensor.length;

    private Character[] ubicacionPersona = {'0','0','0'};

    private boolean isSubida =true;

    public int crearPersona() {

        int rand = (int)(Math.random()* limSup + limInf);
        System.out.println("EL NUMERO ES: "+rand);
        return rand;
    }

    public String seleccionarPiso(int piso){
        int posPersona=0;
        int pisoActual = 0;
        int pisoPersona=crearPersona();
        while(piso == pisoPersona){
            pisoPersona=crearPersona();
        }
        System.out.println(pisoPersona);
        ubicacionPersona[pisoPersona-1]='1';

        if (piso < limInf || piso > limSup){
            throw new RuntimeException("Fuera de los limites");
        }


        for (int index = 0; index< numeroPisos; index++){
            if(ubicacionPersona[index]=='1'){
                posPersona = index+1;
            }
        }

        while (ubicacionAscensor[posPersona-1] != '1'){
            pisoActual=moverAscensor();
            System.out.println("piso "+pisoActual);
        }

        while (ubicacionAscensor[piso-1] != '1'){
            pisoActual=moverAscensor();
            System.out.println("piso "+pisoActual);
        }


        return "Piso "+pisoActual;
    }


    public int moverAscensor(){
        int pos =0;
        for(int index = 0; index< numeroPisos; index++){
            if(ubicacionAscensor[index]== '1'){
                pos = index;
                ubicacionAscensor[index] = '0';
            }
        }

        if(pos==(numeroPisos -1)){
            isSubida =false;
        }
        if(pos==0){
            isSubida =true;
        }

        if(isSubida){
            pos++;
        }else{
            pos--;
        }

        ubicacionAscensor[pos] = '1';
        return (pos+1);
    }
}
