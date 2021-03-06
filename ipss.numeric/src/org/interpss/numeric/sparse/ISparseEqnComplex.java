/*
 * @(#)SparseEqnComplex.java   
 *
 * Copyright (C) 2006-2011 www.interpss.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 12/10/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.numeric.sparse;

import org.apache.commons.math3.complex.Complex;
import org.interpss.numeric.exp.IpssNumericException;
import org.interpss.numeric.sparse.base.ISparseEqnObject;

import edu.emory.mathcs.csparsej.tdcomplex.DZcs_common.DZcsa;

/**
 * Sparse Equation of data type Complex for solving the [A]X=B problem. 
 * To outside, the index number is from 0 to n-1
 *
 */
public interface ISparseEqnComplex extends ISparseEqnObject<Complex, Complex> {
	/**
	 * Solve the [A]X = B problem  after the [A] is LUed
	 * 
	 * @param b the b vector
	 * @return the x vector
	 */
	DZcsa solveLUedEqn(DZcsa b) throws IpssNumericException;	
	
	/**
	 * Solve the [A]X = B problem after the [A] is LUed
	 * 
	 * @param b the b vector
	 * @return the x vector
	 */
	Complex[] solveLUedEqn(Complex[] b) throws IpssNumericException;	
	
	/**
	 * Multiply the complex matrix of the eqn with the array x
	 * 
	 * @param xAry
	 * @return
	 */
	Complex[] multiply(Complex[] xAry);
	
	/**
	 * Multiply the complex matrix of the eqn with the array x
	 * 
	 * @param xAry
	 * @return
	 */
	DZcsa multiply(DZcsa xAry);	
}
