class ListaDuplamenteEncadeada {
    class No {
        int valor;
        No anterior, proximo;

        No(int valor) {
            this.valor = valor;
        }
    }

    private No sentinela;

    public ListaDuplamenteEncadeada() {
        sentinela = new No(0);
        sentinela.proximo = sentinela;
        sentinela.anterior = sentinela;
    }

    public void inserirOrdenado(int valor) {
        No novo = new No(valor);
        No atual = sentinela.proximo;

        while (atual != sentinela && atual.valor < valor) {
            atual = atual.proximo;
        }

        novo.proximo = atual;
        novo.anterior = atual.anterior;
        atual.anterior.proximo = novo;
        atual.anterior = novo;
    }

    public void imprimirCrescente() {
        No atual = sentinela.proximo;
        while (atual != sentinela) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void imprimirDecrescente() {
        No atual = sentinela.anterior;
        while (atual != sentinela) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }

    public void removerPrimos() {
        No atual = sentinela.proximo;
        while (atual != sentinela) {
            if (ePrimo(atual.valor)) {
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
            }
            atual = atual.proximo;
        }
    }

    private boolean ePrimo(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}