package trabalho_4_lpp;

public class ContactDetails implements Comparable<ContactDetails>{
    
    String nome, email;
    int nmr_tel;

    public ContactDetails(String nome, String email, int nmr_tel) {
        this.nome = nome;
        this.email = email;
        this.nmr_tel = nmr_tel;
    }
    
    public ContactDetails() {
        nome = "";
        email = "";
        nmr_tel = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNmr_tel() {
        return nmr_tel;
    }

    public void setNmr_tel(int nmr_tel) {
        this.nmr_tel = nmr_tel;
    }

    public void print(){
        System.out.println("\nContacto" + "\nNome- " + nome + "\nEmail- " + email + "\nNª Telemóvel- " + nmr_tel);
    }

    @Override
    public int compareTo(ContactDetails c) {
        return this.nome.compareTo(c.getNome());
    }
}
