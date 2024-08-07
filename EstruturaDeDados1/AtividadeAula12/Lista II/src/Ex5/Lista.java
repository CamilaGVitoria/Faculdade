package Ex5;
class Lista {
    private No cabeca;
    private int tamanho;

    Lista() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return this.cabeca == null;
    }

    public int getSize() {
        return this.tamanho;
    }

    public void insert(int info) {
        this.cabeca = insertRec(this.cabeca, info);
        this.tamanho++;
    }

    private No insertRec(No no, int info) {
        if (no == null || info < no.info) {
            No novo = new No(info);
            novo.prox = no;
            return novo;
        } else {
            no.prox = insertRec(no.prox, info);
            return no;
        }
    }

    public void remove(int info) {
        this.cabeca = removeRec(this.cabeca, info);
    }

    private No removeRec(No no, int info) {
        if (no == null) {
            return null;
        }
        if (no.info == info) {
            this.tamanho--;
            return no.prox;
        }
        no.prox = removeRec(no.prox, info);
        return no;
    }

    public boolean busca(int info) {
        return buscaRec(this.cabeca, info);
    }

    private boolean buscaRec(No no, int info) {
        if (no == null) {
            return false;
        }
        if (no.info == info) {
            return true;
        }
        return buscaRec(no.prox, info);
    }

    public void elimina(int info) {
        while (busca(info)) {
            remove(info);
        }
    }

    public boolean iguais(Lista outra) {
        return iguaisRec(this.cabeca, outra.cabeca);
    }

    private boolean iguaisRec(No no1, No no2) {
        if (no1 == null && no2 == null) {
            return true;
        }
        if (no1 == null || no2 == null || no1.info != no2.info) {
            return false;
        }
        return iguaisRec(no1.prox, no2.prox);
    }

    public double media() {
        return mediaRec(this.cabeca, 0, 0);
    }

    private double mediaRec(No no, int soma, int count) {
        if (no == null) {
            return count == 0 ? 0 : (double) soma / count;
        }
        return mediaRec(no.prox, soma + no.info, count + 1);
    }

    public void eliminaPosicao(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        this.cabeca = eliminaPosicaoRec(this.cabeca, posicao, 0);
        this.tamanho--;
    }

    private No eliminaPosicaoRec(No no, int posicao, int current) {
        if (current == posicao) {
            return no.prox;
        }
        no.prox = eliminaPosicaoRec(no.prox, posicao, current + 1);
        return no;
    }

    public void insereDireita(int posicao, int info) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        this.cabeca = insereDireitaRec(this.cabeca, posicao, info, 0);
        this.tamanho++;
    }

    private No insereDireitaRec(No no, int posicao, int info, int current) {
        if (current == posicao) {
            No novo = new No(info);
            novo.prox = no.prox;
            no.prox = novo;
        } else {
            no.prox = insereDireitaRec(no.prox, posicao, info, current + 1);
        }
        return no;
    }

    public void insereEsquerda(int posicao, int info) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            No novo = new No(info);
            novo.prox = this.cabeca;
            this.cabeca = novo;
        } else {
            this.cabeca = insereEsquerdaRec(this.cabeca, posicao, info, 0);
        }
        this.tamanho++;
    }

    private No insereEsquerdaRec(No no, int posicao, int info, int current) {
        if (current == posicao - 1) {
            No novo = new No(info);
            novo.prox = no.prox;
            no.prox = novo;
        } else {
            no.prox = insereEsquerdaRec(no.prox, posicao, info, current + 1);
        }
        return no;
    }

    public void print() {
        No atual = this.cabeca;
        while (atual != null) {
            System.out.print(atual.info + " ");
            atual = atual.prox;
        }
        System.out.println();
    }
}