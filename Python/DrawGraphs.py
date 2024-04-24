import networkx as nx
import matplotlib.pyplot as plt

def draw_graph(array):

    node = len(array)
    Graph = nx.DiGraph()

    #adds vertices
    for couple in array:
        Graph.add_node(couple[0])

    #adds edges
    for i, couple in enumerate(array):
        vertex, num = couple

        left_index = (i - num) % node
        right_index = (i + num) % node

        Graph.add_edge(vertex, array[left_index][0])
        Graph.add_edge(vertex, array[right_index][0])

    #draws graph
    pos = nx.spring_layout(Graph)  # Define the layout
    nx.draw(Graph, pos, with_labels=True, node_size=1500, node_color="red", font_size=10, font_weight="bold", arrowsize=15)
    plt.show()

#sample input
data = [['I', 2], ['A', 5], ['E', 4], ['F', 1], ['T', 2], ['S', 3]]
draw_graph(data)