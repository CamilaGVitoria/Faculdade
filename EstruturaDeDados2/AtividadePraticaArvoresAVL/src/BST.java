import java.util.Stack;

public class BST {
    private No raiz;

    public BST() {
        this.raiz = null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    private void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void inserir(int valor) {
        if (this.raiz == null) {
            this.raiz = new No(valor);
        } else {
            inserir(this.raiz, valor);
        }
    }

    private No inserir(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);

        }

        if (valor < raiz.valor) {
            raiz.esq = inserir(raiz.esq, valor);
        } else if (valor > raiz.valor) {
            raiz.dir = inserir(raiz.dir, valor);
        } else {
            return raiz;
        }

        atualizarAltura(raiz);
        return rebalancear(raiz);
    }

    public boolean isFolha(No no) {
        if (no.esq == null && no.dir == null) {
            return true;
        }
        return false;
    }

    public boolean buscar(int valor) {
        return buscar(this.raiz, valor);
    }

    private boolean buscar(No raiz, int valor) {

        if (raiz == null)
            return false;
        if (raiz.valor == valor)
            return true;
        if (valor < raiz.valor)
            return buscar(raiz.esq, valor);
        else
            return buscar(raiz.dir, valor);
    }

    public void apagar(int valor) {
        raiz = apagar(this.raiz, valor);
    }

    private No apagar(No raiz, int valor) {
        if (raiz == null) {
            return null;
        }
        if (valor < raiz.valor)
            raiz.esq = apagar(raiz.esq, valor);
        else if (valor > raiz.valor)
            raiz.dir = apagar(raiz.dir, valor);
        else {
            if (raiz.esq == null && raiz.dir == null) {
                return null;
            } else if (raiz.esq == null || raiz.dir == null) {
                if (raiz.esq != null) {
                    raiz = raiz.esq;
                } else {
                    raiz = raiz.dir;
                }
            } else {
                No tempNo = min(raiz.dir);
                raiz.valor = tempNo.valor;
                raiz.dir = apagar(raiz.dir, tempNo.valor);
            }
        }
        atualizarAltura(raiz);
        return rebalancear(raiz);
    }

    private No min(No raiz) {
        if (raiz == null)
            return raiz;
        if (raiz.esq != null) {
            return min(raiz.esq);
        }
        return raiz;
    }

    private No max(No raiz) {
        if (raiz == null)
            return raiz;

        if (raiz.dir != null) {
            return max(raiz.dir);
        }
        return raiz;
    }

    public void imprimirPreOrdem() {
        this.imprimirPreOrdem(this.raiz);

    }

    private void imprimirPreOrdem(No raiz) {
        if (raiz != null) {
            imprimirPreOrdem(raiz.esq);
            System.out.print(raiz.valor + " ");
            imprimirPreOrdem(raiz.dir);

        }
    }

    public void imprimirEmOrdem() {
        this.imprimirEmOrdem(this.raiz);
    }

    private void imprimirEmOrdem(No raiz) {
        if (raiz != null) {
            imprimirEmOrdem(raiz.esq);
            System.out.print(raiz.valor + " ");
            imprimirEmOrdem(raiz.dir);

        }
    }

    public void imprimirPosOrdem() {
        this.imprimirPosOrdem(this.raiz);
    }

    private void imprimirPosOrdem(No raiz) {
        if (raiz != null) {
            imprimirPosOrdem(raiz.esq);
            System.out.print(raiz.valor + " ");
            imprimirPosOrdem(raiz.dir);

        }
    }

    public int getFatorBalanceamento(No no) {
        if (no == null)
            return 0;
        return altura(no.esq) - altura(no.dir);
    }

    public int altura(No no) {
        if (no == null)
            return 0;
        return no.alt;
    }

    public void atualizarAltura(No no) {
        no.alt = 1 + Math.max(altura(no.esq), altura(no.dir));
    }

    public int nivelElemento(int valor) {
        return nivelElemento(this.raiz, valor, 0);
    }

    private int nivelElemento(No raiz, int valor, int nivel) {
        if (raiz == null)
            return -1;

        if (raiz.valor == valor)
            return nivel;

        if (valor < raiz.valor) {
            return nivelElemento(raiz.esq, valor, nivel + 1);
        } else {
            return nivelElemento(raiz.dir, valor, nivel + 1);
        }

    }

    public int getQtdNos() {
        return this.getQtdNos(this.raiz);
    }

    private int getQtdNos(No raiz) {
        if (raiz == null) {
            return 0;
        }

        return 1 + getQtdNos(raiz.esq) + getQtdNos(raiz.dir);
    }

    public int getQtdFolhas() {
        return this.getQtdFolhas(this.raiz);
    }

    private int getQtdFolhas(No raiz) {
        if (raiz == null) {
            return 0;
        }

        if (isFolha(raiz))
            return 1;
        else
            return getQtdFolhas(raiz.esq) + getQtdFolhas(raiz.dir);
    }

    public boolean isEstritamenteBinario() {
        return this.isEstritamenteBinario(this.raiz);
    }

    private boolean isEstritamenteBinario(No raiz) {

        if (raiz == null) {
            return true;
        }

        if (raiz.esq == null && raiz.dir == null) {
            return true;
        }

        if (raiz.esq != null && raiz.dir != null) {
            return isEstritamenteBinario(raiz.esq) && isEstritamenteBinario(raiz.dir);
        }

        return false;
    }

    public boolean iguais(No raiz1, No raiz2) {
        if (raiz1 == null && raiz2 == null) {
            return true;
        }

        if (raiz1 == null || raiz2 == null) {
            return false;
        }

        if (raiz1.valor != raiz2.valor) {
            return false;
        }

        return iguais(raiz1.esq, raiz2.esq) && iguais(raiz1.dir, raiz2.dir);
    }

    public boolean similar(No raiz1, No raiz2) {
        if (raiz1 == null && raiz2 == null) {
            return true;
        }

        if (raiz1 == null || raiz2 == null) {
            return false;
        }

        return similar(raiz1.esq, raiz2.esq) && similar(raiz1.dir, raiz2.dir);
    }

    public void inserirSemRecursivo(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No noAtual = this.raiz;

            while (noAtual != null) {
                if (valor == noAtual.valor)
                    return;

                if (valor < noAtual.valor) {
                    if (noAtual.esq == null) {
                        noAtual.esq = novoNo;
                        return;
                    } else {
                        noAtual = noAtual.esq;
                    }
                } else {
                    if (noAtual.dir == null) {
                        noAtual.dir = novoNo;
                        return;
                    } else {
                        noAtual = noAtual.dir;
                    }
                }
            }
        }
    }

    public No rotacaoDireita(No A) {
        No B = A.esq;
        No Bdir = B.dir;

        B.dir = A;
        A.esq = Bdir;

        atualizarAltura(A);
        atualizarAltura(B);

        return B;
    }

    public No rotacaoEsquerda(No A) {
        No B = A.dir;
        No Besq = B.esq;

        B.esq = A;
        A.dir = Besq;

        atualizarAltura(A);
        atualizarAltura(B);

        return B;
    }

    private No rebalancear(No no) {
        int fatorBalanceamento = getFatorBalanceamento(no);

        if (fatorBalanceamento > 1 && getFatorBalanceamento(no.esq) >= 0) {
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento > 1 && getFatorBalanceamento(no.esq) < 0) {
            no.esq = rotacaoEsquerda(no.esq);
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -1 && getFatorBalanceamento(no.dir) <= 0) {
            return rotacaoEsquerda(no);
        }

        if (fatorBalanceamento < -1 && getFatorBalanceamento(no.dir) > 0) {
            no.dir = rotacaoDireita(no.dir);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(raiz);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                No temp = (No) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.valor);
                    localStack.push(temp.esq);
                    localStack.push(temp.dir);
                    if (temp.esq != null ||
                            temp.dir != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}