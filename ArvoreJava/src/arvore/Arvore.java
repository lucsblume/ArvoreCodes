package arvore;

import java.util.ArrayList;

public class Arvore {

	No raiz;
	
	public Arvore()
	{
		raiz = null;
	}
	public void addNo(Object valor)
	{
		No novo= new No(valor);
		if(raiz == null)
		{
			raiz = novo;
		}else
		{
			adicionar(novo,raiz);
		}
	}
	
	public int altura(No pai,int a)
	{
		int altura =0;
		if(pai!=null)
		{
			altura = a;
			altura = Math.max(altura, altura(pai.getfEsq(),a+1));
			altura = Math.max(altura, altura(pai.getfDir(),a+1));
		}
		return altura;
	}
	
	
	public void adicionar(No novo, No pai)
	{
		if(compara(novo.valor, pai.valor)>0)
		{
			if(pai.getfDir()!=null)
			{
				adicionar(novo,pai.getfDir());
			}else
			{
				novo.setPai(pai);
				pai.setfDir(novo);
			}
		}
		if(compara(novo.valor, pai.valor)<0)
		{
			if(pai.getfEsq()!=null)
			{
				adicionar(novo,pai.getfEsq());
			}else
			{
				novo.setPai(pai);
				pai.setfEsq(novo);
			}
		}
		
	}
	
	public void exibirPreOrdem(No pai)
	{
		if(pai==null)
		{
			return;
		}else{
			System.out.println(pai.valor+" ");
			if(pai.fEsq!= null)
				exibirPreOrdem(pai.fEsq);
			if(pai.fDir!= null)
				exibirPreOrdem(pai.fDir);
		}
	}
	public void exibirEmOrdem(No pai)
	{
		if(pai==null)
		{
			return;
		}else{
			
			if(pai.fEsq!= null)
				exibirEmOrdem(pai.fEsq);
			
			System.out.println(pai.valor+" ");
			
			
			if(pai.fDir!= null)
				exibirEmOrdem(pai.fDir);		
		}
	}
	
	public void removerNode(No nodeRemove)
	{
		if(nodeRemove.getfEsq()==null || nodeRemove.getfDir()==null)
		{
			removerFolha(nodeRemove);
		}else
		{
			No node  = nodeRemove.getfDir();
			while(node.getfEsq()!=null)
			{
				node  = node.getfEsq();
			}
			removerFolha(node);
			node.setPai(nodeRemove.getPai());
			node.setfEsq(nodeRemove.getfEsq());
			node.setfDir(nodeRemove.getfDir());
			
			if(node.getfEsq()!=null)
				node.getfEsq().setPai(node);
			if(node.getfDir()!=null)
				node.getfDir().setPai(node);
			if(nodeRemove!=raiz){
				if(nodeRemove.isFilhoE())
				{
					node.getPai().setfEsq(node);
				}else
				{
					node.getPai().setfDir(node);
				}
			}else
			{
				raiz = node;
			}
			
		}
	}
	
	public void removerFolha(No node)
	{
		if(node.getfDir() == null && node.getfEsq()==null)
		{
			if(node!=raiz)
			{
				if(node.isFilhoE())
				{
					node.getPai().setfEsq(null);
				}else
				{
					node.getPai().setfDir(null);
				}
			}else{
				raiz = null;
			}
		}else if(node.getfEsq() == null || node.getfDir() == null )
		{
			if(node.getfEsq()== null)
			{
				if(node!=raiz)
				{
					node.getfDir().setPai(node.getPai());
					if(node.isFilhoE())
					{
						node.getPai().setfEsq(node.getfDir());
					}else
					{
						node.getPai().setfDir(node.getfDir());
					}
					
				}else
				{
					node.getfDir().setPai(null);
					raiz = node.getfDir();
				}
			}else
			{
				if(node!=raiz)
				{
					node.getfEsq().setPai(node.getPai());
					if(node.isFilhoE())
					{
						node.getPai().setfEsq(node.getfEsq());
					}else
					{
						node.getPai().setfDir(node.getfEsq());
					}
					
				}else
				{
					node.getfEsq().setPai(null);
					raiz = node.getfEsq();
				}
			}
		}
	}
	
	public int getSize()
	{
		if(raiz==null)
			return 0;
		
		int size = 0;
		No node;
		ArrayList<No> v = new ArrayList<No>();
		v.add(raiz);
		while(v.size()!=0)
		{
			node = v.remove(0);
			size++;
			if(node.getfEsq()!=null)
			v.add(node.getfEsq());
			if(node.getfDir()!=null)
				v.add(node.getfDir());
		}
		return size;
	}
	
	public boolean pesquisar(No node) {
		if (raiz == null)
			return false;
		else
			return pesquisarValue(node,raiz);
	}
	public boolean pesquisarValue(No node, No pai) {
		if (node.valor== pai.valor)
			return true;
		else if (compara(node, pai)<0) {
			if (node.getfEsq() == null)
				return false;
			else
				return pesquisarValue(node,pai.getfEsq());
		}
		else if (compara(node, pai)>0) {
			if (node.getfDir() == null)
				return false;
			else
				return pesquisarValue(node,pai.getfDir());
		}

		return false;
	}
	
	public void exibirPosOrdem(No pai) {
		if (pai.getfEsq() != null)
			exibirPosOrdem(pai.getfEsq());

		if (pai.getfDir() != null)
			exibirPosOrdem(pai.getfDir());

		System.out.print(pai.valor + " ");
	}
	
	public Object menorValor(No pai) {
		if (pai.getfEsq() == null)
			return pai.valor;
		else
			return menorValor(pai.getfEsq());
	}
	
	public int compara(Object x, Object y)
	{
		if(x instanceof Number)
		{
			double a = ((Number)x).doubleValue();
			double b = ((Number)y).doubleValue();
			if(a>b)
				return 1;
			else if(a<b)
				return -1;
			else 
				return 0;	
		}else
		{
			String a = x.toString();
			String b = y.toString();
			return a.compareTo(b);
		}
	}

}
