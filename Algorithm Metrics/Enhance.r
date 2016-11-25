greedy=read.csv(file.choose())
enhance=read.csv(file.choose())
library(ggplot2)
#Metrics,Difference from the Original Ones,Percentage


#ggplot(data=data, aes(x=Difference.from.the.Original.Ones, y=Percentage, group=1)) +geom_line()


ggplot(data=greedy, aes(x=Difference.from.the.Original.Ones, y=Percentage, group=Metrics,colour=Metrics)) +
  geom_line() +
  geom_point()


ggplot(data=enhance, aes(x=Difference.from.the.Original.Ones, y=Percentage, group=Metrics,colour=Metrics)) +
  geom_line() +
  geom_point()


