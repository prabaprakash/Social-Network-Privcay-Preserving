CreateGraph <- function(){
  library(igraph)
  el=read.delim(sep=" ",file.choose())
  el[,1]=as.character(el[,1])
  el[,2]=as.character(el[,2])
  el=as.matrix(el)
  g=graph.edgelist(el[,1:2])
  E(g)$weight=as.numeric(el[,3])
  g=graph.data.frame(el,directed = FALSE)
  E(g)$weight=as.numeric(el[,3])
  return (g);
}