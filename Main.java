public class Main {
    public static void main(String[] args) {

        EstruturaNomes estrutura = new EstruturaNomes();

        // inserções (fora de ordem)
        estrutura.adicionar("Ana");
        estrutura.adicionar("Carlos");
        estrutura.adicionar("Aline");
        estrutura.adicionar("Beatriz");
        estrutura.adicionar("Amanda");
        estrutura.adicionar("Bia");
        estrutura.adicionar("Cesar");
        estrutura.adicionar("Zuleica");

        System.out.println("Estrutura:");
        estrutura.exibirTudo();

        // quantidade e estado
        System.out.println("\nTotal: " + estrutura.quantidade());
        System.out.println("Está vazia? " + estrutura.estaVazia());

        // pesquisa
        System.out.println("\nPesquisar 'Amanda': " + estrutura.pesquisar("Amanda"));
        System.out.println("Pesquisar 'Pedro': " + estrutura.pesquisar("Pedro"));

        // remoção
        System.out.println("\nRemovendo 'Bia'...");
        estrutura.excluir("Bia");
        estrutura.exibirTudo();

        // renomear
        System.out.println("\nRenomeando 'Ana' para 'Bruno'...");
        estrutura.renomear("Ana", "Bruno");
        estrutura.exibirTudo();
    }
}
