    class No {
        String nome;
        No ant, prox;

        No(String nome) {
            this.nome = nome;
        }
    }

    class EstruturaNomes {
        No[] listaPorLetra = new No[26]; // vetor A-Z
        int total = 0;

        int indice(String nome) {
            return Character.toUpperCase(nome.charAt(0)) - 'A'; // calcula índice
        }

        void adicionar(String nome) {
            int i = indice(nome);
            No novo = new No(nome);

            if (listaPorLetra[i] == null) {
                listaPorLetra[i] = novo;
                total++;
                return;
            }

            No atual = listaPorLetra[i];

            while (atual.prox != null && atual.prox.nome.compareToIgnoreCase(nome) < 0) {
                atual = atual.prox;
            }

            if (atual.nome.compareToIgnoreCase(nome) > 0) { // inserir antes
                novo.prox = atual;
                novo.ant = atual.ant;

                if (atual.ant != null) atual.ant.prox = novo;
                else listaPorLetra[i] = novo;

                atual.ant = novo;
            } else { // inserir depois
                novo.prox = atual.prox;
                novo.ant = atual;

                if (atual.prox != null) atual.prox.ant = novo;
                atual.prox = novo;
            }

            total++;
        }

        boolean pesquisar(String nome) {
            int i = indice(nome);
            No atual = listaPorLetra[i];

            while (atual != null) {
                if (atual.nome.equalsIgnoreCase(nome)) return true;
                atual = atual.prox;
            }
            return false;
        }

        boolean excluir(String nome) {
            int i = indice(nome);
            No atual = listaPorLetra[i];

            while (atual != null) {
                if (atual.nome.equalsIgnoreCase(nome)) {

                    if (atual.ant != null)
                        atual.ant.prox = atual.prox;
                    else
                        listaPorLetra[i] = atual.prox;

                    if (atual.prox != null)
                        atual.prox.ant = atual.ant;

                    total--;
                    return true;
                }
                atual = atual.prox;
            }
            return false;
        }

        boolean renomear(String antigo, String novo) {
            if (!pesquisar(antigo)) return false;

            excluir(antigo);
            adicionar(novo); // reinsere ordenado
            return true;
        }

        boolean estaVazia() {
            return total == 0; // controla estado geral
        }

        int quantidade() {
            return total;
        }

        void exibirTudo() {
            for (int i = 0; i < 26; i++) {
                if (listaPorLetra[i] != null) {
                    char letra = (char) ('A' + i); // índice → letra
                    System.out.print(letra + " -> ");

                    No atual = listaPorLetra[i];

                    while (atual != null) {
                        System.out.print(atual.nome);
                        if (atual.prox != null) System.out.print(" <-> ");
                        atual = atual.prox;
                    }

                    System.out.println();
                }
            }
        }
    }
