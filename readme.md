# EXERCÍCIO 1 — Estrutura de nomes (vetor + lista duplamente encadeada)

1. O vetor `No[] vetor = new No[26]` representa as letras A-Z.
   - Cada posição aponta para o início de uma lista ligada.

2. A função `indice(nome)`:
   - Pega a primeira letra do nome.
   - Converte para maiúscula.
   - Subtrai 'A' → gera índice de 0 a 25.

3. Ao adicionar:
   - Calcula o índice correto (letra inicial).
   - Se a lista estiver vazia → insere direto.
   - Caso contrário → percorre a lista.

4. Inserção ordenada:
   - Compara nomes usando `compareTo`.
   - Decide se insere antes ou depois do nó atual.
   - Ajusta ponteiros `ant` e `prox`.

5. Pesquisa:
   - Vai direto na lista correta pelo índice.
   - Percorre até encontrar ou acabar.

6. Remoção:
   - Procura o nó.
   - Ajusta os ponteiros vizinhos.
   - Mantém a lista consistente (sem quebrar encadeamento).
