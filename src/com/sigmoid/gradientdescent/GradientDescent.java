package com.sigmoid.gradientdescent;

import java.math.BigDecimal;

public abstract class GradientDescent {
	
	public static String STOPMODE_AUTO = "auto";
	public static String STOPMODE_MAX_Iteration = "maxItr";
	public String stopMode;
	private BigDecimal[] params;
	private int maxItr = Integer.MAX_VALUE;
		
	public GradientDescent(String stopMode, int featureSize) {
		this.stopMode = stopMode;
		this.params = new BigDecimal[featureSize+1];
		for(int i=0; i< this.params.length; i++) {
			this.params[i] = BigDecimal.ZERO;
		}
	}

	public GradientDescent(int featureSize, int maxItr) {
		this.stopMode = STOPMODE_MAX_Iteration;
		this.maxItr = maxItr;
		this.params = new BigDecimal[featureSize+1];
		for(int i=0; i< this.params.length; i++) {
			this.params[i] = BigDecimal.ZERO;
		}
	}
	
	public abstract BigDecimal updateParams(int paramIndex, BigDecimal[] params);
	
	public abstract double errorCalc(BigDecimal[] params);
	
	public abstract BigDecimal predict(BigDecimal[] feature);
	
	
	public void train(){
		
		double bestError = Double.MAX_VALUE;
		BigDecimal[] bestParams = null;
		int lastUpdateItr = 0;
		int itr = 0;
		
		do {
			BigDecimal[] newParams = new BigDecimal[this.params.length];
			for(int i=0; i< this.params.length; i++) {
			    newParams[i] = this.updateParams(i, params);
			}

			double error = this.errorCalc(newParams);
			if(error < bestError) {
				bestError = error;
				bestParams = newParams;
				lastUpdateItr = itr;
			}
			this.params = newParams;
			itr++;
				
		}while( (this.stopMode == STOPMODE_AUTO && (itr - lastUpdateItr ) < 100 ) || ( this.stopMode == STOPMODE_MAX_Iteration && itr < maxItr) );
	
		this.params = bestParams;		
	}
	
	
	public BigDecimal[] getParams(){
		return this.params;
	}
	

	

}
