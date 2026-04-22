// EXERCÍCIO 1

class No {
    String nome;
    No ant, prox;

    No(String nome) {
        this.nome = nome;
    }
}

class EstruturaNomes {
    No[] vetor = new No[26]; // índice A-Z

    int indice(String nome) {
        return Character.toUpperCase(nome.charAt(0)) - 'A'; // calcula posição
    }

    void adicionar(String nome) {
        int i = indice(nome);
        No novo = new No(nome);

        if (vetor[i] == null) { // lista vazia
            vetor[i] = novo;
            return;
        }

        No atual = vetor[i];

        // inserção ordenada
        while (atual != null && atual.nome.compareTo(nome) < 0) {
            if (atual.prox == null) break;
            atual = atual.prox;
        }

        if (atual.nome.compareTo(nome) > 0) { // inserir antes
            novo.prox = atual;
            novo.ant = atual.ant;

            if (atual.ant != null) atual.ant.prox = novo;
            else vetor[i] = novo;

            atual.ant = novo;
        } else { // inserir depois
            novo.prox = atual.prox;
            novo.ant = atual;

            if (atual.prox != null) atual.prox.ant = novo;
            atual.prox = novo;
        }
    }

    boolean pesquisar(String nome) {
        int i = indice(nome);
        No atual = vetor[i];

        while (atual != null) {
            if (atual.nome.equals(nome)) return true;
            atual = atual.prox;
        }
        return false;
    }

    void remover(String nome) {
        int i = indice(nome);
        No atual = vetor[i];

        while (atual != null) {
            if (atual.nome.equals(nome)) {
                if (atual.ant != null) atual.ant.prox = atual.prox;
                else vetor[i] = atual.prox;

                if (atual.prox != null) atual.prox.ant = atual.ant;
                return;
            }
            atual = atual.prox;
        }
    }
}
