package com.zhidisoft.util;
/**

 *
 */
public class QueryCriteria {
	
	
	private StringBuffer criteria = new StringBuffer();
	
	
	public QueryCriteria(){
		
	}
	/**
	 * @param ex
	 * @return
	 */
	public QueryCriteria add(Expression ex){
		if(ex.getExpression().length()>0){
			if(criteria.length()>0){
				criteria.append(" and ");
			}
			criteria.append(ex.getExpression());
		}
		return this;
	}
	
	/**
	 * @param ex
	 * @return
	 */
	public QueryCriteria or(Expression ex){
		if(ex.getExpression().length()>0){
			if(criteria.length()>0){
				criteria.append(" or ");
			}
			criteria.append(ex.getExpression());
		}
		return this;
	}
	
	public String toString(){
		return criteria.toString();
	}
	
}
