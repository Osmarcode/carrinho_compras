package carrinho_compras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarrinhoDeCompras {

	
   private List<Item> itens;
   
   
   //construtor 
   public CarrinhoDeCompras() {
	   this.itens = new ArrayList<>();
   }

    
    // Adicionar item ao carrinho, checando pelo nome
   public void adicionarItem(String nome, double preco, int quantidade) {
	   for (Item item : itens) {
		   if(item.getNome().equalsIgnoreCase(nome)) {
			   item.setQuantidade(item.getQuantidade() + quantidade);
			   return;
		   }
	   }
	   itens.add(new Item(nome, preco, quantidade));
   }
    
    public void removerItem(String nome) {
		List<Item> itemRemover = new ArrayList<>();
		
		//percorrendo com for each 
		for(Item item : itens) {
			if(item.getNome().equalsIgnoreCase(nome)) {
				itemRemover.add(item);
			}
		}
		itens.removeAll(itemRemover);
	}
    
    //calcula e retorna o valor total do carrinho
    public double calcularValorTotal() {
    	double valorTotal = 0;
    	for(Item item : itens) {
    	valorTotal += item.getPreco() + item.getQuantidade();
    }
    return valorTotal;
 }
    
    
    //exibe todos os itens do carrinho
    public void exibirItens() {
    	if(itens.isEmpty()) {
    		System.out.println("Carrinho vazio");
    	} else {
    		for(Item item : itens) {
    			System.out.println(item);
    		}
    	}	
    }
    
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

      carrinho.adicionarItem("Teclado", 65.26, 1);
      carrinho.adicionarItem("Monitor 27'", 1900.99, 1);
      carrinho.adicionarItem("Gabinete FX Pro 980t", 650.52, 1);
      carrinho.adicionarItem("Placa de vídeo Asrock GX4000", 700.00, 1);

       System.out.println("Itens do carrinho: ");
       carrinho.exibirItens();

       double valorTotal = carrinho.calcularValorTotal();
       System.out.println("Valor total dos itens R$ " + valorTotal);

        carrinho.removerItem("Teclado");

        System.out.println("\nItens no carrinho após remoção:");
        carrinho.exibirItens();

        valorTotal = carrinho.calcularValorTotal();
        System.out.println("Valor total após remoção: R$ " + valorTotal);
    }
}

