/*
 * @(#)SparseEquation.java   
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
package org.interpss.numeric.sparse.base;

import org.interpss.numeric.exp.IpssNumericException;

/**
 * Base Sparse Equation for solving sparse matrix problems.
 * 
 */
public interface ISparseEquation {
	public static enum IndexType { Row, Col };
	
	///////////////////////////////////////////////////////////////
	//////////// Square and Non-Square Matrix Function /////////////

	/**
	 * Check if the matrix is square
	 * 
	 * @return true if it is a square matrix
	 */
	boolean isSquareMatrix();

	/**
	 * Get the total elements in the matrix
	 * 
	 * @return the total elements
	 */
	int getTotalElements();	

	/**
	 * Set all b elements to 0.0 and bi = 1.0, a unity vector.
	 * 
	 * @param i the element row number
	 */
	void setB2Unity(final int i);
	
	/**
	 * Set all b elements to 0.0
	 * 
	 */
	void setB2Zero();

	/**
	 * Reset the matrix to zero - set all aii and bi to 0.0 and clear the sparse structure,
	 * and release memory if necessary
	 * 
	 */
	void reset();

	/**
	 * Reset all matrix element to zero, preserve the matrix sparse structure.
	 * 
	 */
	void setToZero();

	/**
	 * Flag to indicate if the matrix is factorized
	 * 
	 * @return the boolean flag
	 */
	boolean isFactorized();
	
	/**
	 * set the factorized flag
	 * 
	 * @param isLUFac the flag
	 */
	void setFactorized(boolean isLUFac);
	
	///////////////////////////////////////////////////////////////
	//////////// Square Matrix Only Function //////////////////////
	
	/**
	 * 	get matrix dimension.
     * 
     * @return the dimension
     */
	int getDimension();

	/**
	 * Increase matrix dimension by 1. B[n] = 0.0, aii(n)=1.0, aij(n)=0.0 
     * 
     * @param n
     */
	void increaseDimension();

	/**
	 * Factorization, for example LU decomposition, of the matrix.
	 * 
	 * @return if succeed return true.
	 */
	boolean factorization() throws IpssNumericException;
	
	/**
	 * Factorization, for example LU decomposition, of the matrix.
	 * 
	 * @param tolerance the tolerance for matrix singular detection
	 * @return if succeed return true.
	 */
	boolean factorization( final double tolerance) throws IpssNumericException;	
		
	/**
	 * LU decomposition of the matrix and the solve the [A]X = B problem.
	 * 
	 * @param tolerance the tolerance for matrix singular detection
	 * @return if succeed return true.
	 */
	boolean solveEqn( final double tolerance)  throws IpssNumericException;
		
	/**
	 * Solve the [A]X = B problem
	 * 
	 */
	void solveEqn() throws IpssNumericException;			
	
	/**
	 * During the LU process, aii might be zero. An exception will be thrown. This function
	 * is for getting zero aii row number for error reporting
	 * 
	 * @return the row number
	 */
	int getZeroAii_row();
	
	/**
	 * get cached bus id by the row number
	 * 
	 * @param row row number
	 * @return the bus id
	 */
	String getBusId(int row);
	
	/**
	 * set bus id corresponding to the row
	 * 
	 * @param row row number
	 * @param id bus id
	 */
	void setBusId(int row, String id);
	
	///////////////////////////////////////////////////////////////
	//////////// Non-Square Matrix Only Function //////////////////

	/**
	 * 	get matrix dimension.
     * 
     * @return the dimension
     */
	int getDimension(IndexType type);
}	