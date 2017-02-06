package br.com.caelum.leilao.servico;

import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("PlayStation 4 Novo");

		leilao.propoe(new Lance(joao,  250.0));
		leilao.propoe(new Lance(jose,  300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 400;
		double menorEsperado = 250;

		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveCalcularOValorMedioDosLances() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("PlayStation 4 Novo");

		leilao.propoe(new Lance(joao,  300.0));
		leilao.propoe(new Lance(jose,  200.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double valorMedioDosLances = 300;

		Assert.assertEquals(valorMedioDosLances, leiloeiro.getValorMedioDosLances(), 0.00001);
	}

}