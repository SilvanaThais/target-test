public class Fibonacci {
	public static void main(String[] args) {
		int numero = 10; //Definimos o número que queremos verificar
		int anterior = 0;
		int atual = 1;
		int proximo;
		boolean pertence = false; //Variável que indicará se o número pertence ou não a sequência de Fibonacci
		
		System.out.print(anterior + ", " + atual);
		
		while (atual < numero) {
			proximo = anterior + atual;
			System.out.print(", " + proximo);
			anterior = atual;
			atual = proximo;
			
			if (atual == numero) {
				pertence = true;
			}
		}
		
		if (pertence == true) {
			System.out.println("\nO número " + numero + " pertence à sequência de Fibonacci");
		} else {
			System.out.println("\nO número " + numero + " não pertence à sequência de Fibonacci");
		}
	}
}