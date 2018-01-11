package com.sigmoid.test;

import java.math.BigDecimal;

import com.sigmoid.gradientdescent.GradientDescent;
import com.sigmoid.gradientdescent.LinearRegressionGradientDescent;

public class LinearRegressionGDTest {

	public static void main(String[] args) {
		// visualization image attached.
		BigDecimal [][] dataset = {{new BigDecimal(0)},
				{new BigDecimal(1)},
				{new BigDecimal(2)},
				{new BigDecimal(3)},
				{new BigDecimal(2.5)},
				{new BigDecimal(2.7)},
				{new BigDecimal(2.8)},
				{new BigDecimal(2.5)},
				{new BigDecimal(2.8)},
				{new BigDecimal(2.9)},
				{new BigDecimal(2.8)},
				{new BigDecimal(2.7)},
				{new BigDecimal(2.6)},
				{new BigDecimal(2.6)},
				{new BigDecimal(2.7)},
				{new BigDecimal(2.6)},
				{new BigDecimal(2.9)},
				{new BigDecimal(3)},
				{new BigDecimal(3.1)} };
			
			BigDecimal [] targets = {new BigDecimal(1),
					new BigDecimal(-2),
				new BigDecimal(10),
				new BigDecimal(4),
				new BigDecimal(4),
				new BigDecimal(4.5),
				new BigDecimal(4.7),
				new BigDecimal(3.8),
				new BigDecimal(3.9),
				new BigDecimal(4.3),
				new BigDecimal(4.2),
				new BigDecimal(4.3),
				new BigDecimal(3.8),
				new BigDecimal(4),
				new BigDecimal(4.1),
				new BigDecimal(4.8),
				new BigDecimal(4.5),
				new BigDecimal(4.3),
				new BigDecimal(4.8) };
			
			BigDecimal lr = new BigDecimal(.1);
			
			GradientDescent descent = new LinearRegressionGradientDescent(dataset, targets, lr);
			descent.train();
			
			System.out.println(">>>>>>>>>>>>>>>>>> ----------Predictions---------- <<<<<<<<<<<<<<<<<<");
			System.out.println(descent.predict(dataset[0]).doubleValue());
			System.out.println(descent.predict(dataset[1]).doubleValue());
			System.out.println(descent.predict(dataset[2]).doubleValue());
			System.out.println(descent.predict( dataset[dataset.length - 1] ).doubleValue());
		
	}
		




}
