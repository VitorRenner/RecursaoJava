public class Arvore {
    No raiz;

    public Arvore() {
        this.raiz = null;
    }

    // INSERIR
    public void inserir(Integer valor) {
        if (valor == null) return;
        this.raiz = inserir(this.raiz, valor);
    }

    private No inserir(No atual, Integer valor) {
        // achou o lugar vazio, cria o no aqui
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserir(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserir(atual.direita, valor);
        }
        // se for igual nao faz nada (nao aceita repetido)

        return atual;
    }

    // BUSCAR
    public boolean buscar(Integer valor) {
        if (valor == null) return false;
        return buscar(this.raiz, valor);
    }

    private boolean buscar(No atual, Integer valor) {
        if (atual == null) {
            return false;
        }
        if (valor.equals(atual.valor)) {
            return true;
        }
        if (valor < atual.valor) {
            return buscar(atual.esquerda, valor);
        } else {
            return buscar(atual.direita, valor);
        }
    }

    // REMOVER
    public void remover(Integer valor) {
        if (valor == null) return;
        this.raiz = remover(this.raiz, valor);
    }

    private No remover(No atual, Integer valor) {
        if (atual == null) {
            return null; // valor nao esta na arvore
        }

        if (valor < atual.valor) {
            atual.esquerda = remover(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = remover(atual.direita, valor);
        } else {
            // achou o no que vai ser removido

            // caso 1: no folha
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // caso 2: no com um filho so
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }

            // caso 3: no com dois filhos
            // pega o sucessor (menor valor da subarvore da direita)
            Integer sucessor = menorValor(atual.direita);
            atual.valor = sucessor;
            atual.direita = remover(atual.direita, sucessor);
        }

        return atual;
    }

    private Integer menorValor(No atual) {
        if (atual.esquerda == null) {
            return atual.valor;
        }
        return menorValor(atual.esquerda);
    }

    // EM ORDEM
    public void emOrdem() {
        emOrdem(this.raiz);
        System.out.println();
    }

    private void emOrdem(No atual) {
        if (atual == null) return;

        emOrdem(atual.esquerda);
        System.out.print(atual.valor + " ");
        emOrdem(atual.direita);
    }
}
