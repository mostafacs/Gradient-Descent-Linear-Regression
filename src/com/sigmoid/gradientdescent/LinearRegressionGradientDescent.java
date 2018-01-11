package com.sigmoid.gradientdescent;

import java.math.BigDecimal;
import com.sigmoid.util.MatrixUtil;

public class LinearRegressionGradientDescent extends GradientDescent {

	BigDecimal[][] dataset;
	BigDecimal[] target;
	BigDecimal learningRate;
	
	BigDecimal baseParam = new BigDecimal(0.0);
	BigDecimal dataSetCount;
	
	
	
	
	
	public LinearRegressionGradientDescent(BigDecimal[][] dataset, BigDecimal[] target, BigDecimal learningRate) {
		super(GradientDescent.STOPMODE_AUTO, dataset[0].length);
		this.dataset = new BigDecimal[dataset.length][dataset[0].length+1];
		
		for(int i=0; i< dataset.length; i++) {
			this.dataset[i] = new BigDecimal[dataset[0].length+1];
			this.dataset[i][0] = BigDecimal.ONE;
			for(int j=0; j< dataset[0].length; j++) {
				this.dataset[i][j+1] = dataset[i][j]; 
			}		
		}
		this.target = target;
		this.learningRate = learningRate;
		dataSetCount = new BigDecimal(dataset.length);
	}
	
	public LinearRegressionGradientDescent(BigDecimal[][] dataset, BigDecimal[] target, BigDecimal learningRate,int maxItr) {
		super(dataset[0].length, maxItr);
		// Change dataset structure to support base parameter.
		this.dataset = new BigDecimal[dataset.length][dataset[0].length+1];
		
		for(int i=0; i< dataset.length; i++) {
			this.dataset[i] = new BigDecimal[dataset[0].length+1];
			this.dataset[i][0] = BigDecimal.ONE;
			for(int j=0; j< dataset[0].length; j++) {
				this.dataset[i][j+1] = dataset[i][j]; 
			}		
		}
		this.target = target;
		this.learningRate = learningRate;
		dataSetCount = new BigDecimal(dataset.length);
	}
	
	@Override
	public BigDecimal predict(BigDecimal[] feature) {
		BigDecimal[] newFeature = new BigDecimal[feature.length+1];
		newFeature[0] = BigDecimal.ONE;
		for (int i = 0; i < feature.length; i++) {
			newFeature[i+1] = feature[i];
		}
		return MatrixUtil.multiplySingleRow(newFeature, this.getParams()).setScale(100, BigDecimal.ROUND_HALF_UP);
	}


	@Override
	public BigDecimal updateParams(int currentParameter, BigDecimal[] params) {
		
		BigDecimal gain = new BigDecimal(0.0);
		for(int i=0;i<dataset.length;i++) {
			BigDecimal hypothesis = MatrixUtil.multiplySingleRow(dataset[i], params);
			gain = gain.add( hypothesis.subtract(target[i])
					.multiply(dataset[i][currentParameter])  );
		}

		BigDecimal paramEditor = gain.divide(dataSetCount, 1000, BigDecimal.ROUND_HALF_UP).multiply(learningRate);
		return params[currentParameter].subtract(paramEditor);
	}
	
	
	@Override
	public double errorCalc(BigDecimal[] params) {
		Double earn = 0.0;
		for(int i=0;i<dataset.length;i++) {
			BigDecimal paramTarget = MatrixUtil.multiplySingleRow(dataset[i], params);
			earn += Math.sqrt(Math.pow(target[i].subtract(paramTarget).doubleValue(), 2));
		}
		return earn;
	}


	
}
