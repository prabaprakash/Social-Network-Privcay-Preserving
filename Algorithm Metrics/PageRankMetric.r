#Creating Graphs
source("F:/MSSE/10 SEM/SOURCE CODE/CreateGraph.R")
graph1<-CreateGraph()
graph2<-CreateGraph()
get.edge.attribute(graph1, "weight")
aa<-shortest.paths(graph1,v="180",to="683",mode=c("all"),algorithm=c("bellman-ford"))
ac<-distances(graph1,v="180",to="683",mode=c("all"),algorithm=c("bellman-ford"))
acac

ab<-get.all.shortest.paths(graph1,"180",to="683",mode=c("in"))
length(ab)
ch1<-layout_with_lgl(graph1)
ch2<-layout_with_lgl(graph2)
par(mfrow=c(1,2))
plot(graph1,layout=ch1)

plot(graph2,layout=ch2)

V(graph1)

degree(graph1)
degree(graph2)

