package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Imposto {
	
	private Imposto outro;
	
	public Imposto(Imposto outro) {
		this.outro = outro;
	}

	protected abstract BigDecimal realizaCalculo(Orcamento orcamento);

	public  BigDecimal calcular(Orcamento orcamento) {
		BigDecimal valorImposto  = realizaCalculo(orcamento);
		BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
		
		if(outro != null) {
			valorDoOutroImposto = outro.realizaCalculo(orcamento);
		}
		return  valorImposto.add(valorDoOutroImposto);
	}
}
