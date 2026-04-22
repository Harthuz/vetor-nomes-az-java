// MAIN - EXERCÍCIO 1

public class main {
    public static void main(String[] args) {
        EstruturaNomes estrutura = new EstruturaNomes();

        // adicionando nomes
        estrutura.adicionar("ana");
        estrutura.adicionar("Carlos");
        estrutura.adicionar("Amanda");
        estrutura.adicionar("Beatriz");
        estrutura.adicionar("Aline");

        // pesquisa
        System.out.println("Existe Ana? " + estrutura.pesquisar("Ana"));
        System.out.println("Existe João? " + estrutura.pesquisar("João"));

        // remoção
        estrutura.remover("Amanda");
        System.out.println("Existe Amanda? " + estrutura.pesquisar("Amanda"));
    }
}
