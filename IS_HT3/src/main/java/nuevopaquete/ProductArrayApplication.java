package nuevopaquete;


import java.util.Arrays;
import java.util.OptionalLong;

public class ProductArrayApplication {

    public static void main(String[] args) {
        // TODO code application logic here
        long[] resultado= null;
        long[] entrada = null;
        //1
        entrada = new long[] {1, 2, 3, 4, 5 };
        resultado= calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //2
        entrada = new long[0];
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //3
        entrada = new long[]{1,0};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //4
        entrada = new long[]{1,5,3,0,2};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //5
        entrada = new long[]{3,0,2,1,0};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //6
        entrada = new long[]{0};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //7
        entrada = new long[]{1};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //8
        entrada = null;
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //9
        entrada =  new long[]{};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));      
        //10
        entrada =  new long[]{1,2,3};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        
        
    }
    
    public static long[] calculateProductArrayBasic(long[] input){
        
        long[] respu=null;
        
        if(input!=null){
        
        respu=Arrays.copyOf(input,input.length);
        Arrays.fill(respu, 0);
        OptionalLong resp= Arrays.stream(input).reduce((a,b)->a*  b );
        
        long[] auxiliar1 = null;
        auxiliar1 = Arrays.copyOf(input,input.length);
        Arrays.sort(auxiliar1);
        
        for(int i=0; i<input.length; i++){
        
            long dato = input[i];
            int posicion = Arrays.binarySearch(auxiliar1, dato);
        
            long auxiliar2=auxiliar1[posicion];
            auxiliar1[posicion]=1;
            OptionalLong operacion= Arrays.stream(auxiliar1).reduce((a,b)->a*  b );
        
            respu[i]=operacion.getAsLong();
            auxiliar1[posicion]=auxiliar2;
        }
        
        }
        
        return respu;
    }
    
}
