package arvore;

public class Main {
	
	public static void main(String[] args) {
		
		Arvore  tree = new Arvore();
		
		tree.addNo(8.5);
		tree.addNo(5.8);
		tree.addNo(100.0);
		tree.addNo(120.0);
		tree.addNo(10.0);
		tree.addNo(7.0);
		tree.addNo(70.0);
		//tree.removerNode(tree.raiz.getfDir());
		tree.exibirEmOrdem(tree.raiz);
		System.out.println(tree.getSize());
		
		
	}

}
