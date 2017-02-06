package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double valorMedioDosLances;

	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)
				maiorDeTodos = lance.getValor();

			if (lance.getValor() < menorDeTodos)
				menorDeTodos = lance.getValor();
		}

		valorMedioDosLances = leilao.getLances().stream().mapToDouble(lance -> lance.getValor()).average().getAsDouble();
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

	public double getValorMedioDosLances() {
		return valorMedioDosLances ;
	}

}