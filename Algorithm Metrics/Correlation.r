data=read.csv(file.choose())
library(ggplot2)
require(plyr)
a<-dlply(data, .(Type))
cor(a$Weight$Y,a$Length$Y)
cor(a$E_Weight$Y,a$E_Length$Y)



