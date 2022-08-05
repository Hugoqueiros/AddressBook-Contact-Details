package trabalho_4_lpp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Trabalho_4_LPP {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        int escolha;
        String nome = null, email = null, mod;
        int nmr_tel = 0, nmr_tel2 = 0;
        boolean remove = false, pesquisa = false, modificado = true, guardar = true;
        //inicialização da coleção Hashset que guarda dados do tipo Mamífero
        AddressBook agenda = new AddressBook();

        do {
            int length = 0;
            System.out.println("\n|1 - Inserir Contacto");
            System.out.println("|2 - Pesquisar Contacto");
            System.out.println("|3 - Eliminar Contacto");
            System.out.println("|4 - Modificar Contacto");
            System.out.println("|5 - Visualizar Contactos Ordenados|");
            System.out.println("|6 - Sair|");
            System.out.printf("\nEscolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    boolean inputOK = false;
                    leitura.nextLine();
                    ContactDetails contacto = new ContactDetails();
                    System.out.printf("\nNome- ");
                    do {
                        try {
                            nome = leitura.nextLine();

                            if (nome.equals("")) {
                                throw new Excecao();
                            }
                            inputOK = true;
                        } catch (Excecao e) {
                            System.out.println(e.getMessage());
                            leitura.reset();
                        }
                    } while (!inputOK);
                    System.out.println(nome);
                    System.out.printf("\nNúmero Telemóvel- ");
                    inputOK = false;
                    do {
                        try {
                            nmr_tel = leitura.nextInt();
                            inputOK = true;

                        } catch (InputMismatchException e) {
                            System.out.printf("Error: " + e + "\nInsira dados válidos: ");
                            leitura.reset();
                            leitura.next();
                        }
                    } while (!inputOK);
                    inputOK = false;
                    nmr_tel2 = nmr_tel;
                    while (nmr_tel2 > 0) {
                        nmr_tel2 = nmr_tel2 / 10;
                        length++;
                    }
                    if (length < 9 || length > 9) {
                        System.out.println("Número Inválido");
                        guardar = false;
                        break;
                    }
                    System.out.printf("\nEmail- ");
                    email = leitura.nextLine();

                    if (guardar == true) {
                        contacto.setNome(nome);
                        contacto.setEmail(email);
                        contacto.setNmr_tel(nmr_tel);
                        agenda.adiciona(contacto);

                        System.out.println("Contacto Inserido com Sucesso!");
                    }
                    break;

                case 2:
                    leitura.nextLine();
                    System.out.println("Pesquisar pelo nome- ");
                    String pes_nome = leitura.nextLine().toLowerCase();
                    agenda.pesquisa(pes_nome, pesquisa);
                    break;

                case 3:
                    leitura.nextLine();
                    System.out.printf("\nPesquisar Nome que pretende Eliminar- ");
                    String eli = leitura.nextLine().toLowerCase();
                    agenda.elimina(agenda, eli, remove);
                    break;

                case 4:
                    leitura.nextLine();
                    System.out.printf("\nPesquisar Nome que pretende Modificar- ");
                    mod = leitura.nextLine().toLowerCase();
                    agenda.modificar(mod, modificado);
                    break;

                case 5:
                    agenda.ordena();
                    break;
            }

        } while (escolha != 9);
    }
}
