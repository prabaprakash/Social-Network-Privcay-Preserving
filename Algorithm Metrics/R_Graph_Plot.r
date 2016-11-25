library(igraph);
el=read.delim(sep=" ",file.choose());
el[,1]=as.character(el[,1])
el[,2]=as.character(el[,2])
el=as.matrix(el)
g=graph.edgelist(el[,1:2])
E(g)$weight=as.numeric(el[,3])
g=graph.data.frame(el,directed = FALSE)
#plot(g,layout=layout.fruchterman.reingold,edge.width=E(g)$weight/2)

plot( g, vertex.size=0, vertex.label=NA, edge.arrow.size=0 )

la<-layout_with_lgl(g)
plot(g,layout=la)
pr <- page.rank(g)
pr
//
  good<-degree(graph1)<10
gooda<-delete_vertices(graph1,good)
degree(gooda)

