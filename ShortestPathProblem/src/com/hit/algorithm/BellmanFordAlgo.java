package com.hit.algorithm;

import java.util.HashMap;

import com.hit.graph.AbstarctWeightedGraph;
import com.hit.graph.AbstractWeightedEdge;

public class BellmanFordAlgo<T,S extends Comparable<S>> extends AbstarctAlgoSPP<T,S> {

	
	//TODO: add minus cricle loop case
	@Override
	public S compute(AbstarctWeightedGraph<T,S> graph, T source, T destination) {
		int vertexSize = graph.getNodes().size();
		HashMap<T,S> distMap = new HashMap<>();
		
		for(T node : graph.getNodes()) {
			distMap.put(node, graph.getMaxToken());
		}
		distMap.put(source,graph.getZeroToken());
		
		
		for (int i = 1; i < vertexSize; i++) { 
            for (AbstractWeightedEdge<T,S> edge : graph.getEdges()) { 
                T u = edge.getSource();
                T v = edge.getDest(); 
                S currentPathPlusWeight = edge.addTo(distMap.get(u));
                S currentPathWeight = distMap.get(v);
                int isTheNewPathShorter = currentPathPlusWeight.compareTo(currentPathWeight);
                
                if (distMap.get(u) != graph.getMaxToken() && isTheNewPathShorter < 0) { 
                	distMap.put(v, currentPathPlusWeight); 
            } 
        }	
		
	}
		return distMap.get(destination);
	}
}