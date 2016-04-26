package com.saambh.costing;

public class Edge<T> {
  private T firstVertex;
  private T secondVertex;
  private Long weight;

  public Edge(T first_vertex, T second_vertex, Long weight) {
    this.firstVertex = first_vertex;
    this.secondVertex = second_vertex;
    this.weight = weight;
  }


  @Override
  public boolean equals(Object object) {
    Edge query = (Edge) object;
    return (this.firstVertex.equals(firstVertex)
        && this.secondVertex.equals(query.secondVertex)) ||
        (this.secondVertex.equals(query.firstVertex)
            && this.firstVertex.equals(query.secondVertex)) &&
            this.weight.equals(query.weight);
  }

  @Override
  public int hashCode() {
    return firstVertex.hashCode() + secondVertex.hashCode() + weight.hashCode();
  }

  public T getOtherVertex(Long s) {
    return s.equals(firstVertex) ? secondVertex : firstVertex;
  }

  public Long getWeight() {
    return weight;
  }

  public T getFirstVertex() {
    return firstVertex;
  }

  public T getSecondVertex() {
    return secondVertex;
  }
}
