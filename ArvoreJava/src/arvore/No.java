package arvore;

public class No {
	
	Object valor;
	No fEsq; //left
	No fDir; //right
	No pai; //pai
	
	public No(Object valor)
	{
		this(valor,null,null,null);
	}
	public No(Object valor,No pai)
	{
		this(valor,pai,null,null);
	}
	public No(Object valor,No pai,No fEsq,No fDir)
	{
		this.valor = valor;
		this.pai = pai;
		this.fEsq = fEsq;
		this.fDir = fDir;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	public No getfEsq() {
		return fEsq;
	}
	public void setfEsq(No fEsq) {
		this.fEsq = fEsq;
	}
	public No getfDir() {
		return fDir;
	}
	public void setfDir(No fDir) {
		this.fDir = fDir;
	}
	public No getPai() {
		return pai;
	}
	public void setPai(No pai) {
		this.pai = pai;
	}
	public boolean isFilhoE()
	{
		return (this.getPai().getfEsq() == this);
	}
	
	
	

}
