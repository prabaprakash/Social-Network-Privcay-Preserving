source("F:/MSSE/10 SEM/SOURCE CODE/CreateGraph.R")
graph1<-CreateGraph()
graph2<-CreateGraph()
graph3<-CreateGraph()

# CLustering Coefficient
tr1<-transitivity(graph1)
tr2<-transitivity(graph2)
tr3<-transitivity(graph3)
# betweeness
aa<-betweenness(graph1, v=V(graph1), directed = FALSE)
bb<-betweenness(graph2, v=V(graph2), directed = FALSE)
cc<-betweenness(graph3, v=V(graph3), directed = FALSE)
plot( aa, type="o" ,col="red")
par(new=TRUE)
plot(bb, type="o", col="green" )
par(new=TRUE)
plot(cc, type="o", col="blue" )
#par(mfrow=c(1,2))
#plot( aa)
#plot( bb)
# Edge Betweeness
ea<-edge.betweenness(graph1, e=E(graph1), directed = TRUE)
eb<-edge.betweenness(graph2, e=E(graph2), directed = TRUE)
ec<-edge.betweenness(graph3, e=E(graph3), directed = TRUE)
plot( ea, type="o" ,col="red")
par(new=TRUE)
plot(eb, type="o", col="green" )
par(new=TRUE)
plot(eb, type="o", col="blue" )
# Closeness Betweeness
ca<-closeness(graph1, vids = V(graph1), mode = c("all"))
cb<-closeness(graph2, vids = V(graph2), mode = c("all"))
cc<-closeness(graph3, vids = V(graph3), mode = c("all"))


plot( ca, type="o" ,col="red")
par(new=TRUE)
plot(cb, type="o", col="green" )
par(new=TRUE)
plot(cc, type="o", col="blue" )
#Average Path Length
apa<-average.path.length(graph1, unconnected = TRUE)
apb<-average.path.length(graph2, unconnected = TRUE)

apc<-average.path.length(graph3, unconnected = TRUE)

aaaa<-all_shortest_paths(graph1,from = "180",to="683",mode = c("all"))
abb<-all_shortest_paths(graph1)


ac<-distances(graph1,v="180",to="683",mode=c("all"),algorithm=c("bellman-ford"))
shortest.paths(graph1,v="180")
get.shortest.paths(g,'v6')
ab<-get.all.shortest.paths(graph1,"180",to="683",mode=c("in"))


plot(ca,type="o")
df <- data.frame(ca,cb)
plot( ca, type="o" ,col="red")
par(new=TRUE)
plot(cb, type="o", col="green" )


