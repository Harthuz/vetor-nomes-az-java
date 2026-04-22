# 📚 Estrutura de Dados — Lista de Nomes (Vetor + Lista Duplamente Encadeada)

## 🔹 Visão Geral

Esta estrutura organiza nomes de forma eficiente combinando:

- **Vetor de 26 posições** → separa os nomes pela letra inicial (A-Z)
- **Lista duplamente encadeada** → mantém os nomes **ordenados alfabeticamente**

✔ Resultado:
- Inserção automática em ordem
- Busca mais rápida (não percorre tudo)
- Estrutura dinâmica (sem tamanho fixo por letra)

---

## 🔹 Estrutura Interna

### 📌 Classe `No`

Representa um elemento da lista:

```java
class No {
    String nome;
    No ant, prox;
}
````

* `nome` → valor armazenado
* `ant` → aponta para o anterior
* `prox` → aponta para o próximo

✔ Permite navegação bidirecional

---

### 📌 Vetor principal

```java
No[] listaPorLetra = new No[26];
```

Cada posição representa uma letra:

| Índice | Letra |
| ------ | ----- |
| 0      | A     |
| 1      | B     |
| ...    | ...   |
| 25     | Z     |

✔ Cada posição aponta para o início de uma lista

---

## 🔹 Funcionamento dos Métodos

---

### 🔸 `indice(String nome)`

```java
return Character.toUpperCase(nome.charAt(0)) - 'A';
```

Transforma a primeira letra em índice:

* 'A' → 0
* 'B' → 1
* 'Z' → 25

✔ Define onde o nome será armazenado

---

### 🔸 `adicionar(String nome)`

Responsável por inserir mantendo ordem alfabética.

#### Fluxo:

1. Descobre índice da letra
2. Verifica se lista está vazia
3. Percorre até achar posição correta
4. Insere ajustando ponteiros

#### Regras:

* Se menor que o primeiro → vira cabeça
* Se maior → entra no meio ou final

✔ A lista sempre fica ordenada automaticamente

---

### 🔸 `pesquisar(String nome)`

#### Fluxo:

1. Acessa lista correta
2. Percorre elemento por elemento
3. Compara nomes

✔ Retorna:

* `true` → encontrado
* `false` → não encontrado

---

### 🔸 `excluir(String nome)`

Remove um nome sem quebrar a lista.

#### Casos:

* **Meio da lista**

  ```java
  atual.ant.prox = atual.prox;
  ```

* **Primeiro elemento**

  ```java
  listaPorLetra[i] = atual.prox;
  ```

* **Ajuste do próximo**

  ```java
  atual.prox.ant = atual.ant;
  ```

✔ Mantém integridade da estrutura

---

### 🔸 `renomear(String antigo, String novo)`

```java
excluir(antigo);
adicionar(novo);
```

✔ Remove e reinsere corretamente

✔ Garante:

* Ordem alfabética
* Mudança de letra se necessário

---

### 🔸 `estaVazia()`

```java
return total == 0;
```

✔ Estrutura vazia quando não há nomes

---

### 🔸 `quantidade()`

✔ Retorna total de nomes armazenados

---

### 🔸 `exibirTudo()`

Percorre todo o vetor e imprime apenas listas com dados.

#### Exemplo de saída:

```
A -> Aline <-> Amanda <-> Ana
B -> Beatriz <-> Bia
C -> Carlos <-> Cesar
Z -> Zuleica
```

✔ Mostra organização por letra + ordem

---

## 🔹 Complexidade

| Operação | Complexidade     |
| -------- | ---------------- |
| Inserção | O(n) (por lista) |
| Busca    | O(n) (por lista) |
| Remoção  | O(n)             |
| Índice   | O(1)             |

✔ Melhor que lista única global

---

## 🔹 Vantagens

* Organização automática
* Redução do espaço de busca
* Estrutura flexível
* Inserção ordenada sem reprocessamento

---

## 🔹 Limitações

* Não trata nomes inválidos (ex: "123")
* Pode ter listas muito grandes em letras comuns (ex: "A")

---

## 🔹 Resumo Final

✔ Vetor → decide **onde**
✔ Lista → mantém **ordem**
✔ Nó → conecta elementos

Essa combinação é uma forma simples de **hash + lista encadeada ordenada**
