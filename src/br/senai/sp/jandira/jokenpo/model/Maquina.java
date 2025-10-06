package br.senai.sp.jandira.jokenpo.model;

import java.util.Scanner;
import java.util.Random;

public class Maquina {

    int pedra = 1;                      // optei por setar números nas vaiáveis para a máquina conseguir escolher
    int papel = 2;
    int tesoura = 3;
    int escolhaDoJogador;
    int escolhaDoComputador;
    String resultado;                   /*a variável conterá a mensagem de algum dos if else programada para aparecer
                                          localizada na função processamentoDoJogo*/


    public void obterDados() {                                      //essa é a função que pedirá a escolha do jogador
        Scanner leitor = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("*** Vamos jogar Jokenpô! ***");
        System.out.println("------------------------------------");
        System.out.println(" ");
        System.out.println("Escolha uma opção:");
        System.out.println("(1) Pedra");
        System.out.println("(2) Papel");
        System.out.println("(3) Tesoura");
        System.out.println("------------------------------------");
        System.out.print("Digite a sua escolha: ");
        escolhaDoJogador = leitor.nextInt();

        funcaoDoJogo();                               /*aqui eu decidi fazer com que só uma função chamasse todas as outras
                                                        para poupar a procura visual*/
        processamentoDoJogo();
        exibirResultados();
        jogarNovamente();

    }

    public void funcaoDoJogo() {                            /*parte lógica do programa que fará o computador escolher
                                                             e dar continuidade ao programa*/
        Random random = new Random();
        escolhaDoComputador = random.nextInt(3)+1;
    }

    public void processamentoDoJogo() {                     /*o if else utilizado para conter a informação da variável
                                                               resultado e exibir na função exibirResultados*/

        if (escolhaDoJogador == escolhaDoComputador){
            resultado = "E M P A T E ! ! !";
        } else if (escolhaDoJogador == 1 && escolhaDoComputador == 3) {
            resultado = "V O C Ê  V E N C E U ! ! !";
        } else if (escolhaDoJogador == 2 && escolhaDoComputador == 1) {
            resultado = "V O C Ê  V E N C E U ! ! !";
        } else if (escolhaDoJogador == 3 && escolhaDoComputador == 2) {
            resultado = "V O C Ê  V E N C E U ! ! !";
        } else {
            resultado = "C O M P U T A D O R  V E N C E U ! ! !";
        }
    }

    public void exibirResultados() {                    //parte que aparecerá quem ganhou ou se empatou

        System.out.println(" ");
        System.out.println("Você escolheu: " + escolhaDoJogador);
        System.out.println("O computador escolheu: " + escolhaDoComputador);
        System.out.println(" ");
        System.out.println("* * * " + resultado + " * * *");
    }

    public void jogarNovamente() {                               /*fiz uma nova função para jogar novamente ao invés de
                                                                   colocar o if else na função exibirResultados*/

        Scanner leitor = new Scanner(System.in);                //optei por declarar scanner localmente ao invés de global
        String tentarDeNovo;

        System.out.print("Jogar novamente (S/N)?: ");
        tentarDeNovo = leitor.next();

        if (tentarDeNovo.equalsIgnoreCase("S")) {  /*.equalsIgnoreCase utilizo para string
                                                              caso seja maiúscula ou minúscula para ignorar*/
            obterDados();
        } else {
            System.out.println(" ");
            System.out.println("Bye!");
        }
    }

}
