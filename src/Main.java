public class Main {
    public static void main(String[] args) {
        Arvore minhaArvore = new Arvore();

        minhaArvore.inserir(50);
        minhaArvore.inserir(30);
        minhaArvore.inserir(70);
        minhaArvore.inserir(20);
        minhaArvore.inserir(40);
        minhaArvore.inserir(60);
        minhaArvore.inserir(80);
        minhaArvore.inserir(10);
        minhaArvore.inserir(35);
        minhaArvore.inserir(65);
        minhaArvore.inserir(90);

        minhaArvore.inserir(40);   // repetido, nao entra
        minhaArvore.inserir(null); // null, nao faz nada

        System.out.println("Arvore em ordem:");
        minhaArvore.emOrdem();

        System.out.println();
        System.out.println("Buscando 65: " + minhaArvore.buscar(65));
        System.out.println("Buscando 100: " + minhaArvore.buscar(100));

        System.out.println();
        System.out.println("Removendo 10 (no folha):");
        minhaArvore.remover(10);
        minhaArvore.emOrdem();

        System.out.println("Removendo 40 (no com um filho):");
        minhaArvore.remover(40);
        minhaArvore.emOrdem();

        System.out.println("Removendo 70 (no com dois filhos):");
        minhaArvore.remover(70);
        minhaArvore.emOrdem();
    }
}
