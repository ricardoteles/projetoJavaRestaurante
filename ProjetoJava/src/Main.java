import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao, opcaoBatata, opcaoBebida, qtde;
        double valorTotal = 0.0;

        // inicializando a lista de bebidas e batatas
        ArrayList<Batata> listaBatatas = new ArrayList<Batata>(){
            {
                add(new Batata("Batata rustica", 1.00, 0, "Jr"));
                add(new Batata("Batata rustica", 2.00, 0, "Pleno"));
                add(new Batata("Batata rustica", 3.00, 0, "Senior"));
                add(new Batata("Batata com cheddar", 4.00, 0, "Jr"));
                add(new Batata("Batata com cheddar", 5.00, 0, "Pleno"));
                add(new Batata("Batata com cheddar", 6.00, 0, "Senior"));
                add(new Batata("Batata tradicional", 7.00, 0, "Jr"));
                add(new Batata("Batata tradicional", 8.00, 0, "Pleno"));
                add(new Batata("Batata tradicional", 9.00, 0, "Senior"));
            }
        };
        ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>(){
            {
                add(new Bebida("Coca-cola", 1.00, 0, false));
                add(new Bebida("Sprite", 4.00, 0, false));
                add(new Bebida("Fanta", 7.00, 0, false));
                add(new Bebida("Heineken", 10.00, 0, true));
                add(new Bebida("Bavaria", 8.00, 0, true));
            }
        };

        System.out.println("Bem-vindo ao Sr. Batata!");

        // imprime o menu principal
         do {
            System.out.println("\n=========== Menu =============");
            System.out.println("1) Bebidas");
            System.out.println("2) Batatas");
            System.out.println("3) Finalizar Pedido");
            System.out.println("==============================");

            System.out.print("O que voce deseja? ");
            opcao = teclado.nextInt();
            System.out.print("\n");

            if (opcao == 1) {

                // mostra o menu das bebidas
                for(int i = 0; i < listaBebidas.size(); i++){
                    Bebida item = listaBebidas.get(i);

                    System.out.println((i+1)+ ") " + item.getNome() + " (R$ "+ item.getValor() + ")");
                }

                System.out.print("\nEscolha o seu item: ");
                opcaoBebida = teclado.nextInt();

                if(opcaoBebida > 0 && opcaoBebida <= listaBebidas.size()) {
                    System.out.print("Qual a quantidade? ");
                    qtde = teclado.nextInt();

                    listaBebidas.get(opcaoBebida - 1).setQtde(qtde);  // adiciona a qtde da bebida selecionada
                } else {
                    System.out.println("Bebida nao encontrada!");
                }
            }
            else if (opcao == 2) {

                // mostra o menu das batatas
                for(int i = 0; i < listaBatatas.size(); i++){
                    Batata item = listaBatatas.get(i);

                    System.out.println((i+1)+ ") " + item.getNome() +" "+ item.getTamanho() + " (R$ "+ item.getValor() + ")");
                }

                System.out.print("\nEscolha o seu item: ");
                opcaoBatata = teclado.nextInt();

                if(opcaoBatata > 0 && opcaoBatata <= listaBatatas.size()) {
                    System.out.print("Qual a quantidade? ");
                    qtde = teclado.nextInt();

                    listaBatatas.get(opcaoBatata - 1).setQtde(qtde); // adiciona a qtde da batata selecionada
                } else {
                    System.out.println("Batata nao encontrada!");
                }
            }
            else if(opcao == 3) {
                System.out.println("************* RECIBO *************");
            }
            else {
                System.out.println("Opcao invalida!");
            }
        } while(opcao != 3);


        // percorre a lista e soma o valor de cada bebida no valor total
        for(int i = 0; i < listaBebidas.size(); i++){
            Bebida item = listaBebidas.get(i);
            valorTotal += (item.getQtde() * item.getValor());

            if(item.getQtde() != 0) {
                System.out.println(item.getQtde() +"   "+item.getNome() +"    R$ "+ (item.getValor()*item.getQtde()));
            }
        }

        // percorre a lista e soma o valor de cada batata no valor total
        for(int i = 0; i < listaBatatas.size(); i++){
            Batata item = listaBatatas.get(i);

            valorTotal += (item.getQtde() * item.getValor());

            if(item.getQtde() != 0) {
                System.out.println(item.getQtde() +"   "+item.getNome() +"    R$ "+ (item.getValor()*item.getQtde()));
            }
        }

        System.out.println("----------------------------------");
        System.out.println("Valor total a pagar: R$ "+valorTotal);
        System.out.println("**********************************");
    }
}