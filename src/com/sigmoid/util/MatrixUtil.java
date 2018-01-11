package com.sigmoid.util;

import java.math.BigDecimal;

public class MatrixUtil {

/*	public BigDecimal[][] multiply(BigDecimal[][] m1, BigDecimal[][] m2) throws Exception{
		if(m1[0].length != m2.length) {
			throw new IllegalArgumentException("Number of Columns on first matrix should equal number of Rows in second Matrix");
		}
		BigDecimal[][] result = new BigDecimal[m2][m1.length];
		
		return result;
		
	}*/
	
	public static BigDecimal multiplySingleRow(BigDecimal[] m1, BigDecimal[] m2){
		BigDecimal result = new BigDecimal(0.0);
		for(int i=0;i<m1.length;i++) {
			result = result.add( m1[i].multiply(m2[i]) );
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		System.out.println( MatrixUtil.multiplySingleRow(new BigDecimal[]{BigDecimal.ONE,  BigDecimal.ONE}, new BigDecimal[]{BigDecimal.valueOf(2), BigDecimal.valueOf(3)}) );
	}
	

	
}
