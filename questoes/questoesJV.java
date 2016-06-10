public class QJV {
public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//Questão 01: Adquirindo os parâmetros da função
		System.out.println("Digite o valor em reais: ");
		double reais = s.nextDouble();
		int moeda;
		do{
		System.out.println("Digite a moeda a converter: Dólar(1), Euro(2), Libra(3)");
		moeda = s.nextInt();
		if(moeda < 0 || moeda > 3)
			System.out.println("Transação inexistente.");
		}while(moeda < 0 || moeda > 3);
		conversao(moeda, reais);
		
		//Questão 02: função para verificar números perfeitos
		verificar();
		
		//Questão 03: Preparando o método main para chamar a função imprime
		int Y;
		System.out.println("Digite o n desejado");
		Y = s.nextInt();
		
		for (int X = 0; X <= Y; X++) {
			imprime(X, Y);
		}
		
		//Questão 04:
		System.out.println("Digite um numero: ");
		int n = s.nextInt();
		int sequencia[] = new int[n];
		sequencia[0] = 0;
		sequencia[1] = 1;
		for (int i = 2; i < sequencia.length; i++) {
			sequencia[i] = sequencia[i - 1] + sequencia[i-2];
		}
		for (int j = 0; j < sequencia.length; j++) {
			System.out.printf("%d ", sequencia[j]);
		}
		s.close();
		
		//A questão 05 é idêntica à questão 02, então precisa ser refeita.
		
		//Questão 06: Criação de 2 vetores (A e B) e depois de um vetor C que intercala e ordena os valores desses dois.
		int A[] = { 1, 3, 5 };
		int B[] = { 2, 4, 6 };
		int C[] = new int[A.length + B.length];

		for (int i = 0; i < C.length; i++) {
			if (i < A.length)
				C[i] = A[i];
			else
				C[i] = B[i - A.length];
		}

		for (int i = 1; i < C.length; i++) {
			for (int j = 0; j < C.length - i; j++) {
				if (C[j] > C[j + 1]) {
					int aux = C[j];
					C[j] = C[j + 1];
					C[j + 1] = aux;
				}
			}
		}

		for (int i = 0; i < C.length; i++) {
			System.out.println(C[i]);
		}
		
		//Questão 07: chamar procedimento para a leitura de um vetor, depois uma funcão que retorna o maior número desse vetor.
		int A[] = { 1, 2, 3, 4, 5 };
		lervetor(A);
		int maior = 0;
		maior = acharnumero(A, maior);
		System.out.println(maior);
		
		//Questão 08: busca binária de um número em um vetor, avisando caso o número buscado não se encontre no vetor
		int A[] = {1,2,3,4,5,6};
		System.out.println("Digite o numero que deseja buscar: ");
		int x = s.nextInt();
		int pos = -1, inicio = 0, meio, fim = A.length - 1;
		while(inicio <= fim && pos == -1){
			meio = (inicio + fim)/2;
			if(A[meio] == x)
				pos = meio;
			else if(x < A[meio])
				fim = meio - 1;
			else
				inicio = meio + 1;
		}
		if(pos != -1)
			System.out.printf("Elemento está na posição %d", pos + 1);
		else
			System.out.println("Elemento não se encontra no vetor");
		
		//Questão 09: ordenacão dos atletas de 3 vetores a partir de sua altura em ordem crescente
			String nomes[] = { "Ailton", "Marlos", "Maicon", "Marco", "Lucas" };
		int altura[] = { 175, 182, 190, 168, 188 };
		double peso[] = { 75.9, 94.2, 91.1, 81.5, 92.6 };
		int menor1, pos;
		String menor2;
		double menor3;
		for (int i = 0; i < altura.length - 1; i++) {
			menor1 = altura[i];
			menor2 = nomes[i];
			menor3 = peso[i];
			pos = i;
			for (int j = i + 1; j < altura.length; j++) {
				if (altura[j] < menor1) {
					menor1 = altura[j];
					menor2 = nomes[j];
					menor3 = peso[j];
					pos = j;
				}
			}
			altura[pos] = altura[i];
			nomes[pos] = nomes[i];
			peso[pos] = peso[i];
			altura[i] = menor1;
			nomes[i] = menor2;
			peso[i] = menor3;
		}

		for (int i = 0; i < altura.length; i++) {
			System.out.println(nomes[i] + "\t" + altura[i] + "\t" + peso[i]);
		}
		
		//Questão 10: funcionamento de um elevador, lendo o peso de uma pessoa e encerrando caso um de seus dois limites (altura ou peso) seja ultrapassado
		int limitePessoa = 15, pessoas = 0;
		double limitePeso = 800.0, aux = 0, peso, pesototal;
		do{
			if(pessoas == limitePessoa)
				System.out.println("Entrada proibida, limite de pessoas alcançado!");
			System.out.println("Digite seu peso:");
			peso = s.nextDouble();
			pesototal = aux + peso;
			aux = pesototal;
			if(pesototal > limitePeso)
				System.out.println("Entrada proibida, limite de peso ultrapassado!");
			else if(pesototal == limitePeso)
				System.out.println("Entrada proibida, limite de peso alcançado!");
			pessoas++;
		}while(pessoas < limitePessoa && pesototal < limitePeso);
		s.close();
		System.out.printf("Quantidade de pessoas carregadas: %d \n", pessoas);
		System.out.printf("Quantidade de peso carregado: %2.1f", pesototal);
		System.exit(0);
		
	//Questão 11: leitura de um vetor char de gabaritos e uma matriz de respostas dos alunos, depois imprimir a matriz de respostas indicando quantos acertos de cada aluno
		char gabarito[] = {'a', 'c', 'b', 'e', 'd'};
		char respostas[][] = {{'a','e','b','e','c','c'}, {'b','c','d','d','d','d'}, {'a','e','e','e','b','d'}, {'a','d','b','e','b','e'}, {'e','c','b','e','c','d'}};
		int acertos=0;
		for (int i = 0; i < respostas.length; i++) {
			for (int j = 0; j < respostas.length; j++) {
				if(respostas[i][j] == gabarito[i])
					acertos = acertos+1;
				System.out.printf("%c \t", respostas[i][j]);
			}System.out.printf("%d", acertos);
			System.out.println("");
		}
		
		//Questão 12: trocar, em uma matriz 5x5, as linhas 2 e 4 e as colunas 1 e 3, após, imprimir a matriz.
		int matriz[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int aux1[] = new int [matriz.length];
		int aux2[] = new int [matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				aux1[j] = matriz[2][j];
				matriz[2][j] = matriz[4][j];
				matriz[4][j] = aux1[j];
				aux2[i] = matriz[i][1];
				matriz[i][1] = matriz[i][3];
				matriz[i][3] = aux2[i];
			}
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.printf("%d \t", matriz[i][j]);
			}System.out.println(" ");
		
		//Questão 13: criar uma matriz e após, dois vetores, A e B, cujos valores são as somas dos valores de cada linha e a dos valores de cada coluna, respectivamente
		int matriz[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int A[] = new int[3];
		int B[] = new int[3];
		for (int i = 0; i < matriz.length; i++) {
				A[i] = matriz[i][0] + matriz[i][1] + matriz[i][2];
				B[i] = matriz[0][i] + matriz[1][i] + matriz[2][i];
		}
		for (int i = 0; i < B.length; i++) {
			System.out.printf("%d \t", A[i]);
			System.out.printf("%d \n", B[i]);
		}
		
		//Questão 14: ler o número de locações que cada cliente fez no ano anterior e imprimir quantos filmes cada cliente pode alugar grauitamente
		int clientes[] = new int[10];
		int locacoes;
		for (int i = 0; i < clientes.length; i++) {
			System.out.println("caro cliente, por favor digite a quantidade de locações feitas por você: ");
			locacoes = s.nextInt();
			clientes[i] = locacoes;
		}
		int promocao[] = new int[clientes.length];
		for (int i = 0; i < clientes.length; i++) {
			promocao[i] = clientes[i]/10;
		}
		for (int i = 0; i < promocao.length; i++) {
			System.out.printf("O cliente %d tem direito a %d locações grátis; \n", i + 1, promocao[i]);
		}
	
		s.close();
	}
	//Questão 01: função para conversão para moeda estrangeira
	static double conversao(int moeda, double reais){
		double convertido = 0;
		if(moeda == 1)
			convertido = reais*0.55;
		else if(moeda == 2)
			convertido = reais*0.41;
		else
			convertido = reais*0.35;
		System.out.printf("Seu dinheiro na moeda estrangeira escolhida vale %3.2f", convertido);
		return convertido;
		
		//Questão 02: Verificar se um número é perfeito, e retornar true caso sim, false caso não.
		static boolean verificar(){
	Scanner s = new Scanner(System.in);
	boolean perfeito = false;
	System.out.println("Digite um número: ");
	int numero = s.nextInt();
	int cont = 0;
	for(int i = 1; i < numero; i++){
		if(numero%i == 0)
			cont = cont + i;
	}
	if(cont == numero){
		perfeito = true;
		System.out.println("O número digitado é perfeito.");
	}else{
		System.out.println("O número digitado não é perfeito.");
	}
	s.close();
	return perfeito;
}

	//Questão 03: Função imprime
		static void imprime(int X, int Y) {
		for (int i = 0; i < X; i++) {
			System.out.printf("%d \t", X);
		}
		System.out.println(" ");
	}
	
	//Questão 7: procedimento que lê o vetor
		static void lervetor(int A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
		//Questão 7: função que retorna o maior número do vetor
		static int acharnumero(int A[], int maior) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] > maior)
				maior = A[i];
		}
		return maior;
  }
}
