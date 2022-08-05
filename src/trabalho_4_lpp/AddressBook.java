package trabalho_4_lpp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddressBook {

    Scanner leitura = new Scanner(System.in);

    ArrayList<ContactDetails> agenda = new ArrayList<ContactDetails>();

    public void adiciona(ContactDetails contacto) {
        agenda.add(contacto);
    }

    public void elimina(AddressBook contacto, String eli, boolean remove) {
        String opcao;
        for (ContactDetails valor : agenda) {
            //Verificação se no HashSet existe algum Mamífero com o nome introduzido pelo utilizador
            if (eli.equals(valor.nome)) {
                //caso exista esse Animal será eliminado do HashSet
                valor.print();
                System.out.println("É este o contacto que pretende eliminar? (S/N)");
                opcao = leitura.nextLine().toLowerCase();
                if (opcao.equals("s")) {
                    agenda.remove(valor);
                    remove = true;
                    System.out.println("\nContacto eliminado");
                } else {
                    remove = true;
                    System.out.println("\nNenhum contacto foi eliminado");
                }
            }
        }
        if (remove == false) {
            //Caso não exista qualquer animal com o nome introduzido
            System.out.println("Não existem resultados com o nome '" + eli + "'");
        }
    }

    public void pesquisa(String pes_nome, boolean pesquisa) {
        for (ContactDetails valor : agenda) {
            /*Verificação de todos os Mamíferos presentes se algum tem presente 
                        como espécie o nome digitado*/
            if (valor.nome.contains(pes_nome)) {
                pesquisa = true;
                valor.print();
            }
        }
        //Caso não exista Mamíferos presentes com o nome da espécie digitado
        if (pesquisa == false) {
            System.out.println("Não existem resultados com o nome '" + pes_nome + "'");
        }
    }

    public void modificar(String mod, boolean modificado) {
        String opcao, mod_op;
        int mod_nmr;
        for (ContactDetails valor : agenda) {
            //Verificação se no HashSet existe algum Mamífero com o nome introduzido pelo utilizador
            if (mod.equals(valor.nome)) {
                //caso exista esse Animal será eliminado do HashSet
                valor.print();
                System.out.println("É este o contacto que pretende modificar? (S/N)");
                opcao = leitura.nextLine().toLowerCase();
                if (opcao.equals("s")) {
                    System.out.printf("Modificar- ");
                    mod = leitura.nextLine().toLowerCase();
                    if (mod.equals("nome")) {
                        System.out.printf("Modificar Nome-");
                        mod_op = leitura.nextLine();
                        valor.nome = mod_op;
                        System.out.println("Nome Modificado com Sucesso");
                        modificado = true;
                    } else if (mod.equals("numero")) {
                        System.out.printf("Modificar Número-");
                        mod_nmr = leitura.nextInt();
                        valor.nmr_tel = mod_nmr;
                        System.out.println("Número Modificado com Sucesso");
                        modificado = true;
                    } else if (mod.equals("email")) {
                        System.out.printf("Modificar Email-");
                        mod_op = leitura.nextLine();
                        valor.email = mod_op;
                        System.out.println("Email Modificado com Sucesso");
                        modificado = true;
                    } else {
                        System.out.println("\nNenhum contacto foi modificado");
                    }
                } else {
                    System.out.println("\nNenhum contacto foi modificado");
                }
            }
        }
        if (modificado = false) {
            System.out.println("Não existem resultados com o nome '" + mod + "'");
        }
    }

    public void ordena() {
        Collections.sort(agenda);
        for (ContactDetails valor : agenda) {
            valor.print();   
        }
    }
    
}
