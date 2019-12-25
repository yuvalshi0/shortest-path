package com.hit.test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hit.algorithm.BellmanFordAlgo;
import com.hit.algorithm.IntegerWeightedEdge;
import com.hit.algorithm.IntegerWeightedGraph;

class BelmanFordAlgoTest {

	public IntegerWeightedGraph graph;
	BellmanFordAlgo<Integer,Integer> algo = new BellmanFordAlgo<Integer,Integer>();
	
	@BeforeEach
	void createSimpleGraph() {
		graph = new IntegerWeightedGraph();	
	}
	
	@Test
	void simpleSolutionTest() throws IOException {
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);

		graph.addEdge(new IntegerWeightedEdge(1, 2, 1));
		graph.addEdge(new IntegerWeightedEdge(1, 3, 2));
		
		int shortestPath = algo.compute(graph,1,2);
		assertEquals(1, shortestPath);
		
	}
	
	@Test
	void simpleSolutionTestWithMinus() throws IOException {
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		
		graph.addEdge(new IntegerWeightedEdge(1, 2, 1));
		graph.addEdge(new IntegerWeightedEdge(1, 3, 2));
		graph.addEdge(new IntegerWeightedEdge(2, 3, -1));

		int shortestPath = algo.compute(graph,1,3);
		assertEquals(0, shortestPath);
		
	}
	
	@Test
	public void MinusCircleTest() throws IOException {
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		
		graph.addEdge(new IntegerWeightedEdge(1, 2, 1));
		graph.addEdge(new IntegerWeightedEdge(2, 3, -5));
		graph.addEdge(new IntegerWeightedEdge(3, 1, -1));
		Assertions.assertThrows(IOException.class, () -> algo.compute(graph,1,2));
	}

}
