package Classes;

public class FilaArquivos {
	private No cabeca = null;
    private No calda = null;

  public void inserir(String info){
      No NovoNo = new No();
      NovoNo.setInformacao(info);
      
      if(cabeca==null){
          cabeca = NovoNo;
      }else{
          calda.setProximono(NovoNo);
      }
          calda = NovoNo;
      
  }
  
  public void remover(){
      if(cabeca == null){
          System.out.println("Lista vazia");
      }else{
          if(cabeca == calda){
              cabeca = null;
              calda =null;
          }else{
              cabeca = cabeca.getProximono();
          }
          
      
      }
  
  }
  
  
    public String visualizar() {
		String texto = "";
		
		No auxiliar = cabeca;
		No seguinte = null;
		String info = null;
		
		while(auxiliar != null) {
			info = auxiliar.getInformacao();
			
			texto = texto + info.toString() + "\n";
			
			seguinte = auxiliar.getProximono();
			auxiliar = seguinte;
		}
		
		return texto;
	}

}
