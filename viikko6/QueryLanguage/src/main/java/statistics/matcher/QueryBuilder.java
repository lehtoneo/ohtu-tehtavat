/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author ossij
 */
public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        matcher = new All();
    }
    
    public Matcher build() {
        Matcher h = matcher;
        this.matcher = new All();
        return h;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int i, String s) {
        this.matcher = new And(matcher, new HasAtLeast(i, s));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int i, String s) {
        this.matcher = new And(matcher, new Not( new HasAtLeast(i, s)));
        return this;
        
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }
    
    
}
