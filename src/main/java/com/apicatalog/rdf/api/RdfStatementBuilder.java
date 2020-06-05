package com.apicatalog.rdf.api;

import com.apicatalog.iri.IRI;
import com.apicatalog.jsonld.lang.BlankNode;
import com.apicatalog.rdf.RdfSubject;

public final class RdfStatementBuilder {

    
    protected RdfStatementBuilder() {
        
    }

    public StatementPredicateBuilder blank(String label) {
        return null;
    }
    
    public StatementPredicateBuilder blank(BlankNode blankNode) {
        return null;
    }

    public StatementPredicateBuilder iri(String iri) {
        return null;
    }
    
    public StatementPredicateBuilder iri(IRI iri) {
        return null;
    }

    public StatementPredicateBuilder subject(RdfSubject subject) {
        return null;
    }
}
