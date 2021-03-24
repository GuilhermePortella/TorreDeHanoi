package projetotorrehanoi;
/**
 *
 * @author Guilherme
 */
import java.util.Scanner;

public class Main {
        
    public static int[][] Hanoir;
    public static int colunas = 3;
    public static int discos = 0;
    public static int movimentos = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //solicita o numero de discos
        do{
            System.out.println("Digite a quantidade de discos: ");
            if(scanner.hasNextInt()){
                discos = scanner.nextInt();
            }else{
                scanner.next();                
            }
        } while(discos == 0);
            
            
        Hanoir = new int[discos][colunas];
        for (int disc = 0; disc < discos; disc++) {
        Hanoir[disc][0] = (disc * 2) + 1;}
        imprimirTorres();			
        resolverTorres(discos, 0, 2);
        scanner.close();
        System.out.println("Numero de movimentos necessário: " + movimentos);
        }
        
        
        
	public static void resolverTorres(int numDiscs, int colunaInicial, int ultimaColuna) {
            if (numDiscs == 0) {
            } else {
                int colunaAuxiliar = colunas - colunaInicial - ultimaColuna;

                resolverTorres(numDiscs - 1, colunaInicial, colunaAuxiliar);
                moveDisc(colunaInicial, ultimaColuna);
                resolverTorres(numDiscs - 1, colunaAuxiliar,  ultimaColuna);}		
	}
        
        
	public static void moveDisc(int fromPole, int toPole) {
		movimentos++;
		int disc = 0;
		while (disc < discos && Hanoir[disc][fromPole] == 0) {
                    disc++;}
		int temp = Hanoir[disc][fromPole];
		Hanoir[disc][fromPole] = 0;
		int newDisc = 0;
		while (newDisc < discos && Hanoir[newDisc][toPole] == 0) {
                    newDisc++;}
		Hanoir[--newDisc][toPole] = temp;
		imprimirTorres();}
        
        //imprime a torre mostrando os movimentos
	public static void imprimirTorres() {
            System.out.println();
            for (int discoS = 0; discoS < discos; discoS++) {
                for (int colunaCont = 0; colunaCont < colunas; colunaCont++) {
                    System.out.print(pad(Hanoir[discoS][colunaCont]));}
                System.out.println();		
            }
            
            
            System.out.println();}
	public static String pad(int discO) {
            int columnWidth = (discos * 2) + 2;
            String output = "";
            if (discO == 0) {
                output = "|";
            } else for (int i = 0; i < discO; i++) {
                output += "-";		}
            if (output.length() % 2 == 1) {
                output += " ";		}
            while (output.length() < columnWidth) {
                output = " " + output + " ";
            }
            return output;}
}